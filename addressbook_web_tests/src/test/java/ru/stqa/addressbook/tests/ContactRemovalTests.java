package ru.stqa.addressbook.tests;

import ru.stqa.addressbook.model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContacts() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "", "", "", "", "", ""));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contact().removeContact(oldContacts.get(index));
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
    }

    @Test
    void canRemoveAllContacts() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData());
        }
        app.contact().removeAllContacs();
        Assertions.assertEquals(0, app.hbm().getContactCount());
    }

    @Test
    public void canRemoveContactInGroupFromHomePage() {
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "GroupName", "", ""));
        }
        var group = app.hbm().getGroupList().get(0);
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "", "", "", "", "", ""));
        }
        var contactWithId = app.hbm().getContactList().get(0);
        var oldRelated = app.hbm().getContactsInGroup(group);
        if (oldRelated.size() == 0){
            app.contact().createContactWithGroupFromHomePage(contactWithId, group);
            oldRelated = app.hbm().getContactsInGroup(group);
        } else {
            contactWithId =  app.hbm().getContactsInGroup(group).get(0);
        }
        app.contact().removeContactWithGroupFromHomePage(contactWithId, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newRelated.sort(compareById);

        var expectedList = new ArrayList<>(oldRelated);
        for (int i=0;i<expectedList.size();i++) {
            if(expectedList.get(i).id().equals(contactWithId.id())){
                expectedList.remove(i);
                break;
            }
        }
        expectedList.sort(compareById);
        Assertions.assertEquals(newRelated, expectedList);
    }
}
