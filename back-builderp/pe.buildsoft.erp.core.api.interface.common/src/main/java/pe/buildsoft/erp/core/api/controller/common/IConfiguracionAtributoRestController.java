package pe.buildsoft.erp.core.api.controller.common;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.ws.rs.Consumes;
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
import pe.buildsoft.erp.core.application.entidades.common.ConfiguracionAtributoDTO;

/**
 * La Class ConfiguracionAtributoRestController.
 * <ul>
 * <li>Copyright 2017 ndavilal - ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Thu Dec 28 12:02:21 COT 2017
 * @since SIAA-CORE 2.1
 */
@Tag(name = "/configuracionAtributo", description = "Common Service")
@OpenAPIDefinition(info = @Info(title = "Servicios de Common", version = "0.0", description = "Common Service"),tags = { @Tag(name = "Common Service", description = "Servicios de Common") })
@Path("/configuracionAtributo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IConfiguracionAtributoRestController {

	@POST
	Response crear(List<ConfiguracionAtributoDTO> listaObj);

	@POST
	@Path("/eliminacion")
	Response eliminarConfiguracionAtributoValue(List<ConfiguracionAtributoDTO> filtro);

	@POST
	Response crear(ConfiguracionAtributoDTO obj);

	@PUT
	@Path("/{id}")
	Response modificar(ConfiguracionAtributoDTO obj);

	@GET
	@Path("/{id}")
	Response eliminar(@PathParam("id") String id);

	@GET
	@Path("/{id}")
	Response finById(@PathParam("id") String id);

	@GET
	Response paginador(@Context HttpHeaders headers, @Context UriInfo info);
}