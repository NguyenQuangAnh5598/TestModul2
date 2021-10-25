package model;

public class Phonebook {
    private String group;
    private String name;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String address;
    private String email;

    public Phonebook() {
    }

    public Phonebook(String group,String name,String dateOfBirth, String gender, String phoneNumber, String address, String email) {
        this.group = group;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Phonebook { " +
                " name ='" + name + '\'' +
                " , gender ='" + gender + '\'' +
                " , phoneNumber = '" + phoneNumber + '\'' +
                " , address='" + address + '\'' +
                " , email = '" + email + '\'' +
                " }";
    }
}
