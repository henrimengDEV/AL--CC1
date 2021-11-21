package domain.member;

public final class CreateMember {

    public String firstName;
    public String lastName;
    public Login login;

    public CreateMember(String firstName, String lastName, Login login) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
    }
}
