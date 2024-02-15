package ru.stqa.addressbook.manager;

import ru.stqa.addressbook.model.ContactData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{


    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openContactPage() {
        if (!manager.isElementPresent(By.xpath("//input[@value=\'Delete\']"))) {
            click(By.linkText("home"));
        }
    }
    public void createContact(ContactData contact) {
        openContactPage();
        goToAddNewContactPage();
        fillContactForm (contact);
        submitContactCreation();
        returnToHomePage();
    }
    public void removeContact(ContactData contact) {
        goToAddNewContactPage();
        openContactPage();
        selectContact(contact);
        removeSelectedContacts();
    }
    public String modifyContact( ContactData modifiedContact, int index) {
        openContactPage();
        editContact(index);
        var id = getContactId();
        fillContactForm(modifiedContact);
        submitGroupModification();
        returnToHomePage();
        return id;
    }

    private String getContactId() {
        var input = manager.driver.findElement(By.xpath("(//input[@name=\'id\'])"));
        var id = input.getAttribute("value");
        return id;
    }

    private void editContact(int index) {
        var editButtons = manager.driver.findElements(By.xpath("//img[@alt=\'Edit\']"));
        var editButton = editButtons.get(index);
        editButton.click();
    }

    private void submitContactCreation() {
        click(By.xpath("(//input[@name=\'submit\'])[2]"));
    }

    private void goToAddNewContactPage() {
        click(By.linkText("add new"));
    }

    private void removeSelectedContacts() {
        click(By.xpath("//input[@value=\'Delete\']"));
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    private void returnToHomePage() {
        click(By.linkText("home page"));
    }

    private void submitGroupModification() {
        click(By.name("update"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstName());
        type(By.name("lastname"), contact.lastName());
        type(By.name("address"), contact.address());
        type(By.name("mobile"), contact.mobile());
        type(By.name("email"), contact.email());
        if(!contact.photo().isEmpty()) {
            attach(By.name("photo"), contact.photo());
        }
    }
    private void initContactModification() {
        click(By.xpath("//img[@alt=\'Edit\']"));
    }
    public int getCount(){
        openContactPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void removeAllContacs() {
        openContactPage();
        selectAllContacts();
        removeSelectedContacts();
    }

    private void selectAllContacts() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes){
            checkbox.click();
        }
    }

    public List<ContactData> getList() {
        openContactPage();
        var contacts = new ArrayList<ContactData>();
        var trs = manager.driver.findElements(By.name("entry"));

        for (var tr : trs){
            var checkbox = tr.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            var tds = tr.findElements(By.tagName("td"));
            var firstName = tds.get(2).getText();//name
            var lastName = tds.get(1).getText();//surname
            contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
            }
        return contacts;
    }
}
