package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {
    @Test
    public void canCreateContact() {
        app.contact().createContact(new ContactData("First name", "Last name", "Address", "Mobile", "E-mail"));
    }

    @Test
    public void canCreateEmptyContact() {
        app.contact().createContact(new ContactData());
    }

    @Test
    public void canCreateContactWithFirstNameOnly() {
        app.contact().createContact(new ContactData().withFirstName("First name"));
    }

    @Test
    public void canCreateContactWithLastNameOnly() {
        app.contact().createContact(new ContactData().withLastName("Last name"));
    }

    @Test
    public void canCreateContactWithAddressOnly() {
        app.contact().createContact(new ContactData().withAddress("Address"));
    }

    @Test
    public void canCreateContactWithMobileOnly() {
        app.contact().createContact(new ContactData().withMobile("Mobile"));
    }

    @Test
    public void canCreateContactWithEmailOnly() {
        app.contact().createContact(new ContactData().withEmail("E-mail"));
    }
}
