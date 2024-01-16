package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void CanCreateGroup() {
        TestBase.app.groups().createGroup(new GroupData("group name", "group header", "group footer"));
    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        TestBase.app.groups().createGroup(new GroupData());
    }
    @Test
    public void CanCreateGroupWithNameOnly() {
        TestBase.app.groups().createGroup(new GroupData().withName("some name"));
    }
}
