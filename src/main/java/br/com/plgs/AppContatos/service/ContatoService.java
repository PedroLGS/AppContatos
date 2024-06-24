package br.com.plgs.AppContatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plgs.AppContatos.model.Contato;
import br.com.plgs.AppContatos.model.Pessoa;
import br.com.plgs.AppContatos.repository.ContatoRepository;
import br.com.plgs.AppContatos.repository.PessoaRepository;
import br.com.plgs.AppContatos.service.interfaces.ContatoServiceInterface;

@Service
public class ContatoService implements ContatoServiceInterface {

	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public Contato save(Contato contato) {
		if(contato.getPessoa().getId() != null) {
			Optional<Pessoa> findPessoa = pessoaRepository.findById(contato.getPessoa().getId());
			if(!findPessoa.isEmpty()) {
				contato.setPessoa(findPessoa.get());
				return contatoRepository.save(contato);
			} else {
				System.out.println("Pessoa não encontrada: " + contato.getPessoa().getId());
				return null;
			}
		} else {
			System.out.println("Pessoa não encontrada!");
			return null;
		}
	}

	@Override
	public Optional<Contato> findById(Long id) {
		return contatoRepository.findById(id);
	}

	@Override
	public List<Contato> findAllByPessoa(Long pessoaId) {
		return contatoRepository.findByPessoaId(pessoaId);
	}

	@Override
	public Contato update(Contato contato, Long id) {
		Optional<Contato> findContato = contatoRepository.findById(id);
		
		if(findContato.isPresent()) {
			Contato updContato = findContato.get();
			updContato.setTipoContato(contato.getTipoContato());
			updContato.setContato(contato.getContato());
			
			return contatoRepository.save(updContato);
		} else {
			return save(contato);
		}
	}

	@Override
	public void delete(Long id) {
		contatoRepository.deleteById(id);
		
	}

}
