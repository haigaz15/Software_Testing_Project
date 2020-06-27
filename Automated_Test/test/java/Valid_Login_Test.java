import org.junit.Test;

import static org.junit.Assert.*;
public class Valid_Login_Test extends BaseTest{

    @Test
    public void testSuccessfulLogIn()  {
        LoginPage loginPage = new LoginPage(driver);
        UserPage userPage = loginPage.sucessfulLogin("haigaz_soghmonian@edu.aua.am","helloWorld+1");
        String UserHeader = userPage.myUserHeader();
        String courseHeader = userPage.mycourseHeader();
        String StuffHeader = userPage.myStuffHeader();
        String startButton = userPage.getStartButton();
        assertEquals(UserHeader,"haigaz soghmonian");
        assertEquals(courseHeader,"My courses");
        assertEquals(StuffHeader,"MY STUFF");
        assertEquals(startButton,"Start");
    }
}
