package com.cals.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.cals.spring.dao.ProductoDAO;
import com.cals.spring.model.Producto;


@Controller
public class HomeController {


	@Autowired
	private ProductoDAO productoDAO;
	
	
	@RequestMapping(value="/")
	public ModelAndView listContact(ModelAndView model) throws IOException{
		
		List<Producto> listProducto = productoDAO.lista();
		model.addObject("listProducto", listProducto);
		model.setViewName("index");
		
		return model;
	}
	
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public ModelAndView nuevoProducto(ModelAndView model) {
		Producto nuevoProducto = new Producto();
		model.addObject("producto", nuevoProducto);
		model.setViewName("productoform");
		return model;
	}
	
	
	@RequestMapping(value = "/guardaProducto", method = RequestMethod.POST)
	public ModelAndView guardaProducto(@ModelAttribute Producto producto) {
		
		if(producto.getId()==null)
		{
			int ss =0;
			
			ss = productoDAO.guardar(producto);
			if(ss>0)
			{
				return new ModelAndView("redirect:/");
			}else
			{
				return new ModelAndView("redirect:/");
			}
			
		}else
		{
			int ss=0;
			
			ss = productoDAO.editar(producto);
			
			if(ss>0)
			{
				return new ModelAndView("redirect:/");
				
			}else
			{
				return new ModelAndView("redirect:/");
			}
		}

		
		
	}
	
	
	@RequestMapping(value = "/borrarProducto", method = RequestMethod.GET)
	public ModelAndView borraProducto(HttpServletRequest request) {
		int productoId = Integer.parseInt(request.getParameter("id"));
		productoDAO.borrar(productoId);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editarProducto", method = RequestMethod.GET)
	public ModelAndView editaProducto(HttpServletRequest request) {
		int productoId = Integer.parseInt(request.getParameter("id"));
		Producto producto = productoDAO.obtener(productoId);
		ModelAndView model = new ModelAndView("productoform");
		model.addObject("producto", producto);
		
		return model;
	}
	
	
}
