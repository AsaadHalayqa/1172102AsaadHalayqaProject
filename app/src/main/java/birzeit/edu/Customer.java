package birzeit.edu;

public class Customer {
    String Email;
    String FirstName;
    String LastName;
    String Password;
    String PhoneNumber;
    String gendar;

    public Customer() {
    }

    public Customer(String email, String firstName, String lastName, String password, String phoneNumber, String gendar) {
        Email = email;
        FirstName = firstName;
        LastName = lastName;
        Password = password;
        PhoneNumber = phoneNumber;
        this.gendar = gendar;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setGendar(String gendar) {
        this.gendar = gendar;
    }

    public String getEmail() {
        return Email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPassword() {
        return Password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getGendar() {
        return gendar;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Email='" + Email + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Password='" + Password + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", gendar='" + gendar + '\'' +
                '}';
    }
}

