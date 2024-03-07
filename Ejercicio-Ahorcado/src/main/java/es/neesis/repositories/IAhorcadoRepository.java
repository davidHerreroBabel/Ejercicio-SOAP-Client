package es.neesis.repositories;

import java.util.ArrayList;

public interface IAhorcadoRepository {

    void setPalabrasAEscoger(ArrayList<String> palabras);

    String getPalabraEscogida();

    char[] getPalabraDescubierta();

    void setIntentosRestantes(Integer intentosRestantes);

    void setPalabraADescubrirInicial(String palabraADescubrir);

    void setPalabraADescubrir(char[] palabra);

    ArrayList<String> getPalabras();
}
