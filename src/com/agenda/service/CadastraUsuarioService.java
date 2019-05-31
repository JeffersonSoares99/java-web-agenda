package com.agenda.service;

import java.util.List;

import com.agenda.dao.PessoaDAO;
import com.agenda.model.Pessoa;

public class CadastraUsuarioService 
{
 private PessoaDAO dao = new PessoaDAO();
 



	public List<Pessoa> buscarPessoas() {
		return this.dao.buscaPessoas();
	}
	
	public void removeContato (Pessoa pessoa) {	
		this.dao.removerContato(pessoa);
		
	}

	public void cadastrarOuAlterar(Pessoa pessoa)
	{
		if(0 != pessoa.getId()) { 
		 
				this.dao.alterar(pessoa);
		}
		else
		{
			this.dao.cadastro(pessoa);
			
		}
	}


}
