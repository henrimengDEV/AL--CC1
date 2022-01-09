package org.acme.domain.role;

import java.util.List;


public interface Roles {

    List<Role> findAll();

    Role findById(RoleId roleId);
}
