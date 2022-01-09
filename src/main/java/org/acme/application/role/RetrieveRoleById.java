package org.acme.application.role;

import org.acme.domain.role.RoleId;
import org.acme.kernel.query.Query;

public final class RetrieveRoleById implements Query {

    public RoleId id;

    public RetrieveRoleById(RoleId id) {
        this.id = id;
    }
}
