package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {
    @Test
    public void canCreateContact() {
        TestBase.app.contact().createContact(new ContactData("First name", "Last name", "Address", "Mobile", "E-mail"));
    }
    @Test
    public void canCreateEmptyContact(){
        TestBase.app.contact().createContact(new ContactData());
    }
    @Test
    public void canCreateContactWithFirstNameOnly(){
        TestBase.app.contact().createContact(new ContactData().withFirstName("First name"));
    }
    @Test
    public void canCreateContactWithLastNameOnly(){
        TestBase.app.contact().createContact(new ContactData().withLastName("Last name"));
    }
    @Test
    public void canCreateContactWithAddressOnly(){
        TestBase.app.contact().createContact(new ContactData().withAddress("Address"));
    }
    @Test
    public void canCreateContactWithMobileOnly(){
        TestBase.app.contact().createContact(new ContactData().withMobile("Mobile"));
    }
    @Test
    public void canCreateContactWithEmailOnly(){
        TestBase.app.contact().createContact(new ContactData().withEmail("E-mail"));
    }
}
