import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase{
    @Test
    public void canCreateContact() {
        openContactPage();
        createContact(new ContactData("First name", "Last name", "Address", "Mobile", "E-mail"));
    }
    @Test
    public void canCreateEmptyContact(){
        openContactPage();
        createContact(new ContactData());
    }
    @Test
    public void canCreateContactWithFirstNameOnly(){
        openContactPage();
        createContact(new ContactData().withFirstName("First name"));
    }
    @Test
    public void canCreateContactWithLastNameOnly(){
        openContactPage();
        createContact(new ContactData().withLastName("Last name"));
    }
    @Test
    public void canCreateContactWithAddressOnly(){
        openContactPage();
        createContact(new ContactData().withAddress("Address"));
    }
    @Test
    public void canCreateContactWithMobileOnly(){
        openContactPage();
        createContact(new ContactData().withMobile("Mobile"));
    }
    @Test
    public void canCreateContactWithEmailOnly(){
        openContactPage();
        createContact(new ContactData().withEmail("E-mail"));
    }
}
