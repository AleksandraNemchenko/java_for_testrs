import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase{
    @Test
    public void canCreateContact() {
        openContactPage();
        createContact(new ContactData("First name", "Last name", "Address", "Mobile", "E-mail"));
    }
}
