package ru.fors.odstele.tests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fors.odstele.pages.LoginPage;
import ru.fors.odstele.pages.MainPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import static org.junit.Assert.assertTrue;
public class LoginTests extends TestBase {
	
	
	
	@Features("Авторизация в системе")
	@Stories("Вход/Выход из системы")
	@Test
	@Parameters({"username", "password", "role"})
	public void userLogin(String username, String password, String role){
		LoginPage loginPage = new LoginPage(driver);
		MainPage mainPage = loginPage.userLogin(username, password);
		assertTrue("Не осуществлен вход на страницу", mainPage.getUserRole().contains(role));
		loginPage = mainPage.userLogOut();
		assertTrue("Не осуществлен выход со страницы", loginPage.getUrl().contains(baseUrl));
	}
	

}
