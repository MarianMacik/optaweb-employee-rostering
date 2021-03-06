package org.optaweb.employeerostering.shared.rotation;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.nmorel.gwtjackson.rest.processor.GenRestBuilder;
import io.swagger.annotations.Api;
import org.optaweb.employeerostering.shared.rotation.view.ShiftTemplateView;

@Api(tags = {"Rotation"})
@Path("/tenant/{tenantId}/rotation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@GenRestBuilder
public interface RotationRestService {

    @GET
    @Path("/")
    List<ShiftTemplateView> getShiftTemplateList(@PathParam("tenantId") Integer tenantId);

    @GET
    @Path("/{id}")
    ShiftTemplateView getShiftTemplate(@PathParam("tenantId") Integer tenantId, @PathParam("id") Long id);

    /**
     * @param shiftTemplate never null, without an id/version
     * @return never null, the added ShiftTemplate with id/version
     */
    @POST
    @Path("/add")
    ShiftTemplateView addShiftTemplate(@PathParam("tenantId") Integer tenantId, ShiftTemplateView shiftTemplate);

    /**
     * @param shiftTemplate never null
     */
    @PUT
    @Path("/update")
    ShiftTemplateView updateShiftTemplate(@PathParam("tenantId") Integer tenantId, ShiftTemplateView shiftTemplate);

    /**
     * @param id never null
     * @return return true if the ShiftTemplate was removed, false otherwise
     */
    @DELETE
    @Path("/{id}")
    Boolean removeShiftTemplate(@PathParam("tenantId") Integer tenantId, @PathParam("id") Long id);
}
