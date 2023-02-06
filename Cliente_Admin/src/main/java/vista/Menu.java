package vista;

import java.util.Date;
import java.util.List;

import models.Manager;

import servicios.ManagerServices;

public class Menu {

    public static void main(String[] args) {

        ManagerServices objManagerServices = new ManagerServices();

        System.out.println("consultando un cliente con username dgustin");
        Manager objManagerConsultado = objManagerServices.consultarManager("dgustin");
        imprimirManager(objManagerConsultado);

        List<Manager> listaDeManagers = objManagerServices.listarManagers();

        for (Manager manager : listaDeManagers) {
            imprimirManager(manager);
        }

        FrmLogin frmLogin = new FrmLogin();
        frmLogin.setVisible(true);

    }

    private static void imprimirManager(Manager objManager) {
        System.out.println("Manager:");
        System.out.println(objManager.getName());
        System.out.println(objManager.getLastname());
        System.out.println(objManager.getUsername());
        System.out.println(objManager.getPassword());

    }

}
