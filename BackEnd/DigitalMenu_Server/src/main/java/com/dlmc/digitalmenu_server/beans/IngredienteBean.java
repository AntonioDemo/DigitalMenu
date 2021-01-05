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
     private String nomeIng ;
     private int ingredienteId;
     private int isRimovibile ;
     

    public IngredienteBean(String nome_Ing, int ingredienteId,int isRimovibile) {
        this.nomeIng = nome_Ing;
        this.ingredienteId = ingredienteId;
        this.isRimovibile=isRimovibile;
    }

    public IngredienteBean() {
 
    }

    public String getNome_Ing() {
        return nomeIng;
    }

    public int isIsRimovibile() {
        return isRimovibile;
    }

    public void setIsRimovibile(int isRimovibile) {
        this.isRimovibile = isRimovibile;
    }

    public void setNome_Ing(String nome_Ing) {
        this.nomeIng = nome_Ing;
    }

    public int getIngredienteId() {
        return ingredienteId;
    }

    public void setIngredienteId(int ingredienteId) {
        this.ingredienteId = ingredienteId;
    }
     
     
    
}
