package model;

public record ContactData(String firstName, String lastName, String address, String mobile, String email) {
    public ContactData(){
        this ("", "", "", "", "");
    }

    public ContactData withFirstName(String firstName) {
        return new ContactData(firstName, this.lastName, this.address, this.mobile, this.email);
    }
    public ContactData withLastName(String lastName) {
        return new ContactData(this.firstName, lastName, this.address, this.mobile, this.email);
    }
    public ContactData withAddress(String address) {
        return new ContactData(this.firstName, this.lastName, address, this.mobile, this.email);
    }
    public ContactData withMobile(String mobile) {
        return new ContactData(this.firstName, this.lastName, this.address, mobile, this.email);
    }
    public ContactData withEmail(String email) {
        return new ContactData(this.firstName, this.lastName, this.address, this.mobile, email);
    }
}