package domain.role;

import kernel.Repository;

@Repository(value = "Roles")
public interface Roles {

    RoleId nextIdentify();

    Role findByName(String name);

    void add(Role role);
}
