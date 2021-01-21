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
     
    /**
     *
     * @param nome_Ing
     * @param ingredienteId
     * @param isRimovibile
     */
    public IngredienteBean(String nome_Ing, int ingredienteId,int isRimovibile) {
        this.nomeIng = nome_Ing;
        this.ingredienteId = ingredienteId;
        this.isRimovibile=isRimovibile;
    }

    /**
     *
     */
    public IngredienteBean() {
 
    }

    /**
     *
     * @return
     */
    public String getNome_Ing() {
        return nomeIng;
    }

    /**
     *
     * @return
     */
    public int isIsRimovibile() {
        return isRimovibile;
    }

    /**
     *
     * @param isRimovibile
     */
    public void setIsRimovibile(int isRimovibile) {
        this.isRimovibile = isRimovibile;
    }

    /**
     *
     * @param nome_Ing
     */
    public void setNome_Ing(String nome_Ing) {
        this.nomeIng = nome_Ing;
    }

    /**
     *
     * @return
     */
    public int getIngredienteId() {
        return ingredienteId;
    }

    /**
     *
     * @param ingredienteId
     */
    public void setIngredienteId(int ingredienteId) {
        this.ingredienteId = ingredienteId;
    }
     
     
    
}
