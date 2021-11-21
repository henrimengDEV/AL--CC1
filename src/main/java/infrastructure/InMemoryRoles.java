package infrastructure;

import domain.common.exception.NoSuchRoleException;
import domain.member.MemberId;
import domain.notifier.EmailNotifierEngine;
import domain.notifier.EmailNotifierEngineFactory;
import domain.role.Role;
import domain.role.Role;
import domain.role.RoleId;
import domain.role.Roles;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InMemoryRoles implements Roles {

    private final AtomicInteger count = new AtomicInteger(0);
    private final Map<RoleId, Role> data = new ConcurrentHashMap<>();

    @Override
    public RoleId nextIdentify() {
        return RoleId.of(count.incrementAndGet());
    }

    @Override
    public Role findByName(String name) {
        Optional<Role> role = this.data.values()
                .stream()
                .filter(it -> it.getName().equals(name))
                .findFirst();

        if (role.isPresent()) {
            return role.get();
        } else {
            throw new NoSuchRoleException(String.format("No role found with name %s.", name));
        }
    }

    @Override
    public void add(Role role) {
        this.data.put(role.getId(), role);
    }

}
