package br.com.plgs.AppContatos.dto;

public record ContatosDTO(Long id,
				Integer tipoContato,
				String contato,
				Long idPessoa) { }
