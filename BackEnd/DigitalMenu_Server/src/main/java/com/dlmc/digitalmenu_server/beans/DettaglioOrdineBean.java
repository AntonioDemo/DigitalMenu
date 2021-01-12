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
public class DettaglioOrdineBean {
    ProdottoBean prodotto ;
    int quantita;
    String rimIng;
  

    public ProdottoBean getProdotto() {
        return prodotto;
    }

    public void setProdotto(ProdottoBean Prodotto) {
        this.prodotto = Prodotto;
    }

 

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public String getRimIng() {
        return rimIng;
    }

    public void setRimIng(String rimIng) {
        this.rimIng = rimIng;
    }


    

 
    
}
