package br.com.batalhao.socialbooks.application;

import java.time.LocalDate;

import br.com.batalhao.socialbooks.client.LivrosClient;
import br.com.batalhao.socialbooks.client.domain.Livro;

public class ClientApplication {

	public static void main(String[] args) {
		LivrosClient livrosClient = new LivrosClient();

		Livro livro = new Livro();
		livro.setNome("Java Completo e Total");
		livro.setEditora("Nova Brasil");
		livro.setPublicacao(LocalDate.of(2017, 10, 05));
		livro.setNumeroPaginas(300);
		System.out.println(livrosClient.save(livro));

		livrosClient.list().stream().forEach(record -> System.out.println(record.getNome()));
	}

}
