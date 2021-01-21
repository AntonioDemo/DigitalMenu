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
        
    /**
     *
     * @param quanti
     * @param delete
     * @param prod
     */
    public DettagliOrdineBean(int quanti, String delete, ProdottoBean prod) {
        quantita = quanti;
        deleteing = delete;
        prodotto = prod;
    }

    /**
     *
     * @return
     */
    public int getquantita() {
        return quantita;
    }

    /**
     *
     * @param quanti
     */
    public void setquantita(int quanti) {
        quantita=quanti;
    }

    /**
     *
     * @return
     */
    public ProdottoBean getProdotto() {
        return prodotto;
    }

    /**
     *
     * @param prodo
     */
    public void setProdotto(ProdottoBean prodo) {
        prodotto = prodo;
    }

    /**
     *
     * @return
     */
    public String getIngedienteRimosso() {
        return deleteing;
    }

    /**
     *
     * @param ing
     */
    public void setIngerdienteRimosso(String ing) {
        deleteing = ing;
    }

}