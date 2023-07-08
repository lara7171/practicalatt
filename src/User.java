import java.util.Objects;

public class User {
    private String login;
    private String pass;
    private String email;
    private String telephone;
    private String fname;
    private String patronymic;
    private String sname;

    public User(String login, String pass, String email, String telephone, String fname, String patronymic, String sname) {
        this.login = login;
        this.pass = pass;
        this.email = email;
        this.telephone = telephone;
        this.fname = fname;
        this.patronymic = patronymic;
        this.sname = sname;
    }

    public User() {

    }


    public String getLogin() {
        return login;
    }

    public boolean setLogin(String login) {
        if (login.matches("[a-zA-Z0-9]*")) {
            this.login = login;
            return true;
        } else {
            System.out.println("Введите корректные значения");
            return false;
        }
    }


    public String getPass() {
        return pass;
    }

    public boolean setPass(String pass) {
        if (pass.matches("[a-zA-Z0-9]*")) {
            this.pass = pass;
            return true;
        } else {
            System.out.println("Введите корректные значения");
            return false;
        }
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if (email.matches("[a-zA-Z0-9)]*@[a-z]*\\.[a-z]{2,4}")) {
            this.email = email;
            return true;
        } else {
            System.out.println("Введите корректные значения");
            return false;
        }
    }

    public String getTelephone() {
        return telephone;
    }

    public boolean setTelephone(String telephone) {
        if (telephone.matches("(\\+7|7|8)+(\\d{10})")) {
            this.telephone = telephone;
            return true;
        } else {
            System.out.println("Введите корректные значения");
            return false;
        }
    }


    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void printInfo() {
        System.out.println(login + " " + pass + " " + email + " " + telephone + " " + fname + " " + patronymic + " " + sname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(login, user.login)) return false;
        return Objects.equals(pass, user.pass);
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getLogin() + " " + getPass() + " " + getEmail() + " " + getTelephone() + " " + getFname() + " " + getPatronymic() + " " + getSname();
    }
}
