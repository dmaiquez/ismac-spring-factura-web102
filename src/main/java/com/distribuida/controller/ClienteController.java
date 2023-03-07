package com.distribuida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.distribuida.entities.Cliente;
import com.distribuida.services.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping
	public String findAll(Model model) {
		
		List<Cliente> clientes = clienteService.findAll();
		
		model.addAttribute("clientes", clientes);
		
		return "listar-clientes";
	}
	
	
	
	@RequestMapping("/frmAdd")
	public String add() {
		return "agregar-clientes";
	}
	
	@RequestMapping("/frmDel")
	public String del() {
		return "eliminar-clientes";
	}
	
	
	
	
	
}
