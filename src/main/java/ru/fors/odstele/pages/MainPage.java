package ru.fors.odstele.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.allure.annotations.Step;

public class MainPage extends Page {

	public MainPage(WebDriver driver) {
		super(driver);
	}
	By userRole = By.xpath("//*[@id='logo']/div/div[2]");
	By logoutLink = By.linkText("Выход");
	
	@Step("Проверяем роль пользователя")
	public String getUserRole(){
		waitForElementPresent(driver, userRole, 6);
		return getElementText(userRole);
	}
	
	@Step("Пользователь выходит из системы")
	public LoginPage userLogOut(){
		click(logoutLink);
		return new LoginPage(driver);
	}
}
