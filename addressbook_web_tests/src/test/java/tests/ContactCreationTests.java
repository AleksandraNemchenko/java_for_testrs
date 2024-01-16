import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase{
    @Test
    public void canCreateContact() {
        app.openContactPage();
        app.createContact(new ContactData("First name", "Last name", "Address", "Mobile", "E-mail"));
    }
    @Test
    public void canCreateEmptyContact(){
        app.openContactPage();
        app.createContact(new ContactData());
    }
    @Test
    public void canCreateContactWithFirstNameOnly(){
        app.openContactPage();
        app.createContact(new ContactData().withFirstName("First name"));
    }
    @Test
    public void canCreateContactWithLastNameOnly(){
        app.openContactPage();
        app.createContact(new ContactData().withLastName("Last name"));
    }
    @Test
    public void canCreateContactWithAddressOnly(){
        app.openContactPage();
        app.createContact(new ContactData().withAddress("Address"));
    }
    @Test
    public void canCreateContactWithMobileOnly(){
        app.openContactPage();
        app.createContact(new ContactData().withMobile("Mobile"));
    }
    @Test
    public void canCreateContactWithEmailOnly(){
        app.openContactPage();
        app.createContact(new ContactData().withEmail("E-mail"));
    }
}
