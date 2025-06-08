package br.ufscar.dc.dsw.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufscar.dc.dsw.domain.Editora;

public interface IEditoraDAO extends JpaRepository<Editora, Long>{
	Editora findByCNPJ(String cnpj);

}
