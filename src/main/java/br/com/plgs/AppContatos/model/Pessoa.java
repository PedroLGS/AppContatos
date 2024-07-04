package br.com.plgs.AppContatos.model;

import java.util.List;
import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="tb_pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@NotEmpty(message = "Nome vazio")
	@Length(max = 100, message = "O nome deve ter no máximo 100 caracteres")
	private String nome;
	
	@Column(nullable = true)
	@Length(max = 100, message = "O endereço deve ter no máximo 100 caracteres")
	private String endereco;
	
	@Column(nullable = true)
	@Length(max = 9, message = "O cep deve ter no máximo 9 caracteres")
	private String cep;
	
	@Column(nullable = true)
	@Length(max = 100, message = "O nome da cidade deve ter no máximo 100 caracteres")
	private String cidade;
	
	@Column(nullable = true)
	@Length(max = 2, message = "O UF deve ter no máximo 2 caracteres")
	private String uf;
	
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	private List<Contato> contatos;
	
	public Pessoa() { }
	
	public Pessoa(Long id, String nome, String endereco, String cep, String cidade, String uf) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "[id = " 		+ this.id 		+ ", " +
			   "[Nome = " 		+ this.nome 	+ ", " +
			   "[Endereco = " 	+ this.endereco + ", " +
			   "[Cep = " 		+ this.cep 		+ ", " +
			   "[Cidade = " 	+ this.cidade 	+ ", " +
			   "[Uf = " 		+ this.uf 		+ "]";
		
	}
		
}