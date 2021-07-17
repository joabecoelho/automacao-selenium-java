package br.com.mantisBugTracker.testeMantis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;
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
	
	private boolean verificarElemento(String id) {
		try {
			driver.findElement(By.id(id));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	@BeforeEach
	public void iniciar() {
		url = "https://www.mantisbt.org/bugs/login_page.php";
		System.setProperty("webdriver.chrome.driver",
				"C:\\PROJETOS ECLIPSE\\testeMantis\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
	}

	@AfterEach
	public void finalizar() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	@AfterAll
	public static void aposFinalizarTodos() {
		JOptionPane.showMessageDialog(null, "Todos os teste(s) finalizado(s).");
	}

	@Test
	public void testeLoginSucesso() {

		driver.get(url);

		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("joabecoelho");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/input[3]")).click();

	}

	@Test
	public void testeLoginFalho() throws InterruptedException {

		driver.get(url);

		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("joabecoelho");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("321");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/input[3]")).click();

		String textFalha = "Sua conta pode estar desativada ou bloqueada ou o "
				+ "nome de usuário e a senha que você digitou não estão corretos.";

		assertEquals(textFalha,
				driver.findElement(By.xpath("//*[@id=\"main-cont" + "ainer\"]/div/div/div/div/div[4]/p")).getText());
	}
	
	@Test
	public void testeCriarTarefa() throws InterruptedException {
		driver.get(url);
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("joabecoelho");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/input[3]")).click();
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/ul/li[1]/div/a")).click();
		driver.findElement(By.id("category_id")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/form/div/div[2]/div[1]/div/table/tbody/tr[1]/td/select/option[2]")).click();
		driver.findElement(By.id("reproducibility")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/form/div/div[2]/div[1]/div/table/tbody/tr[2]/td/select/option[1]")).click();
		driver.findElement(By.id("severity")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/form/div/div[2]/div[1]/div/table/tbody/tr[3]/td/select/option[1]")).click();
		driver.findElement(By.id("priority")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/form/div/div[2]/div[1]/div/table/tbody/tr[4]/td/select/option[4]")).click();
		boolean t = verificarElemento("profile_open_link");
		if(t = true) {
			driver.findElement(By.id("platform")).sendKeys("Teste");
			driver.findElement(By.id("os")).sendKeys("Windows");
			driver.findElement(By.id("os_build")).sendKeys("1223_032");
			driver.findElement(By.id("product_version")).click();
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/form/div/div[2]/div[1]/div/table/tbody/tr[6]/td/select/option[3]")).click();
			driver.findElement(By.id("summary")).sendKeys("testetestesteste");
			driver.findElement(By.id("description")).sendKeys("testestestestetestestestestetestestestestetestestestestetestestesteste");
			driver.findElement(By.id("steps_to_reproduce")).sendKeys("testetestesteste");
			driver.findElement(By.id("additional_info")).sendKeys("testetestesteste");
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/form/div/div[2]/div[1]/div/table/tbody/tr[12]/td/label[2]/span")).click();
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/form/div/div[2]/div[2]/input")).click();
		} else {
			
		driver.findElement(By.id("profile_closed_link")).click();	
			
		driver.findElement(By.id("platform")).sendKeys("Teste");
		driver.findElement(By.id("os")).sendKeys("Windows");
		driver.findElement(By.id("os_build")).sendKeys("1223_032");
		driver.findElement(By.id("product_version")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/form/div/div[2]/div[1]/div/table/tbody/tr[6]/td/select/option[3]")).click();
		driver.findElement(By.id("summary")).sendKeys("testetestesteste");
		driver.findElement(By.id("description")).sendKeys("testestestestetestestestestetestestestestetestestestestetestestesteste");
		driver.findElement(By.id("steps_to_reproduce")).sendKeys("testetestesteste");
		driver.findElement(By.id("additional_info")).sendKeys("testetestesteste");
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/form/div/div[2]/div[1]/div/table/tbody/tr[12]/td/label[2]/span")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/form/div/div[2]/div[2]/input")).click();
		}
	}
	
	@Test
	public void testeAcessarMinhaConta() throws InterruptedException {
		driver.get(url);
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("joabecoelho");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/input[3]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/ul/li[1]/a")).click();
	}

}
