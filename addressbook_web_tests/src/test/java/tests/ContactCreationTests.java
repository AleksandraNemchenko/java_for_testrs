package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {
    @Test
    public void canCreateContact() {
        int groupCount =  app.contact().getCount();
        app.contact().createContact(new ContactData("First name", "Last name", "Address", "Mobile", "E-mail"));
        int newGroupCount =  app.contact().getCount();
        Assertions.assertEquals(groupCount + 1, newGroupCount);
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

    @Test
    public void canCreateMultipleContacts() {
        int n = 5;
        int groupCount =  app.contact().getCount();

        for (int i = 0; i < n; i++){
            app.contact().createContact(new ContactData(randomString(i), "Last name", "Address", "Mobile", "E-mail"));
        }

        int newGroupCount =  app.contact().getCount();
        Assertions.assertEquals(groupCount + n, newGroupCount);
    }
}
