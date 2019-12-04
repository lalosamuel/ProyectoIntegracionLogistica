package com.cals.spring.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PaginaBorrarProducto extends Base {

	By borrarProductoLocator = By.xpath("//*[@id=\"tablaProducto\"]/tbody/tr[1]/td[6]/a[2]");
		
	public PaginaBorrarProducto(WebDriver driver)
	{
		super(driver);
	}
	
	public void borrarProducto() throws InterruptedException
	{
		click(borrarProductoLocator);
		Thread.sleep(2000);
		
	}
	
	public String borrarMensaje()
	{

		return "1";
		
		
	}
}
