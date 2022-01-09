package org.acme.application.role;

import org.acme.domain.role.Role;
import org.acme.domain.role.Roles;
import org.acme.kernel.query.QueryHandler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public final class RetrieveRoleByIdHandler implements QueryHandler<RetrieveRoleById, Role> {

    @Inject
    Roles roles;

    @Override
    public Role handle(RetrieveRoleById query) {
        return this.roles.findById(query.id);
    }
}
