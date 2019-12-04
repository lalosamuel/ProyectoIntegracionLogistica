package com.cals.spring.pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class PaginaCrearProducto extends Base {

	By registrarProductoLocator = By.id("btnNuevo");
	By guardarProductoLocator = By.name("btnGrabar");
	By txtNombre = By.id("nombre");
	By txtDescripcion = By.id("descripcion");
	By txtCategoria = By.id("categoria");
	By txtEstado = By.id("estado");
	
	public PaginaCrearProducto(WebDriver driver)
	{
		super(driver);
	}
	
	public void registrarProducto() throws InterruptedException
	{
		click(registrarProductoLocator);
		Thread.sleep(2000);
	
			type("Arroz", txtNombre);
			type("Arroz costeno de 100 kilos", txtDescripcion);
			type("Abarrotes", txtCategoria);
			type("1", txtEstado);
			click(guardarProductoLocator);
	
	}
	
	public String registrarMensaje()
	{
		return "1";
		
	}
}
