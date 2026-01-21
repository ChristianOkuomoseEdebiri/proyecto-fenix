package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class ProcesadorUsuariosTest {

    @Test
    public void testProcesarLista() {
        ProcesadorUsuarios procesador = new ProcesadorUsuarios();
        List<String> datos = Arrays.asList("Juan:1", "Maria:2");
        
        String resultado = procesador.procesarLista(datos);
        
        // Verificamos que el resultado contenga a los usuarios en sus roles
        assertTrue(resultado.contains("Admins: Juan"));
        assertTrue(resultado.contains("Invitados: Maria"));
    }
}