package pe.buildsoft.erp.core.api.controller.planilla;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

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
import pe.buildsoft.erp.core.application.entidades.planilla.ConceptoFijosTrabajadorDTO;

/**
 * La Class Fijos.
 * <ul>
 * <li>Copyright 2020 ndavilal - ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Fri Apr 23 00:16:11 COT 2021
 * @since BUILDERP-CORE 2.1
 */
@Tag(name = "/personal", description = "Planilla Service")
@OpenAPIDefinition(info = @Info(title = "Servicios de Planilla", version = "0.0", description = "Planilla Service"), tags = {
		@Tag(name = "Planilla Service", description = "Servicios de Planilla") })
@Path("/personal")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IConceptoFijoTrabajadorRestController {
	@POST
	@Path("/{idPersonal}/conceptoFijo")
	Response crear(@PathParam("idPersonal") String idPersonal, ConceptoFijosTrabajadorDTO obj);

	@PUT
	@Path("/{idPersonal}/conceptoFijo/{id}")
	Response modificar(@PathParam("idPersonal") String idPersonal, ConceptoFijosTrabajadorDTO obj);

	@DELETE
	@Path("/{idPersonal}/conceptoFijo/{id}")
	Response eliminar(@PathParam("idPersonal") String idPersonal, @PathParam("id") String id);

	@GET
	@Path("/{idPersonal}/conceptoFijo/{id}")
	Response finById(@PathParam("idPersonal") String idPersonal, @PathParam("id") String id);

	@GET
	@Path("/{idPersonal}/conceptoFijos")
	Response paginador(@PathParam("idPersonal") String idPersonal, @Context HttpHeaders headers, @Context UriInfo info);
}