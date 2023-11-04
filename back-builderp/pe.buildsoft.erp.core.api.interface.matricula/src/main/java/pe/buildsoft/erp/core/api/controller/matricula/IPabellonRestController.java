package pe.buildsoft.erp.core.api.controller.matricula;

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
import pe.buildsoft.erp.core.application.entidades.matricula.PabellonDTO;

/**
 * La Class PabellonRestController.
 * <ul>
 * <li>Copyright 2020 ndavilal - ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Thu Apr 22 21:45:24 COT 2021
 * @since BUILDERP-CORE 2.1
 */
@Tag(name = "/pabellon", description = "Matricula Service")
@OpenAPIDefinition(info = @Info(title = "Servicios de Matricula", version = "0.0", description = "Matricula Service"),tags = { @Tag(name = "Matricula Service", description = "Servicios de Matricula") })
@Path("/pabellon")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IPabellonRestController {

	@POST
	Response crear(PabellonDTO obj);

	@PUT
	@Path("/{id}")
	Response modificar(PabellonDTO obj);

	@DELETE
	@Path("/{id}")
	Response eliminar(@PathParam("id") Long id);

	@GET
	@Path("/{id}")
	Response finById(@PathParam("id") Long id);

	@GET
	Response paginador(@Context HttpHeaders headers, @Context UriInfo info);

	@POST
	@Path("/find") // TODO:VER
	Response findPabellon(PabellonDTO filtro);
}