package br.italo.main;


import br.italo.api.*;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws InterruptedException, SQLException {

        api menu = new api();

        menu.newApi(args);


    }

}