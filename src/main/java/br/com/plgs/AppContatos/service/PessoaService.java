package br.com.plgs.AppContatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plgs.AppContatos.model.Pessoa;
import br.com.plgs.AppContatos.repository.PessoaRepository;
import br.com.plgs.AppContatos.service.interfaces.PessoaServiceInterface;

@Service
public class PessoaService implements PessoaServiceInterface {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public Pessoa save(Pessoa pessoa) {		
		if(pessoa.getNome() == null) {
			System.out.println("Nome da pessoa vazio.");
			return null;
		}
		
		try {
			return pessoaRepository.save(pessoa);
		} catch(Exception e) {
			System.out.println("ERRO: Erro ao inserir pessoa " + pessoa.toString() + ": " + e.getMessage());
			return null;
		}
	}

	@Override
	public Optional<Pessoa> findById(Long id) {
		return pessoaRepository.findById(id);
	}

	@Override
	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}

	@Override
	public Pessoa update(Pessoa pessoa, Long id) {
		Optional<Pessoa> findPessoa = pessoaRepository.findById(id);
		
		if(findPessoa.isPresent()) {
			Pessoa updPessoa = findPessoa.get();
			updPessoa.setNome(pessoa.getNome());			
			updPessoa.setEndereco(pessoa.getEndereco());
			updPessoa.setCep(pessoa.getCep());
			updPessoa.setCidade(pessoa.getCidade());
			updPessoa.setUf(pessoa.getUf());
			
			return pessoaRepository.save(updPessoa);
		}
		return pessoaRepository.save(pessoa);
	}

	@Override
	public void delete(Long id) {
		pessoaRepository.deleteById(id);
		
	}
	
}
