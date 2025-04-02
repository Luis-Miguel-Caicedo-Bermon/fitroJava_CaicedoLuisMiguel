package controlador;

import vista.Vista;

import java.util.Scanner;

public class Controlador {
    Vista vista;
    Scanner s = new Scanner(System.in);

    public Controlador(Vista vista) {
        this.vista = vista;
    }

    public void iniciar(){
        boolean bucle = true;
        while (bucle==true) {
            vista.menu();
            String opc = s.nextLine();
            switch (opc){
                case "1":
                    vista.listarNinjaHabilidad();
                break;
                case "2":
                    vista.misionesDisponibles();
                break;
                case "4":
                    vista.asignarMision();
                break;
                case "5":
                    vista.completarMision();
                break;
                case "7":
                    bucle = false;
                break;
            }
        }
    }
}
