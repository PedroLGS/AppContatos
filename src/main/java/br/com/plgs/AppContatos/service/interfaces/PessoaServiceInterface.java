package br.com.plgs.AppContatos.service.interfaces;

import java.util.List;

import java.util.Optional;

import br.com.plgs.AppContatos.model.Pessoa;

public interface PessoaServiceInterface {
	
	Pessoa save(Pessoa pessoa);
	Optional<Pessoa> findById(Long id);
	List<Pessoa> findAll();
	Pessoa update(Pessoa pessoa, Long id);
	void delete(Long id);

}
