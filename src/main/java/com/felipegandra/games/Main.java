package com.felipegandra.games;


import com.felipegandra.games.dao.Conexao;
import com.felipegandra.games.dao.GameDao;
import com.felipegandra.games.model.Game;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManager em = Conexao.getEntityManager();

        //cadastrar(em);
        //atualizar(em);
        //pesquisar(em);
        //listarTodosOsGames(em);
        //buscarGamePeloNome(em);
        //buscarGamesPorFaixaDeValores(em);
        //remover(em);

        em.close();
    }




    public static void cadastrar(EntityManager em) {

        Game game1 = new Game();
        game1.setTitulo("Street Fighter II");
        game1.setCategoria("luta");
        game1.setDataLancamento(LocalDate.of(1991, 7, 1));
        game1.setFinalizado(true);
        game1.setProdutora("Sega");
        game1.setValor(99.99);

        em.getTransaction().begin();
        GameDao gameDao = new GameDao(em);
        gameDao.salvar(game1);
        em.getTransaction().commit();
        em.close();
    }



    public static void atualizar(EntityManager em) {

        Game streetFighter = new Game();
        streetFighter.setId(2L);
        streetFighter.setTitulo("Street Fighter II");
        streetFighter.setCategoria("luta");
        streetFighter.setDataLancamento(LocalDate.of(1991, 7, 1));
        streetFighter.setFinalizado(true);
        streetFighter.setProdutora("Sega");
        streetFighter.setValor(155.99);

        em.getTransaction().begin();
        GameDao gameDao = new GameDao(em);
        gameDao.atualizar(streetFighter);
        em.getTransaction().commit();
        em.close();
    }



    public static void pesquisar(EntityManager em) {

        GameDao gameDao = new GameDao(em);
        Game gameEncontrado = gameDao.buscarGamePeloId(2L);

        if (gameEncontrado != null) {
            System.out.println(gameEncontrado.toString());
        } else {
            System.out.println("Game não encontrado!");
        }
    }



    public static void listarTodosOsGames(EntityManager em) {
        GameDao gameDao = new GameDao(em);
        List<Game> games = gameDao.listarTodosOsGames();

        for (Game game : games) {
            System.out.println(game);
            System.out.println("------------------------");
        }
    }



    public static void buscarGamePeloNome(EntityManager em) {
        GameDao gameDao = new GameDao(em);
        List<Game> games = gameDao.buscarGamePeloNome("Street Fighter II");

        for (Game game : games) {
            System.out.println(game);
            System.out.println("------------------------");
        }
    }



    public static void buscarGamesPorFaixaDeValores(EntityManager em) {
        GameDao gameDao = new GameDao(em);
        List<Game> games = gameDao.buscarGamesPorFaixaDeValores(150.0, 300.0);

        for (Game game : games) {
            System.out.println(game);
            System.out.println("------------------------");
        }
    }

    public static void remover(EntityManager em){
        GameDao gameDao = new GameDao(em);

        Game gameParaRemover = new Game();
        gameParaRemover.setId(2L);

        em.getTransaction().begin();
        gameDao.remover(gameParaRemover);
        em.getTransaction().commit();
        em.close();
    }

}
