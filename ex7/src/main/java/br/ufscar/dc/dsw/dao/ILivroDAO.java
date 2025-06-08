package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufscar.dc.dsw.domain.Livro;

public interface ILivroDAO extends JpaRepository<Livro, Long>{

	List<Livro> findAllByOrderByPrecoAsc();
	Livro findByTitulo(String titulo);


}