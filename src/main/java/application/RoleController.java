package application;

import domain.role.CreateRole;
import domain.role.RoleId;
import domain.role.RoleService;

public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    public RoleId createFromRequest(CreateRole createRole) {
        return this.roleService.handle(createRole);
    }
}
