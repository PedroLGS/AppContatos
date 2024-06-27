package br.com.plgs.AppContatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.plgs.AppContatos.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	@Query(value = "SELECT p.id, p.nome, "
			+ "CONCAT(p.endereco, ', – CEP: ', p.cep, ' – ', p.cidade, '/', p.uf) "
			+ "FROM tb_pessoa p "
			+ "WHERE p.id = ?1", nativeQuery = true)
	List<Object[]> findByIdMalaDireta(Long id);

}
