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
public class OrdineBean {

    private  int  ordineId;
    private int stato;
    private List<DettagliOrdineBean> listaProdotti;

    /**
     *
     * @param ordineid
     * @param stato
     */
    public OrdineBean(int ordineid, int stato) {
        this.ordineId = ordineid;
        this.stato= stato;

        this.listaProdotti= new ArrayList<DettagliOrdineBean>();
    }

    /**
     *
     * @return
     */
    public int getOrdineId() {
        return ordineId;
    }

    /**
     *
     * @param ordineId
     */
    public void setOrdineId(int ordineId) {
        this.ordineId = ordineId;
    }

    /**
     *
     * @return
     */
    public List<DettagliOrdineBean> getListaProdotti() {
        return listaProdotti;
    }

    /**
     *
     * @param listaProdotti
     */
    public void setListaProdotti(List<DettagliOrdineBean> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

    /**
     *
     * @return
     */
    public int getStato() {
        return stato;
    }

    /**
     *
     * @param stato
     */
    public void setStato_c(int stato) {
        this.stato= stato;
    }
 
 
}
