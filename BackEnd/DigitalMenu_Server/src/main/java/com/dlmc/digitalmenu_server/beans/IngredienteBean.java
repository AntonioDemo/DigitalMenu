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
public class IngredienteBean {
     private String nome_Ing ;
     private int ingredienteId;
     private boolean isRimovibile ;
     

    public IngredienteBean(String nome_Ing, int ingredienteId,boolean isRimovibile) {
        this.nome_Ing = nome_Ing;
        this.ingredienteId = ingredienteId;
        this.isRimovibile=isRimovibile;
    }

    public String getNome_Ing() {
        return nome_Ing;
    }

    public boolean isIsRimovibile() {
        return isRimovibile;
    }

    public void setIsRimovibile(boolean isRimovibile) {
        this.isRimovibile = isRimovibile;
    }

    public void setNome_Ing(String nome_Ing) {
        this.nome_Ing = nome_Ing;
    }

    public int getIngredienteId() {
        return ingredienteId;
    }

    public void setIngredienteId(int ingredienteId) {
        this.ingredienteId = ingredienteId;
    }
     
     
    
}
