package es.neesis.repositories;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class AhorcadoRepository implements IAhorcadoRepository {

    private ArrayList<String> palabras;
    private String palabraEscogida;
    private char[] palabraDescubierta;
    private Integer intentosRestantes;

    @Override
    public void setPalabrasAEscoger(ArrayList<String> palabras) {
        this.palabras = palabras;
    }

    @Override
    public String getPalabraEscogida() {
        return this.palabraEscogida;
    }

    public char[] getPalabraDescubierta() {
        return this.palabraDescubierta;
    }

    @Override
    public void setIntentosRestantes(Integer intentosRestantes) {
        this.intentosRestantes = intentosRestantes;
    }

    @Override
    public void setPalabraADescubrirInicial(String palabraADescubrir) {
        this.palabraEscogida = palabraADescubrir;
        String character = "_";
        this.palabraDescubierta = character.repeat(palabraADescubrir.length()).toCharArray();
    }

    @Override
    public void setPalabraADescubrir(char[] palabra) {
        this.palabraDescubierta = palabra;
    }

    @Override
    public ArrayList<String> getPalabras() {
        return this.palabras;
    }

}
