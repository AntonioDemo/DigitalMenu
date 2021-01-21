/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dlmc.digitalmenu_server.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gerardo
 */
public class ProdottoBean {

    private int prodottoId;
    private double prezzo;
    private String foto;
    private String nome;
    private List<IngredienteBean> listaIngredienti;
        
    /**
     *
     * @param prodottoId
     * @param prezzo
     * @param foto
     * @param nome
     */
    public ProdottoBean(int prodottoId, double prezzo, String foto, String nome) {
        this.prodottoId = prodottoId;
        this.prezzo = prezzo;
        this.foto = foto;
        this.nome = nome;
        this.listaIngredienti=new ArrayList<IngredienteBean>();
        
    }

    /**
     *
     */
    public ProdottoBean() {//instanziare oggetto
      
    }

    /**
     *
     * @return
     */
    public int getProdottoId() {//ritorna prodotto
        return prodottoId;
    }

    /**
     *
     * @param prodottoId
     */
    public void setProdottoId(int prodottoId) {//parame
        this.prodottoId = prodottoId;
    }

    /**
     *
     * @return
     */
    public double getPrezzo() {
        return prezzo;
    }

    /**
     *
     * @param prezzo
     */
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    /**
     *
     * @return
     */
    public String getFoto() {
        return foto;
    }

    /**
     *
     * @param foto
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     *
     * @param i
     */
    public void addIngrediente (List<IngredienteBean> i) {
        this.listaIngredienti=i;
    }

    /**
     *
     * @param i
     * @return
     */
    public boolean removeIngrediente (IngredienteBean i) {
     return this.listaIngredienti.remove(i);
    }

    /**
     *
     * @return
     */
    public List<IngredienteBean> getListaIngredienti() {
        return listaIngredienti;
    }
        
}
