package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        if (app.contact().getCount() == 0){
            app.contact().createContact(new ContactData());
        }
        int groupCount = app.contact().getCount();
        app.contact().removeContact();
        int newGroupCount = app.contact().getCount();
        Assertions.assertEquals(groupCount - 1, newGroupCount);
    }

    @Test
    void canRomoveAllContacts(){
        if (app.contact().getCount() == 0){
            app.contact().createContact(new ContactData());
        }
        app.contact().removeAllContacs();
        Assertions.assertEquals(0, app.contact().getCount());
    }
}
