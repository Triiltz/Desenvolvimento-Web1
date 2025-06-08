package br.ufscar.dc.dsw;

import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.ufscar.dc.dsw.dao.IEditoraDAO;
import br.ufscar.dc.dsw.dao.ILivroDAO;
import br.ufscar.dc.dsw.domain.Editora;
import br.ufscar.dc.dsw.domain.Livro;

@SpringBootApplication
public class LivrariaJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(LivrariaJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LivrariaJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(IEditoraDAO editoraDAO, ILivroDAO livroDAO) {
        return (args) -> {

            Editora editoraSeguinte = editoraDAO.findByCNPJ("87.557.922/0001-82");
            if (editoraSeguinte == null) {
                log.info("Criando nova editora: Seguinte");
                editoraSeguinte = new Editora();
                editoraSeguinte.setCNPJ("87.557.922/0001-82");
                editoraSeguinte.setNome("Seguinte");
                editoraDAO.save(editoraSeguinte);
            }

            Editora editoraCiaLetras = editoraDAO.findByCNPJ("55.789.390/0008-99");
            if (editoraCiaLetras == null) {
                log.info("Criando nova editora: Companhia das Letras");
                editoraCiaLetras = new Editora();
                editoraCiaLetras.setCNPJ("55.789.390/0008-99");
                editoraCiaLetras.setNome("Companhia das Letras");
                editoraDAO.save(editoraCiaLetras);
            }

            Livro livro1 = livroDAO.findByTitulo("O Dia do Curinga");
            if (livro1 == null) {
                log.info("Criando novo livro: O Dia do Curinga");
                livro1 = new Livro();
                livro1.setTitulo("O Dia do Curinga");
                livro1.setAutor("Jostein Gaarder");
                livro1.setAno(1996);
                livro1.setPreco(new BigDecimal("29.99"));
                livro1.setEditora(editoraSeguinte); 
                livroDAO.save(livro1);
            }

            Livro livro2 = livroDAO.findByTitulo("A Revolução dos Bichos");
            if (livro2 == null) {
                log.info("Criando novo livro: A Revolução dos Bichos");
                livro2 = new Livro();
                livro2.setTitulo("A Revolução dos Bichos");
                livro2.setAutor("George Orwell");
                livro2.setAno(2007);
                livro2.setPreco(new BigDecimal("23.90"));
                livro2.setEditora(editoraCiaLetras); 
                livroDAO.save(livro2);
            }

            log.info("Livros recuperados (ordenados por preço):");
            log.info("-----------------------------------------");
            livroDAO.findAllByOrderByPrecoAsc().forEach(livro -> log.info(livro.toString()));
            log.info("");
        };
    }
}