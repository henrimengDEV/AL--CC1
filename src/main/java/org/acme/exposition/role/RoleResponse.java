package org.acme.exposition.role;

import org.acme.domain.role.Role;

public final class RoleResponse {

    public String id;
    public String name;

    private RoleResponse(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static RoleResponse of(Role role) {
        return new RoleResponse(role.getId().toString(), role.getName());
    }
}