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

import com.cals.spring.dao.ContactDAO;
import com.cals.spring.dao.ProductoDAO;
import com.cals.spring.model.Contact;
import com.cals.spring.model.Producto;

/**
 * This controller routes accesses to the application to the appropriate
 * hanlder methods. 
 * @author www.codejava.net
 *
 */
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
	
	
	/*
	@Autowired
	private ContactDAO contactDAO;
	
	@RequestMapping(value="/")
	public ModelAndView listContact(ModelAndView model) throws IOException{
		List<Contact> listContact = contactDAO.list();
		model.addObject("listContact", listContact);
		model.setViewName("home");
		
		return model;
	}
	
	@RequestMapping(value = "/newContact", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Contact newContact = new Contact();
		model.addObject("contact", newContact);
		model.setViewName("ContactForm");
		return model;
	}
	
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contact contact) {
		contactDAO.saveOrUpdate(contact);		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
		int contactId = Integer.parseInt(request.getParameter("id"));
		contactDAO.delete(contactId);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int contactId = Integer.parseInt(request.getParameter("id"));
		Contact contact = contactDAO.get(contactId);
		ModelAndView model = new ModelAndView("ContactForm");
		model.addObject("contact", contact);
		
		return model;
	}
	*/
}
