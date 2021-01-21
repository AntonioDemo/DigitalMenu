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
public class CategoriaBean {

    private int categoriaId ;
    private String nomeCat;
    private String foto;

    /**
     *
     */
    public CategoriaBean() {
         //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    public String getFoto() {
        return foto;
    }

    /**
     *
     * @param foto
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     *
     * @param categoriaId
     * @param nomeCat
     */
    public CategoriaBean(int categoriaId, String nomeCat) {
        this.categoriaId = categoriaId;
        this.nomeCat = nomeCat;
    }

    /**
     *
     * @return
     */
    public int getCategoriaId() {
        return categoriaId;
    }

    /**
     *
     * @param categoriaId
     */
    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    /**
     *
     * @return
     */
    public String getNomeCat() {
        return nomeCat;
    }

    /**
     *
     * @param nomeCat
     */
    public void setNomeCat(String nomeCat) {
        this.nomeCat = nomeCat;
    }
    
    
}
