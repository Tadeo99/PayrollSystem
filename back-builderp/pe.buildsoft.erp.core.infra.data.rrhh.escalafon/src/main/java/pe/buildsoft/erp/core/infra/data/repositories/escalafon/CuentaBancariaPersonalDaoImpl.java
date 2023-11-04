package pe.buildsoft.erp.core.infra.data.repositories.escalafon;

import java.util.HashMap;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import pe.buildsoft.erp.core.domain.entidades.escalafon.CuentaBancariaPersonal;
import pe.buildsoft.erp.core.domain.interfaces.repositories.escalafon.CuentaBancariaPersonalDaoLocal;
import pe.buildsoft.erp.core.infra.data.repositories.GenericEscalafonDAOImpl;
import pe.buildsoft.erp.core.infra.transversal.entidades.BaseSearch;
import pe.buildsoft.erp.core.infra.transversal.utilitario.StringUtil;
import pe.buildsoft.erp.core.infra.transversal.utilitario.UUIDUtil;

/**
 * La Class CuentaBancariaPersonalDaoImpl.
 * <ul>
 * <li>Copyright 2020 ndavilal - ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Wed Jul 22 00:55:19 COT 2020
 * @since BUILDERP-CORE 2.1
 */
@Stateless
public class CuentaBancariaPersonalDaoImpl extends GenericEscalafonDAOImpl<String, CuentaBancariaPersonal>
		implements CuentaBancariaPersonalDaoLocal {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.com.builderp.core.service.rrhh.dao.local.CuentaBancariaPersonalDaoLocal#
	 * listarCuentaBancariaPersonal(pe.com.builderp.core.service.rrhh.model.jpa.
	 * CuentaBancariaPersonal)
	 */
	@Override
	public List<CuentaBancariaPersonal> listar(BaseSearch filtro) {
		var query = generarQuery(filtro, false);
		return query.getResultList();
	}

	/**
	 * Generar query lista CuentaBancariaPersonal.
	 *
	 * @param CuentaBancariaPersonal el cuentaBancariaPersonal
	 * @param esContador             el es contador
	 * @return the query
	 */
	private Query generarQuery(BaseSearch filtro, boolean esContador) {
		var parametros = new HashMap<String, Object>();
		var jpaql = new StringBuilder();
		if (esContador) {
			jpaql.append(" select count(o.idCuentaBancariaPersonal) from CuentaBancariaPersonal o where 1=1 ");
		} else {
			jpaql.append(" select o from CuentaBancariaPersonal o where 1=1 ");
		}
		if (filtro.getListaIdPersonal() != null && filtro.getListaIdPersonal().size() > 0) {
			jpaql.append(" and o.personal.idPersonal in (:listadoIdPersonal) ");
			parametros.put("listadoIdPersonal", filtro.getListaIdPersonal());
		}
		if (!StringUtil.isNullOrEmpty(filtro.getSearch())) {
			jpaql.append(" and upper(o.nroCuenta) like :search ");
			parametros.put("search", "%" + filtro.getSearch().toUpperCase() + "%");
		}
		if (!esContador && StringUtil.isNotNullOrBlank(filtro.getSortFields())) {
			jpaql.append(" ORDER BY " + filtro.getSortFields() + " " + filtro.getSortDirections());
		}
		return createQuery(jpaql.toString(), parametros);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.com.builderp.core.service.rrhh.dao.local.CuentaBancariaPersonalDaoLocal#
	 * contarListar{entity.getClassName()}(pe.com.builderp.core.service.rrhh.model.
	 * jpa.CuentaBancariaPersonal)
	 */
	@Override
	public int contar(BaseSearch filtro) {
		var query = generarQuery(filtro, true);
		return ((Long) query.getSingleResult()).intValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.com.builderp.core.service.rrhh.dao.local.CuentaBancariaPersonalDaoLocal#
	 * generarIdCuentaBancariaPersonal()
	 */
	@Override
	public String generarId() {
		return UUIDUtil.generarElementUUID();
	}

}