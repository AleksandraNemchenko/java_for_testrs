package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        if (!TestBase.app.contact().isContactPresent()){
            TestBase.app.contact().createContact(new ContactData());
        }
        TestBase.app.contact().removeContact();
    }
}
