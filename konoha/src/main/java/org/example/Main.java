package org.example;

import controlador.Controlador;
import modelo.Ninja;
import modelo.NinjaDAO;
import vista.Vista;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista);
        controlador.iniciar();
    }
}