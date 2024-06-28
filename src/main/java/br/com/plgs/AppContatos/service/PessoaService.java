package br.com.plgs.AppContatos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plgs.AppContatos.dto.PessoaDTO;
import br.com.plgs.AppContatos.model.Pessoa;
import br.com.plgs.AppContatos.repository.PessoaRepository;
import br.com.plgs.AppContatos.service.interfaces.PessoaServiceInterface;

@Service
public class PessoaService implements PessoaServiceInterface {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public Pessoa save(Pessoa pessoa) {		
		if(pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
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
	public List<PessoaDTO> findByIdMalaDireta(Long id) {
		List<Object[]> listResult = pessoaRepository.findByIdMalaDireta(id);
		List<PessoaDTO> listPessoaDTO = new ArrayList<PessoaDTO>();
		
		for(Object[] obj : listResult) {
			PessoaDTO pDTO = returnDBPessoaDTO(obj);
			listPessoaDTO.add(pDTO);
		}
		return listPessoaDTO;
	}
	
	private PessoaDTO returnDBPessoaDTO(Object[] resultado) {
		if(resultado != null) {
			PessoaDTO pessoaDTO = new PessoaDTO(
					((Long)resultado[0]).longValue(),
					(String)resultado[1],
					(String)resultado[2]					
					);
			return pessoaDTO;
		} else {
			return null;
		}
	}
	
	@Override
	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}

	@Override
	public Pessoa update(Pessoa pessoa, Long id) {

		if(pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
			System.out.println("Nome da pessoa vazio.");
			return null;
		}

		Optional<Pessoa> findPessoa = pessoaRepository.findById(id);

		if(findPessoa.isPresent()) {
			Pessoa updPessoa = findPessoa.get();
			updPessoa.setNome(pessoa.getNome());
			updPessoa.setEndereco(pessoa.getEndereco());
			updPessoa.setCep(pessoa.getCep());
			updPessoa.setCidade(pessoa.getCidade());
			updPessoa.setUf(pessoa.getUf());

			try {
				return pessoaRepository.save(updPessoa);
			} catch (Exception e) {
				System.out.println("ERR: Erro ao atualizar pessoa " + updPessoa.toString() + ": " + e.getMessage());
				return null;
			}
		}
		return pessoaRepository.save(pessoa);
	}

	@Override
	public void delete(Long id) {
		pessoaRepository.deleteById(id);
		
	}
	
}
