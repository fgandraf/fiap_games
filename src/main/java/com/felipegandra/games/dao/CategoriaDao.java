package com.felipegandra.games.dao;

import com.felipegandra.games.model.Categoria;
import jakarta.persistence.EntityManager;

public class CategoriaDao {

    private EntityManager em;

    public CategoriaDao(EntityManager em) { this.em = em; }

    public void salvar(Categoria categoria) {
        em.persist(categoria);
    }

    public Categoria buscarCategoriaPeloId(Long id){
        return em.find(Categoria.class, id);
    }

}
