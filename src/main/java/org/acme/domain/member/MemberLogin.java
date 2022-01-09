package org.acme.domain.member;

import java.util.Objects;

import org.apache.commons.validator.routines.EmailValidator;

public final class MemberLogin {

    private final String email;
    private final String password;

    private MemberLogin(String email, String password) {
        if (!EmailValidator.getInstance().isValid(email))
            throw new InvalidMemberAttributeValueException(String.format("'%s' is not an email", email));
        if (!this.passwordIsValid(password))
            throw new InvalidMemberAttributeValueException(String.format("'%s' is not a correct password", password));

        this.email = email;
        this.password = password;
    }

    public static MemberLogin of(String email, String password) {
        return new MemberLogin(email, password);
    }

    private boolean passwordIsValid(String password) {
        Objects.requireNonNull(password);
        return (password.length() > 6);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
