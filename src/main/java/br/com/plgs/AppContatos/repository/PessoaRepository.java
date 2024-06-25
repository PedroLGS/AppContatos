package br.com.plgs.AppContatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.plgs.AppContatos.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	@Query(value = "select p.id, p.nome, p.cep, p.cidade, p.uf from tb_pessoa p", nativeQuery = true)
	List<Object[]> findByIdMalaDireta();

}
