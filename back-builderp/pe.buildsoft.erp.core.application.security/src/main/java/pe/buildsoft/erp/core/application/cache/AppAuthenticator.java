package pe.buildsoft.erp.core.application.cache;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;

import javax.security.auth.login.LoginException;

import pe.buildsoft.erp.core.application.entidades.security.UsuarioDTO;
import pe.buildsoft.erp.core.application.interfaces.aas.AasAppServiceLocal;
import pe.buildsoft.erp.core.infra.transversal.cache.ICache;
import pe.buildsoft.erp.core.infra.transversal.cache.IJWT;
import pe.buildsoft.erp.core.infra.transversal.utilitario.AppHttpHeaderNames;
import pe.buildsoft.erp.core.infra.transversal.utilitario.FechaUtil;
import pe.buildsoft.erp.core.infra.transversal.utilitario.SerializationUtil;
import pe.buildsoft.erp.core.infra.transversal.utilitario.jwt.JWTokenUtility;

@Startup
@Singleton
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
@TransactionManagement(TransactionManagementType.BEAN)
public class AppAuthenticator implements IAppAuthenticator {

	@Inject
	private AasAppServiceLocal seguridadServiceLocal;

	@Inject
	private ICache cacheUtil;

	@Inject
	private IJWT jwt;

	@PostConstruct
	public void initialize() {
		// The usersStorage pretty much represents a user table in the database

		/**
		 * Service keys are pre-generated by the system and is given to the authorized
		 * client who wants to have access to the REST API. Here, only username1 and
		 * username2 is given the REST service access with their respective service
		 * keys.
		 */
		cacheUtil.put(AppHttpHeaderNames.SERVICE_KEY_VALUE, new HashMap<>());
	}

	public synchronized Map<String, Object> login(String serviceKey, String userName, String userPassword)
			throws LoginException {
		Map<String, Object> resultado = new HashMap<>();
		if (cacheUtil.containsKey(serviceKey)) {
			UsuarioDTO usuario = seguridadServiceLocal.validarLogin(userName, userPassword);
			usuario.setId(usuario.getIdUsuario());
			if (usuario != null) {
				Map<String, String> userMap = (Map<String, String>) cacheUtil.get(serviceKey);
				if (userMap == null) {
					userMap = new HashMap<>();
				}
				userMap.put(userName, userName);
				cacheUtil.put(userPassword, userMap);
				/**
				 * Once all params are matched, the authToken will be generated and will be
				 * stored in the authorizationTokensStorage. The authToken will be needed for
				 * every REST API invocation and is only valid within the login session
				 */
				String authToken = JWTokenUtility.buildJWT(userName);
				usuario.setFechaUltimoAcceso(FechaUtil.obtenerFechaActual());
				String usuarioBase64 = SerializationUtil.toString(usuario);
				cacheUtil.put(authToken, usuarioBase64);
				cacheUtil.put(authToken + ICache.USER, userName);
				cacheUtil.put(authToken + ICache.ID_ENTIDAD_SELECT, usuario.getIdEntidadSelect());
				cacheUtil.put(authToken + ICache.USER_NOMBRES,
						usuario.getNombre() + " " + usuario.getApellidoPaterno() + " " + usuario.getApellidoMaterno());
				cacheUtil.put(authToken + ICache.FECHA_ULTIMO_ACCESO, usuario.getFechaUltimoAcceso());
				cacheUtil.put(userName, usuarioBase64);
				cacheUtil.put(serviceKey, userMap);
				cacheUtil.put(ICache.KEY, JWTokenUtility.getKey());

				resultado.put("authToken", authToken);
				resultado.put("usuario", usuario);

				return resultado;
			} else {
				throw new LoginException("No se puedo validar login usuario null");
			}
		} else {
			throw new LoginException("No se puedo validar login sin serviceKey");
		}
	}

	/**
	 * The method that pre-validates if the client which invokes the REST API is
	 * from a authorized and authenticated source.
	 *
	 * @param serviceKey The service key
	 * @param authToken  The authorization token generated after login
	 * @return TRUE for acceptance and FALSE for denied.
	 */
	public boolean isAuthTokenValid(String serviceKey, String authToken) {
		return jwt.isAuthTokenValid(serviceKey, authToken);
	}

	private Object get(String authToken) {
		return cacheUtil.get(authToken);
	}

	/**
	 * This method checks is the service key is valid
	 *
	 * @param serviceKey
	 * @return TRUE if service key matches the pre-generated ones in service key
	 *         storage. FALSE for otherwise.
	 */
	public boolean isServiceKeyValid(String serviceKey) {
		return jwt.isServiceKeyValid(serviceKey);
	}

	public void logout(String serviceKey, String authToken) throws GeneralSecurityException {
		jwt.logout(serviceKey, authToken);
	}

	public UsuarioDTO getUsuario(String serviceKey, String authToken) {
		if (cacheUtil.containsKey(serviceKey)) {
			return (UsuarioDTO) get(authToken);
		}
		return null;

	}

	public synchronized boolean isSessionActiva(String serviceKey, String authToken) {
		return jwt.isSessionActiva(serviceKey, authToken);

	}

	public String getUserName(String authToken) {
		return ((UsuarioDTO) get(authToken)).getUserName();
	}

	public UsuarioDTO getByUserName(String userName) {
		return (UsuarioDTO) get(userName);
	}
}