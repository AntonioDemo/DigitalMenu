/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dlmc.digitalmenu_server.controller;

import com.dlmc.digitalmenu_server.beans.OrdineBean;
import com.dlmc.digitalmenu_server.dao.OrdineDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gerardo
 */
public    class ListaOrdine {

       static private List<OrdineBean> listaOrdine =new ArrayList<OrdineBean>();
    public static void addOrdine(OrdineBean p) {
        listaOrdine.add(p);
    }

    public static List<OrdineBean> returnOrdine() {

     return   listaOrdine;
    }
    
    public static void setstato(int idordine, int stato){
       int i;
        for(i=0; i<listaOrdine.size() && listaOrdine.get(i).getOrdineId() != idordine; i++) 
              ;
        listaOrdine.get(i).setStato_c(stato);       
    }
    
    public static void setordini(){
        listaOrdine=OrdineDAO.caricaordini();
    }
}
