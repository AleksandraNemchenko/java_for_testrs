package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase{

    public int getCount(){
        openContactPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

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
        initContactCreation();
        fillContactForm (contact);
        submitContactCreation();
        returnToHomePage();
    }
    public void removeContact() {
        openContactPage();
        selectContact();
        removeSelectedContact();
    }
    public void modifyContact(ContactData modifiedContact) {
        openContactPage();
        initContactModification();
        fillContactForm(modifiedContact);
        submitGroupModification();
        returnToHomePage();
    }

    private void submitContactCreation() {
        click(By.xpath("(//input[@name=\'submit\'])[2]"));
    }

    private void initContactCreation() {
        click(By.linkText("add new"));
    }

    private void removeSelectedContact() {
        click(By.xpath("//input[@value=\'Delete\']"));
    }

    private void selectContact() {
        click(By.name("selected[]"));
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
    }
    private void initContactModification() {
        click(By.xpath("//img[@alt=\'Edit\']"));
    }

}
