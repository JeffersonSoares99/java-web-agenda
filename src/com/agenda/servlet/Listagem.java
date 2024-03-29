package com.agenda.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agenda.model.Pessoa;
import com.agenda.service.CadastraUsuarioService;

@WebServlet("/busca-contatos")
public class Listagem extends HttpServlet {

	private static final long serialVersionUID = 6269485495242704648L;
	private CadastraUsuarioService service;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.service = new CadastraUsuarioService();

		List<Pessoa> contatos = this.service.buscarPessoas();

		request.setAttribute("contatos", contatos);

		request.getRequestDispatcher("lista-contatos.jsp").forward(request, response);
	}

}
