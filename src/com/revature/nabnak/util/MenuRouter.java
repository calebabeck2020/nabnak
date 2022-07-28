package com.revature.nabnak.util;

import com.revature.nabnak.menus.Menu;

public class MenuRouter {

    private final Menu[] menus;

    public MenuRouter() {
        menus = new Menu[0];
    }

    public void addMenu(Menu addedMenu) {

        for(int i = 0; i < menus.length; i++) {
            if (menus[i] == null) {
                menus[i] = addedMenu;
            } else if (menus != null) {
                System.out.println("Next index please");
            }
        }
    }

    public void transfer(String route) {
        for (Menu menu: menus) {
            if (menu.getRoute().equals(route)) {
                try {
                    menu.render();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
