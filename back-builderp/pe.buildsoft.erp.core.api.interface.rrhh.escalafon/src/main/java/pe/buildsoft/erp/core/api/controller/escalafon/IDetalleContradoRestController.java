package pe.buildsoft.erp.core.api.controller.escalafon;

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
import pe.buildsoft.erp.core.application.entidades.escalafon.DetalleContradoDTO;

/**
 * La Class DetalleContradoRestController.
 * <ul>
 * <li>Copyright 2020 ndavilal - ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Fri Apr 23 00:16:11 COT 2021
 * @since BUILDERP-CORE 2.1
 */
@Tag(name = "/detalleContrado", description = "Escalafon Service")
@OpenAPIDefinition(info = @Info(title = "Servicios de Escalafon", version = "0.0", description = "Escalafon Service"),tags = { @Tag(name = "Escalafon Service", description = "Servicios de Escalafon") })
@Path("/detalleContrado")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IDetalleContradoRestController {

	@POST
	Response crear(DetalleContradoDTO obj);

	@PUT
	@Path("/{id}")
	Response modificar(DetalleContradoDTO obj);

	@DELETE
	@Path("/{id}")
	Response eliminar(@PathParam("id") String id);

	@GET
	@Path("/{id}")
	Response finById(@PathParam("id") String id);

	@GET
	Response paginador(@Context HttpHeaders headers, @Context UriInfo info);
}