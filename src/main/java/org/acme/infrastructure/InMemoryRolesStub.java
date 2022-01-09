package org.acme.infrastructure;

import org.acme.domain.role.Role;
import org.acme.domain.role.RoleId;
import org.acme.domain.role.Roles;
import org.acme.kernel.exception.NoSuchEntityException;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

@ApplicationScoped
public class InMemoryRolesStub implements Roles {

    private final Logger log = Logger.getLogger(InMemoryRolesStub.class.getName());
    private final AtomicInteger count = new AtomicInteger(0);
    private final Map<RoleId, Role> data = new ConcurrentHashMap<>() {{
        put(
                RoleId.of(count.incrementAndGet()),
                Role.of(RoleId.of(count.get()), "ADMIN")
        );
        put(
                RoleId.of(count.incrementAndGet()),
                Role.of(RoleId.of(count.get()), "TRADESMAN")
        );
        put(
                RoleId.of(count.incrementAndGet()),
                Role.of(RoleId.of(count.get()), "CONTRACTOR")
        );
    }};

    @Override
    public List<Role> findAll() {
        log.info("--> findAll ROLES");
        return List.copyOf(data.values());
    }

    @Override
    public Role findById(RoleId roleId) {
        log.info(String.format("--> findById(%s) ROLE", roleId));
        Role role = this.data.get(roleId);

        if (role == null) throw NoSuchEntityException.withId(roleId.getValue());

        return role;
    }
}
