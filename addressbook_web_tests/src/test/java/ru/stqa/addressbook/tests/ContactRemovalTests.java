package ru.stqa.addressbook.tests;

import ru.stqa.addressbook.model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContacts() {
        if (app.hbm().getContactCount() == 0){
            app.hbm().createContact(new ContactData("","","","","","",""));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contact().removeContact(oldContacts.get(index));
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts,expectedList);
    }

    @Test
    void canRemoveAllContacts(){
        if (app.hbm().getContactCount() == 0){
            app.hbm().createContact(new ContactData());
        }
        app.contact().removeAllContacs();
        Assertions.assertEquals(0, app.hbm().getContactCount());
    }
}
