package es.neesis.services;

import java.util.ArrayList;

public interface IAhorcadoService {

    char[] actualizarPalabraDescubierta(Character letra,
                                        char[] palabraDescubierta, String palabraEscogida);

    Boolean isPalabraEscogida(String palabra, String palabraEscogida);

    String obtenerPalabraADescubrir(ArrayList<String> palabras);

}
