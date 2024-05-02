package com.felipegandra.games.dao;

import java.util.List;

import com.felipegandra.games.model.Game;
import jakarta.persistence.EntityManager;

public class GameDao {

    private EntityManager em;
    public GameDao(EntityManager em) { this.em = em; }


    public void salvar(Game game) {
        em.persist(game);
    }

    public void atualizar(Game game) {
        em.merge(game);
    }

    public void remover(Game game) {
        Game gameExcluir = em.find(Game.class, game.getId());
        em.remove(gameExcluir);
    }

    public Game buscarGamePeloId(Long id) {
        return em.find(Game.class, id);
    }

    public List<Game> listarTodosOsGames() {

        String jpqlQuery = "SELECT g FROM Game g ORDER BY g.titulo ASC";
        return em.createQuery(jpqlQuery, Game.class).getResultList();

    }

    public List<Game> buscarGamePeloNome(String titulo) {

        String jpqlQuery = "SELECT g FROM Game g WHERE g.titulo = :titulo ";
        return em.createQuery(jpqlQuery, Game.class)
                .setParameter("titulo", titulo)
                .getResultList();

    }

    public List<Game> buscarGamesPorFaixaDeValores(Double valorIncial, Double ValorFinal) {

        String jpqlQuery = "SELECT g FROM Game g WHERE g.valor BETWEEN :valorInicial AND :valorFinal ORDER BY g.titulo ASC ";
        return em.createQuery(jpqlQuery, Game.class)
                .setParameter("valorInicial", valorIncial)
                .setParameter("valorFinal", ValorFinal)
                .getResultList();

    }

}