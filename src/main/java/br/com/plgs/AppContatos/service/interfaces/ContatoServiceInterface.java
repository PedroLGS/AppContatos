package br.com.plgs.AppContatos.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.plgs.AppContatos.model.Contato;

public interface ContatoServiceInterface {
	
	Contato save(Contato contato);
	Optional<Contato> findById(Long id);
	List<Contato> findAllByPessoa(Long pessoa_Id);
	Contato update(Contato contato, Long id);
	void delete(Long id);

}
