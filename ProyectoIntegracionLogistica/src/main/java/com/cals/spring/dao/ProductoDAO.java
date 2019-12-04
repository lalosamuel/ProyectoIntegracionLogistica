package com.cals.spring.dao;

import com.cals.spring.model.Producto;
import java.util.List;

public interface ProductoDAO {

	public int guardar(Producto producto);
	
	public int editar(Producto producto);
	
	public Producto obtener(Integer id);
	
	public int borrar(Integer id);
	
	public List<Producto> lista();
	
	public List<Producto> listado();
	
}
