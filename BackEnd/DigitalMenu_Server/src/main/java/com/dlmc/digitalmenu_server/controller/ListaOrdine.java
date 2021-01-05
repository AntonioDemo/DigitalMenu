/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dlmc.digitalmenu_server.controller;

import com.dlmc.digitalmenu_server.beans.OrdineBean;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gerardo
 */
public    class ListaOrdine {
       static  List<OrdineBean> listaOrdine =new ArrayList<OrdineBean>();

    public static void addOrdine(OrdineBean p) {
        listaOrdine.add(p);
    }

    public static OrdineBean returnOrdine(int i) {
     return   ListaOrdine.listaOrdine.get(i) ;
    }
    
}
