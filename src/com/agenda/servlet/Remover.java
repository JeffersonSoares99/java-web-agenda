package com.agenda.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agenda.service.CadastraUsuarioService;
import com.sun.security.jgss.ExtendedGSSContext;

@WebServlet("/remover-contato")
public class Remover extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		CadastraUsuarioService service = new CadastraUsuarioService();
		
	service.removeContato (null);
		
	
	}		
}
