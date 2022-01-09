package org.acme.domain.member;

import org.acme.domain.role.Role;

import javax.management.InvalidAttributeValueException;
import java.util.List;

public final class MemberRoles {

    private final List<Role> value;

    private MemberRoles(List<Role> value) {
        if (isEmpty(value))
            throw new InvalidMemberAttributeValueException("Should have at least 1 role");

        this.value = value;
    }

    public static MemberRoles of(List<Role> value) {
        return new MemberRoles(value);
    }

    public boolean isEmpty(List<Role> roles) {
        return roles.size() < 1;
    }
}
