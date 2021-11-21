package domain.role;

import domain.common.LoggerService;

public class RoleService {

    private final LoggerService logger;
    private final Roles roles;

    public RoleService(LoggerService logger, Roles roles) {
        this.logger = logger;
        this.roles = roles;
    }

    public RoleId handle(CreateRole createRole) {
        this.logger.log("Handle Role...");

        final RoleId roleId = this.roles.nextIdentify();
        Role role = Role.of(
                roleId,
                createRole.name,
                createRole.price
        );
        this.roles.add(role);

        this.logger.log("...Successful : " + role);
        return roleId;
    }

    public Role findByName(String name) {
        this.logger.log("Find a role by name...");
        Role role = this.roles.findByName(name);
        this.logger.log("...Successful : " + role);
        return role;
    }
}
