package br.com.plgs.AppContatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.plgs.AppContatos.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
	
	@Query(value = "select c.id, c.tipo_contato, c.contato, c.pessoa_id from tb_contatos c "
			+ "inner join tb_pessoa p "
			+ "on c.pessoa_id = p.id "
			+ "where p.id = ?1",
			nativeQuery = true)
	List<Object[]> findByPessoaId(Long id);

}
