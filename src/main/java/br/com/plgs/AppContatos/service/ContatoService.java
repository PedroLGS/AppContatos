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
			if (!findPessoa.isEmpty()) {
				contato.setPessoa(findPessoa.get());
			} else {
				System.out.println("Pessoa não encontrada: " + contato.getPessoa().getId());
				return null;
			}
		} else {
			System.out.println("Pessoa não encontrada!");
			return null;
		}

		try {
			return contatoRepository.save(contato);
		} catch (Exception e) {
			System.out.println("ERR: Erro ao inserir contato " + contato.toString() + ": " + e.getMessage());
			return null;
		}

	}

	@Override
	public Optional<Contato> findById(Long id) {
		return contatoRepository.findById(id);
	}

	@Override
	public List<Contato> findByPessoaId(Long idPessoa) {
		return contatoRepository.findByPessoaId(idPessoa);
	}
	
	@Override
	public Contato update(Contato contato, Long id) {

		Optional<Contato> findContato = contatoRepository.findById(id);

		if (findContato.isPresent()) {
			Contato updContato = findContato.get();
			updContato.setTipoContato(contato.getTipoContato());
			updContato.setContato(contato.getContato());

			try {
				return contatoRepository.save(updContato);
			} catch (Exception e) {
				System.out.println("ERR: Erro ao atualizar contato " + updContato.toString() + ": " + e.getMessage());
				return null;
			}
		} else {
			System.out.println("Contato com ID: " + id + " não encontrado.");
			return null;
		}
	}

	@Override
	public void delete(Long id) {
		contatoRepository.deleteById(id);
		
	}

}
