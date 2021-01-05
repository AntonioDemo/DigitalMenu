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
 private List<ProdottoBean> listaProdotti;

    public OrdineBean(int ordineid, int stato) {
        this.ordineId = ordineid;
        this.stato= stato;
  this.listaProdotti= new ArrayList<ProdottoBean>();
    }


    public int getOrdineId() {
        return ordineId;
    }

    public void setOrdineId(int ordineId) {
        this.ordineId = ordineId;
    }

    public List<ProdottoBean> getListaProdotti() {
        return listaProdotti;
    }

    public void setListaProdotti(List<ProdottoBean> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

    public void setComandaid(int ordineid) {
        this.ordineId = ordineid;
    }

    public int getStato() {
        return stato;
    }

    public void setStato_c(int stato) {
        this.stato= stato;
    }
 
 
}
