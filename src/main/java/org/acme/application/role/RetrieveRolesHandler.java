package org.acme.application.role;

import org.acme.domain.role.Role;
import org.acme.domain.role.Roles;
import org.acme.kernel.query.QueryHandler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public final class RetrieveRolesHandler implements QueryHandler<RetrieveRoles, List<Role>> {

    @Inject
    Roles roles;

    @Override
    public List<Role> handle(RetrieveRoles query) {
        return this.roles.findAll();
    }
}
