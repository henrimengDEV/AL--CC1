package org.acme.exposition.role;

import java.util.List;

public final class RolesResponse {

    public List<RoleResponse> roles;

    public RolesResponse(List<RoleResponse> roles) {
        this.roles = roles;
    }
}
