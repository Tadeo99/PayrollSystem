package pe.buildsoft.erp.core.api.controller.pago;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import pe.buildsoft.erp.core.application.entidades.pago.ClasificacionDTO;
import pe.buildsoft.erp.core.application.interfaces.pago.PagoAppServiceLocal;
import pe.buildsoft.erp.core.infra.transversal.entidades.vo.RespuestaWSVO;
import pe.buildsoft.erp.core.infra.transversal.type.AccionType;
import pe.buildsoft.erp.core.infra.transversal.util.GenericServiceRestImpl;

/**
 * La Class ClasificacionRestController.
 * <ul>
 * <li>Copyright 2020 ndavilal - ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Thu Apr 22 21:45:29 COT 2021
 * @since BUILDERP-CORE 2.1
 */
@Path("/clasificacion")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClasificacionRestController extends GenericServiceRestImpl implements IClasificacionRestController {

	private Logger log = LoggerFactory.getLogger(ClasificacionRestController.class);

	@Inject
	private PagoAppServiceLocal servicioApp;

	@POST
	public Response crear(ClasificacionDTO obj) {
		return controladorAccion(obj, AccionType.CREAR);
	}

	@PUT
	@Path("/{id}")
	public Response modificar(ClasificacionDTO obj) {
		return controladorAccion(obj, AccionType.MODIFICAR);
	}

	@DELETE
	@Path("/{id}")
	public Response eliminar(@PathParam("id") Long id) {
		ClasificacionDTO obj = new ClasificacionDTO();
		obj.setIdClasificacion(id);
		return controladorAccion(obj, AccionType.ELIMINAR);
	}

	private Response controladorAccion(ClasificacionDTO clasificacion, AccionType accionType) {
		RespuestaWSVO<ClasificacionDTO> resultado = new RespuestaWSVO<>();
		try {
			resultado.setObjetoResultado(servicioApp.controladorAccionClasificacion(clasificacion, accionType));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return respuesta(resultado, accionType);
	}

	@GET
	@Path("/{id}")
	public Response finById(@PathParam("id") Long id) {
		ClasificacionDTO filtro = new ClasificacionDTO();
		filtro.setIdClasificacion(id);
		return controladorAccion(filtro, AccionType.FIND_BY_ID);
	}

	@GET
	public Response paginador(@Context HttpHeaders headers, @Context UriInfo info) {
		RespuestaWSVO<ClasificacionDTO> resultado = new RespuestaWSVO<>();
		try {
			var filtro = to(info);
			if (filtro.getStartRow() == 0 || resultado.getContador() == 0)
				resultado.setContador(servicioApp.contarListarClasificacion(filtro));
			if (resultado.isData() || filtro.getStartRow() > 0) {
				resultado.setListaResultado(servicioApp.listarClasificacion(filtro));
			}
		} catch (Exception e) {
			log.error("paginador", e);
			parsearResultadoError(e, resultado);
		}
		return respuesta(resultado, null, info);
	}

	@POST
	@Path("/find")
	public Response find(ClasificacionDTO fintro) {
		RespuestaWSVO<ClasificacionDTO> resultado = new RespuestaWSVO<>();
		try {
			resultado.setObjetoResultado(servicioApp.findClasificacion(fintro));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return respuesta(resultado, null);
	}
}