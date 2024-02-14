package ru.stqa.addressbook.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {
    public static List<ContactData> contactProvider() throws IOException {
        var result = new ArrayList<ContactData>();
        for (var firstName : List.of("", "First name")) {
            for (var lastName : List.of("", "Last name")) {
                for (var address : List.of("", "Address")) {
                    for (var mobile : List.of("", "Mobile")) {
                        for (var email : List.of("", "E-mail")) {
                                result.add(new ContactData()
                                        .withFirstName(firstName)
                                        .withLastName(lastName)
                                        .withAddress(address)
                                        .withMobile(mobile)
                                        .withEmail(email)
                                        .withPhoto(randomFile("src/test/resources/images")));
                        }
                    }
                }
            }
        }
        var mapper = new XmlMapper();
        var value = mapper.readValue(new File("contacts.xml"), new TypeReference<List<ContactData>>() {
        });
        result.addAll(value);
        return result;
    }

    public static List<ContactData> singleRandomContact() {
       return List.of(new ContactData()
                .withFirstName(CommonFunctions.randomString(10))
                .withLastName(CommonFunctions.randomString(20))
                .withAddress(CommonFunctions.randomString(30))
                .withMobile(CommonFunctions.randomString(9))
                .withEmail(CommonFunctions.randomString(7)));
    }

    @ParameterizedTest
    @MethodSource("singleRandomContact")
    public void canCreateContact(ContactData contact) {
        var oldContacts = app.jdbc().getContactList();
        app.contact().createContact(contact);
        var newContacts = app.jdbc().getContactList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var maxId = newContacts.get(newContacts.size() -1 ).id();

        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(maxId));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts,expectedList);
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateContact(ContactData contact) {
        var oldContacts = app.contact().getList();
        app.contact().createContact(contact);
        var newContacts = app.contact().getList();
        Assertions.assertEquals(newContacts,oldContacts);
    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("", "contact name '", "", "", "", "", "")));
        return result;
    }
}
