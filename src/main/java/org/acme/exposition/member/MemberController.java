package org.acme.exposition.member;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;
import org.acme.application.member.command.*;
import org.acme.application.member.query.RetrieveMemberById;
import org.acme.application.member.query.RetrieveMemberByIdHandler;
import org.acme.application.member.query.RetrieveMembers;
import org.acme.application.member.query.RetrieveMembersHandler;
import org.acme.domain.member.Member;
import org.acme.domain.member.MemberId;
import org.acme.domain.member.MemberLogin;
import org.acme.domain.role.Role;
import org.acme.domain.role.RoleId;
import org.acme.domain.role.Roles;
import org.acme.exposition.member.request.MemberRequest;
import org.acme.exposition.member.response.MemberResponse;
import org.acme.exposition.member.response.MembersResponse;

import java.util.stream.Collectors;

@Path("/api/member")
public final class MemberController {

    private CreateMemberHandler create;
    private UpdateMemberHandler update;
    private DeleteMemberHandler delete;
    private RetrieveMembersHandler retrieveAll;
    private RetrieveMemberByIdHandler retrieveById;
    private Roles roles;

    @Inject
    public MemberController(CreateMemberHandler create, UpdateMemberHandler update, DeleteMemberHandler delete, RetrieveMembersHandler retrieveAll, RetrieveMemberByIdHandler retrieveById, Roles roles) {
        this.create = create;
        this.update = update;
        this.delete = delete;
        this.retrieveAll = retrieveAll;
        this.retrieveById = retrieveById;
        this.roles = roles;
    }

    @GET
    @Path("/")
    public Response getAll() {
        try {
            MembersResponse result = new MembersResponse(
                    this.retrieveAll.handle(new RetrieveMembers())
                            .stream()
                            .map(MemberResponse::of)
                            .collect(Collectors.toUnmodifiableList())
            );
            return Response.ok(result).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getMember(@PathParam("id") int id) {
        try {
            MemberResponse result = MemberResponse.of(this.retrieveById.handle(new RetrieveMemberById(MemberId.of(id))));
            return Response.ok(result).build();
        } catch (Exception e) {
            return Response.serverError().status(404).build();
        }
    }

    @POST
    @Path("/create")
    public Response postMember(MemberRequest memberRequest) {
        System.out.println(memberRequest);
        try {
            Role role = this.roles.findById(RoleId.of(Integer.parseInt(memberRequest.roleId)));
            CreateMember stub = new CreateMember(
                    memberRequest.firstName,
                    memberRequest.lastName,
                    memberRequest.login,
                    role);

            MemberResponse result = MemberResponse.of(this.create.handle(stub));
            return Response.ok(result).status(201).build();
//            return Response.created(new URI("http://localhost:8080/api/member/" + result.getId())).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}/update")
    public Response putMember(@PathParam("id") int id) {
        try {
            UpdateMember stub = new UpdateMember(
                    MemberId.of(id),
                    "Henri",
                    "MENG",
                    MemberLogin.of("oH777t67@mail.fr", "7t8jK8t7t8jK8t"));

            this.update.handle(stub);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @JacksonFeatures(serializationEnable = {SerializationFeature.INDENT_OUTPUT})
    @Path("/{id}/delete")
    public Response removeMember(@PathParam("id") int id) {
        try {
            this.delete.handle(new DeleteMember(MemberId.of(id)));
            return Response.accepted().build();
        } catch (Exception e) {
            return Response.serverError().status(404).build();
        }
    }
}