import org.junit.Test;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
public class UserProfile_Test extends BaseTest {
    @Test
    public void testUserProfileFunctionalists() {
        LoginPage loginPage = new LoginPage(driver);
        UserPage userPage = loginPage.sucessfulLogin("haigaz_soghmonian@edu.aua.am","helloWorld+1");
        UserProfilePage userProfilePage = userPage.enterUserProfile();
        String realName = userProfilePage.getRealName();
        String userName = userProfilePage.getUsername();
        assertEquals(realName,"haigaz soghmonian");
        assertEquals(userName,"haigaz");
        String bio = userProfilePage.getBio();
        assertEquals(bio,"Looking forward to learn !");
        boolean cancelButton = userProfilePage.clickCancel();
        assertTrue(cancelButton);
       assertTrue(userProfilePage.clickAvatar());
    }
}
