/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dlmc.digitalmenu_server.beans;

import java.util.ArrayList;

/**
 *
 * @author Gerardo
 */
public class ProdottoBean {
    	private int prodottoId;
	private double prezzo;
	private String foto;
        private String nome ;
        private ArrayList<IngredienteBean> listaIngredienti;
        
    public ProdottoBean(int prodottoId, double prezzo, String foto, String nome) {
        this.prodottoId = prodottoId;
        this.prezzo = prezzo;
        this.foto = foto;
        this.nome = nome;
     this.listaIngredienti= new ArrayList<IngredienteBean>();
        
    }

    public ProdottoBean() {
      
    }

    public int getProdottoId() {
        return prodottoId;
    }

    public void setProdottoId(int prodottoId) {
        this.prodottoId = prodottoId;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
       public void addIngrediente (IngredienteBean i) {
        this.listaIngredienti.add(i);
    }
           public boolean removeIngrediente (IngredienteBean i) {
     return this.listaIngredienti.remove(i);
    }
        
}
