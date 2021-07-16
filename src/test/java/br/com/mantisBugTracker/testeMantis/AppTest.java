package br.com.mantisBugTracker.testeMantis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {

	String url;
	WebDriver driver;

	@BeforeEach
	public void iniciar() {
		url = "https://www.mantisbt.org/bugs/login_page.php";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\joabe\\Documents\\Projetos Eclipse\\automacao-teste\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
	}

	@AfterEach
	public void finalizar() {
		driver.quit();
	}

	@AfterAll
	public static void aposFinalizarTodos() {
		JOptionPane.showMessageDialog(null, "Todos os teste(s) finalizado(s).");
	}

	@Test
	public void testeLoginSucesso() throws InterruptedException {

		driver.get(url);

		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("joabecoelho");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/input[3]")).click();
		Thread.sleep(2000);

	}

	@Test
	public void testeLoginFalho() throws InterruptedException {

		driver.get(url);

		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("joabecoelho");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("321");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/input[3]")).click();
		Thread.sleep(2000);

		String textFalha = "Sua conta pode estar desativada ou bloqueada ou o "
				+ "nome de usuário e a senha que você digitou não estão corretos.";

		assertEquals(textFalha,
				driver.findElement(By.xpath("//*[@id=\"main-cont" + "ainer\"]/div/div/div/div/div[4]/p")).getText());
	}

}
