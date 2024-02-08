package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {
    public static List<ContactData> contactProvider() {
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
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData()
                    .withFirstName(randomString(i * 10))
                    .withLastName(randomString(i * 10))
                    .withAddress(randomString(i * 10))
                    .withMobile(randomString(i * 10))
                    .withEmail(randomString(i * 10))
                    .withPhoto(randomFile ("src/test/resources/images")));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        var oldContacts = app.contact().getList();
        app.contact().createContact(contact);
        var newContacts = app.contact().getList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(newContacts.get(newContacts.size() -1 ).id()).withAddress("").withMobile("").withEmail("").withPhoto(""));
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
