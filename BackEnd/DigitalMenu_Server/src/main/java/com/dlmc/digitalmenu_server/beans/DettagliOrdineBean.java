/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dlmc.digitalmenu_server.beans;


/**
 *
 * @author Gerardo
 */
public class DettagliOrdineBean {
    	private int quantita;
        private String deleteing;
        private ProdottoBean prodotto;
        
    public DettagliOrdineBean(int quanti, String delete, ProdottoBean prod) {
        quantita = quanti;
        deleteing = delete;
        prodotto = prod;
    }

    public int getquantita() {
        return quantita;
    }

    public void setquantita(int quanti) {
        quantita=quanti;
    }

    public ProdottoBean getProdotto() {
        return prodotto;
    }

    public void setProdotto(ProdottoBean prodo) {
        prodotto = prodo;
    }

    public String getIngedienteRimoso() {
        return deleteing;
    }

    public void setIngerdienteRimosso(String ing) {
        deleteing = ing;
    }

}