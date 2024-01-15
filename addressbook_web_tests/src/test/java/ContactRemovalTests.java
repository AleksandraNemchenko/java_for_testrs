import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase{

    @Test
    public void canRemoveGroup() {
        openContactPage();
        if (!isContactPresent()){
            createContact(new ContactData());
        }
        removeContact();
    }
}
