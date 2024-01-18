package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactModificationTests extends TestBase{

    @Test
    void canModifyContact(){
        if (!TestBase.app.contact().isContactPresent()){
            TestBase.app.contact().createContact(new ContactData());
        }
        app.contact().modifyContact(new ContactData().withFirstName("modified FirstName"));
    }
}
