package com.cals.spring.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.cals.spring.model.Producto;



class ProductoDAOTest {

	private DriverManagerDataSource dataSource;
	private ProductoDAO dao;
	
	@BeforeEach
	void setupBeforeEach()
	{
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/integracion");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		dao=new ProductoDAOImpl(dataSource);
	}
		
	
	//Prueba Unitaria Guardar
	@Test
	void testGuardar() {
	
		Producto producto=new Producto("Azucar (Prueba Unitaria)","Azucar Casa Grande 50k","Abarrotes","1");
		int resultado = dao.guardar(producto);
		assertTrue(resultado>0);
	}
	
	//Prueba Unitaria Editar
	@Test
	void testEditar() {
		
		Producto producto=new Producto(40,"Leche Deslactosada","Leche gloria en Caja","Lacteos","2");
		int resultado = dao.editar(producto);
		assertTrue(resultado>0);
		
	}

	//Prueba Unitaria Obtener
	@Test
	void testObtener() {
		
		Integer id=2;
		Producto producto =dao.obtener(id);
		if(producto!=null)
		{
			System.out.print(producto);
		}
		assertNotNull(producto);
	}
	

	//Prueba Unitaria Borrar
	@Test
	void testBorrar() {
		
		Integer id=3;
		int result=dao.borrar(id);
		
		assertTrue(result>0);
	}

	
	
	//Prueba Unitaria Listar
	@Test
	void testLista() {
		
		List<Producto> listProductos=dao.listado();
		
		for(Producto aProducto:listProductos)
		{
			
			System.out.print(aProducto);
		}
		
		assertTrue(!listProductos.isEmpty());
	
	}
	

}