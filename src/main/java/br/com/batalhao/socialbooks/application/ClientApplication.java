package br.com.batalhao.socialbooks.application;

import java.time.LocalDate;

import br.com.batalhao.socialbooks.client.LivrosClient;
import br.com.batalhao.socialbooks.client.domain.Livro;

public class ClientApplication {

	public static void main(String[] args) {
		LivrosClient livrosClient = new LivrosClient("http://localhost:8080", "user", "user");

		livrosClient.list().stream().forEach(record -> System.out.println(record.getNome()));

		System.out.println("====================");

		Livro livro = new Livro();
		livro.setNome("Java Completo e Total 2");
		livro.setEditora("Nova Brasil");
		livro.setPublicacao(LocalDate.of(2017, 10, 05));
		livro.setNumeroPaginas(300);
		String uriRetorno = livrosClient.save(livro);
		System.out.println(uriRetorno);

//		System.out.println("====================");

		System.out.println(livrosClient.find(uriRetorno).getNome());
	}

}
