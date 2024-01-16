package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper {
    private final ApplicationManager manager;

    public ContactHelper(ApplicationManager manager) {
        this.manager = manager;
    }

    public void openContactPage() {
        if (!manager.isElementPresent(By.xpath("//input[@value=\'Delete\']"))) {
            manager.driver.findElement(By.linkText("home")).click();
        }
    }

    public boolean isContactPresent() {
        openContactPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contact) {
        openContactPage();
        manager.driver.findElement(By.linkText("add new")).click();
        manager.driver.findElement(By.name("firstname")).click();
        manager.driver.findElement(By.name("firstname")).sendKeys(contact.firstName());
        manager.driver.findElement(By.name("lastname")).click();
        manager.driver.findElement(By.name("lastname")).sendKeys(contact.lastName());
        manager.driver.findElement(By.name("address")).click();
        manager.driver.findElement(By.name("address")).sendKeys(contact.address());
        manager.driver.findElement(By.name("mobile")).click();
        manager.driver.findElement(By.name("mobile")).sendKeys(contact.mobile());
        manager.driver.findElement(By.name("email")).click();
        manager.driver.findElement(By.name("email")).sendKeys(contact.email());
        manager.driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
        manager.driver.findElement(By.linkText("home page")).click();
    }

    public void removeContact() {
        openContactPage();
        manager.driver.findElement(By.name("selected[]")).click();
        manager.driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
    }
}
