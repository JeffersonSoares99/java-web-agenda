package com.agenda.service;

import java.util.List;

import com.agenda.dao.PessoaDAO;
import com.agenda.model.Pessoa;

public class CadastraUsuarioService {

	public void cadastra(Pessoa pessoa) {
		PessoaDAO canal = new PessoaDAO();
		canal.cadastro(pessoa);
	}

	public List<Pessoa> buscarPessoas() {
		PessoaDAO dao = new PessoaDAO();
		return dao.buscaPessoas();
	}
	
	public void removeContato (Pessoa pessoa) {	
		PessoaDAO dao = new PessoaDAO();
		dao.removerContato(pessoa);
		
	}

}
