package br.com.plgs.AppContatos.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.plgs.AppContatos.dto.ContatosDTO;
import br.com.plgs.AppContatos.model.Contato;

public interface ContatoServiceInterface {
	
	Contato save(Contato contato);
	Optional<Contato> findById(Long id);
	List<ContatosDTO> findByPessoaId(Long idPessoa);
	Contato update(Contato contato, Long id);
	void delete(Long id);

}
