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
public class MenuBean {

    private int menuId;
    private String nomeMenu ;

    /**
     *
     * @param menuId
     * @param nome_Menu
     */
    public MenuBean(int menuId, String nome_Menu) {
        this.menuId = menuId;
        this.nomeMenu = nome_Menu;
    }

    /**
     *
     * @return
     */
    public int getMenuId() {
        return menuId;
    }

    /**
     *
     * @param menuId
     */
    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    /**
     *
     * @return
     */
    public String getNome_Menu() {
        return nomeMenu;
    }

    /**
     *
     * @param nome_Menu
     */
    public void setNome_Menu(String nome_Menu) {
        this.nomeMenu = nome_Menu;
    }

}
