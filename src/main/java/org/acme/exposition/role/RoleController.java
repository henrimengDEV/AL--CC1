package org.acme.exposition.role;

import org.acme.application.role.RetrieveRoleById;
import org.acme.application.role.RetrieveRoleByIdHandler;
import org.acme.application.role.RetrieveRoles;
import org.acme.application.role.RetrieveRolesHandler;
import org.acme.domain.role.Role;
import org.acme.domain.role.RoleId;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/api/roles")
public final class RoleController {

    private RetrieveRoleByIdHandler retrieveById;
    private RetrieveRolesHandler retrieveAll;

    @Inject
    public RoleController(RetrieveRoleByIdHandler retrieveById, RetrieveRolesHandler retrieveAll) {
        this.retrieveById = retrieveById;
        this.retrieveAll = retrieveAll;
    }

    @GET
    @Path("/")
    public Response getAll() {
        try {
            RolesResponse result = new RolesResponse(
                    this.retrieveAll.handle(new RetrieveRoles())
                            .stream()
                            .map(RoleResponse::of)
                            .collect(Collectors.toUnmodifiableList())
            );
            return Response.ok(result).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getRole(@PathParam("id") int id) {
        try {
            RoleResponse result = RoleResponse.of(this.retrieveById.handle(new RetrieveRoleById(RoleId.of(id))));
            return Response.ok(result).build();
        } catch (Exception e) {
            return Response.serverError().status(404).build();
        }
    }
}
