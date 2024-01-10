import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void CanCreateGroup() {
        openGroupPage();
        createGroup("group name", "group header", "group footer");
    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        openGroupPage();
        createGroup("", "", "");
    }

}
