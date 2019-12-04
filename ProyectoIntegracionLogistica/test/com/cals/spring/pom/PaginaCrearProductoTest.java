package com.cals.spring.pom;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class PaginaCrearProductoTest {

	private WebDriver driver;
	PaginaCrearProducto paginaCrearProducto;
	
	@BeforeEach
	void setUp() throws Exception {
		paginaCrearProducto = new PaginaCrearProducto(driver);
		driver = paginaCrearProducto.chromeDriverConnection();
		paginaCrearProducto.visit("http://localhost:8082/ProyectoIntegracionLogistica/");
		
	}

	
	
	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void test()  throws InterruptedException {
		
		paginaCrearProducto.registrarProducto();
		Thread.sleep(2000);
		assertEquals("1", paginaCrearProducto.registrarMensaje());
	}

}
