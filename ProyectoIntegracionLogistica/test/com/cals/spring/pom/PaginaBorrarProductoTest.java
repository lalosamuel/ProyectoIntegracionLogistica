package com.cals.spring.pom;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class PaginaBorrarProductoTest {
	
	private WebDriver driver;
	PaginaBorrarProducto paginaBorrarProducto;

	@BeforeEach
	void setUp() throws Exception {
		paginaBorrarProducto = new PaginaBorrarProducto(driver);
		driver = paginaBorrarProducto.chromeDriverConnection();
		paginaBorrarProducto.visit("http://localhost:8082/ProyectoIntegracionLogistica/");
		
	}

	
	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void test()  throws InterruptedException{
		
		paginaBorrarProducto.borrarProducto();
		Thread.sleep(2000);
		assertEquals("1", paginaBorrarProducto.borrarMensaje());
	}

}
