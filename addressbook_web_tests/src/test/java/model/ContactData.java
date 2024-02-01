package model;

public record ContactData(String id, String firstName, String lastName, String address, String mobile, String email) {
    public ContactData(){
        this ("", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstName, this.lastName, this.address, this.mobile, this.email);
    }
    public ContactData withFirstName(String firstName) {
        return new ContactData(this.id, firstName, this.lastName, this.address, this.mobile, this.email);
    }
    public ContactData withLastName(String lastName) {
        return new ContactData(this.id, this.firstName, lastName, this.address, this.mobile, this.email);
    }
    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstName, this.lastName, address, this.mobile, this.email);
    }
    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.firstName, this.lastName, this.address, mobile, this.email);
    }
    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstName, this.lastName, this.address, this.mobile, email);
    }
}