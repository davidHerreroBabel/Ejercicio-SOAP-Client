package es.neesis.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class AhorcadoService implements IAhorcadoService {

    @Override
    public char[] actualizarPalabraDescubierta(Character letra, char[] palabraDescubierta,
                                               String palabraEscogida) {
        for (int i = 0; i < palabraEscogida.length(); ++i) {
            if (palabraEscogida.charAt(i) == letra) {
                palabraDescubierta[i] = palabraEscogida.charAt(i);
            }
        }
        return palabraDescubierta;
    }

    @Override
    public Boolean isPalabraEscogida(String palabra, String palabraEscogida) {
        return palabraEscogida.equals(palabra);
    }

    @Override
    public String obtenerPalabraADescubrir(ArrayList<String> palabras) {
        Random random = new Random();
        int intRandom = random.nextInt(palabras.size());
        return palabras.get(intRandom);
    }

}
