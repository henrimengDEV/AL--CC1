package org.acme.domain.role;

public final class Role {

    private final RoleId id;
    private final String name;

    private Role(RoleId id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Role of(RoleId id, String name) {
        return new Role(id, name);
    }

    public RoleId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
