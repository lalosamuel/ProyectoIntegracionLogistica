package com.cals.spring.pom;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class PaginaModificarProductoTest {

	private WebDriver driver;
	PaginaModificarProducto paginaModificarProducto;
	
	@BeforeEach
	void setUp() throws Exception {
		paginaModificarProducto = new PaginaModificarProducto(driver);
		driver = paginaModificarProducto.chromeDriverConnection();
		paginaModificarProducto.visit("http://localhost:8080/ProyectoIntegracionLogistica/");
		
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void test()  throws InterruptedException {
		
		paginaModificarProducto.modificarProducto();
		Thread.sleep(2000);
		assertEquals("1", paginaModificarProducto.modificarMensaje());
	}

}
