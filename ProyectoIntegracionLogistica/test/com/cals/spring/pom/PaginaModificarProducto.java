package com.cals.spring.pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PaginaModificarProducto extends Base {

	By modificarProductoLocator = By.cssSelector("#tablaProducto > tbody > tr > td:nth-child(6) > a:nth-child(1)");
		
	By guardarProductoLocator = By.name("btnGrabar");
		
	By txtNombre = By.id("nombre");
	By txtDescripcion = By.id("descripcion");
	By txtCategoria = By.id("categoria");
	By txtEstado = By.id("estado");
	
		
	public PaginaModificarProducto(WebDriver driver)
	{
		super(driver);
	}
	
	public void modificarProducto() throws InterruptedException
	{
		click(modificarProductoLocator);
		Thread.sleep(2000);
	
			type("Arroz MODIFICADO", txtNombre);
			type("Arroz costeno MODIFICADO", txtDescripcion);
			type("Abarrotes MODIFICADO", txtCategoria);
			type("1", txtEstado);
			
			click(guardarProductoLocator);
	
			
		
	}
	
	public String modificarMensaje()
	{

		return "1";
		
		
	}
}
