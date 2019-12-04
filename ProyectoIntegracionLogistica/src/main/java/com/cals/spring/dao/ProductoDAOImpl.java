package com.cals.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.cals.spring.model.Producto;

public class ProductoDAOImpl implements ProductoDAO {


	
	private JdbcTemplate jdbcTemplate;
	
	public ProductoDAOImpl(DataSource dataSource) {

		this.jdbcTemplate =new JdbcTemplate(dataSource);
	}
	
	
	
	@Override
	public int guardar(Producto producto) {
		
	String sql = "INSERT INTO producto (nombre,descripcion,categoria, estado)"
				+ " VALUES (?,?,?,?)";
	return jdbcTemplate.update(sql, producto.getNombre(),producto.getDescripcion(),producto.getCategoria(), producto.getEstado());
		
	}

	@Override
	public int editar(Producto producto) {

		
		String sql = "UPDATE producto SET nombre=?, descripcion=?, categoria=?, estado=?"
				+ "WHERE producto_id=?";
		return jdbcTemplate.update(sql, producto.getNombre(),producto.getDescripcion(),producto.getCategoria(), producto.getEstado(), producto.getId());
		
	}

	@Override
	public Producto obtener(Integer id) {
		String sql = "SELECT * FROM producto WHERE producto_id=" + id;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Producto>() {

			@Override
			public Producto extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Producto producto = new Producto();
					producto.setId(rs.getInt("producto_id"));
					producto.setNombre(rs.getString("nombre"));
					producto.setDescripcion(rs.getString("descripcion"));
					producto.setCategoria(rs.getString("categoria"));
					producto.setEstado(rs.getString("estado"));
					return producto;
				}
				
				return null;
			}
			
		});
	}

	@Override
	public int borrar(Integer id) {
		
		String sql = "DELETE FROM producto WHERE producto_id=?";
		
		return jdbcTemplate.update(sql, id);
		
		 
	}

	@Override
	public List<Producto> lista() {
	

		String sql = "SELECT * FROM producto";
		List<Producto> listProducto = jdbcTemplate.query(sql, new RowMapper<Producto>() {

			@Override
			public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
				Producto aProducto = new Producto();
	
				aProducto.setId(rs.getInt("producto_id"));
				aProducto.setNombre(rs.getString("nombre"));
				aProducto.setDescripcion(rs.getString("descripcion"));
				aProducto.setCategoria(rs.getString("categoria"));
				aProducto.setEstado(rs.getString("estado"));
				
				return aProducto;
				
			}
			
		});
		
		return listProducto;

		
	}
	
	//nuevo
	@Override
	public List<Producto> listado() {
	

		String sql = "SELECT * FROM producto";
		RowMapper<Producto> RowMapper = new RowMapper<Producto>(){

			@Override
			public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Integer id=rs.getInt("producto_id");
				String nombre =rs.getString("nombre");
				String descripcion =rs.getString("descripcion");
				String categoria =rs.getString("categoria");
				String estado =rs.getString("estado");
								
				return new Producto(id, nombre, descripcion, categoria, estado);
				
			}
			
		};
		
		return jdbcTemplate.query(sql, RowMapper);

		
	}
	

}
