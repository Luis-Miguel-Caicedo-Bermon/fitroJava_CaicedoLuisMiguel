package vista;

import modelo.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vista {
    Scanner s = new Scanner(System.in);
    public void menu(){
        System.out.println("""
                =======MENU=======
                1.Listar todos los ninjas junto con sus habilidades.
                2.Mostrar las misiones disponibles para un ninja específico.
                3.Mostrar las misiones completadas para un ninja específico.
                4.Asignar una misión a un ninja, registrando la fecha de inicio.
                5.Marcar una misión como completada, registrando la fecha de finalización.
                6.Mostrar todas las misiones completadas (funcionalidad descrita en el apartado de archivos de texto).
                7.salir
                """);
    }

    public void listarNinjaHabilidad(){
        List<Ninja> ninjaList = new ArrayList<>();
        NinjaDAO ninjaDAO = new NinjaDAO();
        ninjaList = ninjaDAO.getNinjas();

        List<Habilidad> habilidadList = new ArrayList<>();
        HabilidadDAO habilidadDAO = new HabilidadDAO();
        habilidadList = habilidadDAO.getHabilidad();

        for (Ninja ninja: ninjaList){
            for (Habilidad habilidad: habilidadList){
                if (ninja.getId()==habilidad.getIdNinja()){
                    System.out.println(ninja.toString()+habilidad.toString());
                }
            }
        }
    }

    public void misionesDisponibles(){
        System.out.println("Ingresa el id del ninja");
        int idNinja = s.nextInt();
        NinjaDAO ninjaDAO = new NinjaDAO();
        Ninja ninja = ninjaDAO.getNinjaPorID(idNinja);

        MisionDAO misionDAO = new MisionDAO();
        List<Mision> misionList = misionDAO.getMisionesDisponibles();

        System.out.println("Misiones disponibles para "+ninja.getNombre());
        for (Mision mision: misionList){
            if (mision.getRango().equals(ninja.getRango())){
                System.out.println(mision.toString());
            }
        }
    }

    public void asignarMision(){
        System.out.println("Ingresa el id del ninja");
        int idNinja = s.nextInt();
        NinjaDAO ninjaDAO = new NinjaDAO();
        Ninja ninja = ninjaDAO.getNinjaPorID(idNinja);

        MisionDAO misionDAO = new MisionDAO();
        List<Mision> misionList = misionDAO.getMisionesDisponibles();

        MisionNinja misionNinja = new MisionNinja();
        MisionNinjaDAO misionNinjaDAO = new MisionNinjaDAO();

        System.out.println("asignar mision a "+ninja.getNombre());
        System.out.println("Ingresa el id de la mision");
        int idMision = s.nextInt();
        for (Mision mision: misionList){
            if (mision.getRango().equals(ninja.getRango()) && mision.getId()==idMision){
                misionNinja.setIdNinja(idNinja);
                misionNinja.setIdMision(idMision);
                LocalDateTime ahora = LocalDateTime.now();
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String fechaActual = ahora.format(formato);
                misionNinja.setFechaInicio(fechaActual);
                misionNinja.setFechafin(null);
                misionNinjaDAO.asignarMision(misionNinja);
                System.out.println("se asignó la mision");
            }
        }
    }

    public void completarMision(){;
        System.out.println("Ingresa el id de la mision");
        int idMision = s.nextInt();


        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaActual = ahora.format(formato);

        MisionNinjaDAO misionNinjaDAO = new MisionNinjaDAO();
        misionNinjaDAO.completarMision(idMision,fechaActual);

    }
}
