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
public class OrdineBean {

 private  int  ordineId;
 private int stato;

    public OrdineBean(int ordineid, int stato) {
        this.ordineId = ordineid;
        this.stato= stato;
    }

    public int getComandaid() {
        return ordineId;
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
