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
    private String nome_Menu ;

    public MenuBean(int menuId, String nome_Menu) {
        this.menuId = menuId;
        this.nome_Menu = nome_Menu;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getNome_Menu() {
        return nome_Menu;
    }

    public void setNome_Menu(String nome_Menu) {
        this.nome_Menu = nome_Menu;
    }
    
    
    
}
