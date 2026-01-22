package com.example;

import java.util.List;

/**
 * Clase encargada de procesar y clasificar una lista de usuarios 
 * según sus roles de administrador o invitado.
 */
public class ProcesadorUsuarios {

    private static final int ROL_ADMIN = 1;
    private static final int ROL_INVITADO = 2;

    /**
     * Procesa una lista de cadenas con formato "nombre:rol" y devuelve 
     * una cadena resumen con los usuarios clasificados. (probandoo)
     * * @param usuarios Lista de strings que contienen el nombre y el ID de rol.
     * @return Una cadena de texto con los nombres de administradores e invitados.
     */
    public String procesarLista(List<String> usuarios) {
        String admins = "";
        String invitados = "";

        for (String u : usuarios) {
            String[] parts = u.split(":"); 
            if (parts.length == 2) {
                String nombre = parts[0];
                int rol = Integer.parseInt(parts[1]);

                if (rol == ROL_ADMIN) {
                    admins = procesarAdmin(admins, nombre);
                } else if (rol == ROL_INVITADO) {
                    invitados = procesarInvitados(invitados, nombre);
                }
            }
        }
        return "Admins: " + admins + " | Invitados: " + invitados;
    }

    /**
     * Formatea y añade un usuario a la cadena de invitados.
     * * @param invitados Cadena actual de invitados.
     * @param nombre Nombre del nuevo invitado a añadir.
     * @return Cadena de invitados actualizada.
     */
    private String procesarInvitados(String invitados, String nombre) {
        invitados = procesarAdmin(invitados, nombre);
        return invitados;
    }

    /**
     * Formatea y añade un usuario a la cadena de administradores.
     * * @param admins Cadena actual de administradores.
     * @param nombre Nombre del administrador a añadir.
     * @return Cadena de administradores actualizada.
     */
    private String procesarAdmin(String admins, String nombre) {
        admins += nombre + ",";
        return admins;
    }
}