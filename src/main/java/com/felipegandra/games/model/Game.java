package com.felipegandra.games.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_games")
public class Game {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TBL_GAMES_SEQ"
    )
    @SequenceGenerator(
            name = "TBL_GAMES_SEQ",
            sequenceName = "TBL_GAMES_SEQ",
            allocationSize = 1
    )
    private Long id;

    private String titulo;

    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;

    private Double valor;
    private String produtora;
    private Boolean finalizado;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;


    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }


    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }


    public LocalDate getDataLancamento() { return dataLancamento; }
    public void setDataLancamento(LocalDate dataLancamento) { this.dataLancamento = dataLancamento; }


    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }


    public String getProdutora() { return produtora; }
    public void setProdutora(String produtora) { this.produtora = produtora; }


    public Boolean getFinalizado() { return finalizado; }
    public void setFinalizado(Boolean finalizado) { this.finalizado = finalizado; }


    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }


    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", dataLancamento=" + dataLancamento +
                ", valor=" + valor +
                ", produtora='" + produtora + '\'' +
                ", finalizado=" + finalizado +
                ", categoria='" + categoria.getNomeCategoria() + '\'' +
                '}';
    }

}