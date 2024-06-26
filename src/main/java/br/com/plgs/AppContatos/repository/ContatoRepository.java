package br.com.plgs.AppContatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.plgs.AppContatos.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
	
	@Query(value = "SELECT * FROM tb_contatos "
			+ "WHERE pessoa_id = ?1", nativeQuery = true)
	List<Contato> findByPessoaId(Long idPessoa);

}
