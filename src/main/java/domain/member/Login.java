package domain.member;

import domain.common.exception.IncorrectEmailException;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.Objects;

public class Login {

    private final String email;
    private final String password;

    private Login(String email, String password) {
        if (!isValidEmail(email)) {
            throw new IncorrectEmailException(String.format("'%s' is not a valid email.", email));
        }

        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);
    }

    public static Login of(String email, String password) {
        return new Login(email, password);
    }

    private boolean isValidEmail(String email) {
        return EmailValidator.getInstance().isValid(email);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "MemberLogin{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
