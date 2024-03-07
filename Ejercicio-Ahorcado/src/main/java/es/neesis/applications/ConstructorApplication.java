package es.neesis.applications;

import es.neesis.repositories.IAhorcadoRepository;
import es.neesis.services.IAhorcadoService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

@Component
public class ConstructorApplication {
    private static final Integer INTENTOS_INICIALES = 8;
    private static final Scanner scanner = new Scanner(System.in);
    private static Boolean palabraCompletada = false;
    private final IAhorcadoService ahorcadoService;
    private final IAhorcadoRepository ahorcadoRepository;

    public ConstructorApplication(IAhorcadoService ahorcadoService, IAhorcadoRepository ahorcadoRepository) {
        this.ahorcadoService = ahorcadoService;
        this.ahorcadoRepository = ahorcadoRepository;
    }

    public void run() {
        String decision = leerDecision();
        if (isDecisionSalir(decision)) return;
        setPalabrasAEscoger();
        setPalabraADescubrir();
        actualizarPalabraDescubierta();
        informarResultadoFinPartida();
    }

    private String leerDecision() {
        boolean decisionPosible = false;
        String decision = "";
        System.out.println("Introduzca una de las siguientes opciones:");
        System.out.println(
                "Juego nuevo\n" +
                        "Salir\n"
        );
        while (!decisionPosible) {
            decision = scanner.nextLine();
            if (decision.equals("Juego nuevo") || decision.equals("Salir")) {
                decisionPosible = true;
            }
            else {
                System.out.println("Esta opción no es correcta. Vuelva a introducir una opción.");
            }
        }
        return decision;
    }

    private Boolean isDecisionSalir(String decision) {
        return decision.equals("Salir");
    }

    private void setPalabrasAEscoger() {
        ArrayList<String> palabras = new ArrayList<>(Arrays.asList("respetar", "solitario", "quimerico", "discreto",
                "tardanza", "ramarada", "triston", "sufridor", "elegante", "equivoco"));
        this.guardarPalabras(palabras);
        System.out.println("Estas son las posibles palabras a adivinar en este juego:");
        System.out.println(palabras);
    }

    public void guardarPalabras(ArrayList<String> palabras) {
        ahorcadoRepository.setPalabrasAEscoger(palabras);
    }

    private void setPalabraADescubrir() {
        ArrayList<String> palabras = ahorcadoRepository.getPalabras();
        String palabraADescubrirInicial = String.valueOf(escogerPalabraADescubrir(palabras));
        System.out.println("Esta es tu palabra inicial: " + palabraADescubrirInicial
                + ". Todas las letras estan en minúscula.");
    }

    public char[] escogerPalabraADescubrir(ArrayList<String> palabras) {
        String palabraADescubrir = ahorcadoService.obtenerPalabraADescubrir(palabras);
        ahorcadoRepository.setPalabraADescubrirInicial(palabraADescubrir);
        return ahorcadoRepository.getPalabraDescubierta();
    }

    private void actualizarPalabraDescubierta() {
        Integer intentosRestantes = INTENTOS_INICIALES;
        setIntentosRestantes(intentosRestantes);
        while (!palabraCompletada && intentosRestantes > 0) {
            System.out.println("Introduzca una letra o la palabra completa a buscar:");
            String palabra = scanner.nextLine();
            if (palabra.length() == 1) {
                char letraIntroducida = palabra.charAt(0);
                actualizarPalabraDescubierta(letraIntroducida);
                String palabraDescubierta = getPalabraDescubierta();
                String palabraEscogida = getPalabraEscogida();
                if (palabraDescubierta.equals(palabraEscogida)) {
                    palabraCompletada = true;
                }
            }
            else {
                palabraCompletada = isPalabraEscogida(palabra);
            }

            intentosRestantes = actualizarIntentosRestantes(intentosRestantes);
            mostrarEstadoPartida(intentosRestantes);
        }
    }

    public void setIntentosRestantes(Integer intentosRestantes) {
        ahorcadoRepository.setIntentosRestantes(intentosRestantes);
    }

    public void actualizarPalabraDescubierta(char letra) {
        String palabraEscogida = ahorcadoRepository.getPalabraEscogida();
        char[] palabraDescubierta = ahorcadoRepository.getPalabraDescubierta();
        char[] palabraDescubiertaActualizada = ahorcadoService.actualizarPalabraDescubierta(letra,
                palabraDescubierta, palabraEscogida);
        ahorcadoRepository.setPalabraADescubrir(palabraDescubiertaActualizada);
    }

    public Boolean isPalabraEscogida(String palabra) {
        String palabraEscogida = ahorcadoRepository.getPalabraEscogida();
        if (ahorcadoService.isPalabraEscogida(palabra, palabraEscogida)) {
            ahorcadoRepository.setPalabraADescubrir(palabra.toCharArray());
            return true;
        }
        return false;
    }

    private Integer actualizarIntentosRestantes(Integer intentosRestantes) {
        --intentosRestantes;
        setIntentosRestantes(intentosRestantes);
        return intentosRestantes;
    }

    private void mostrarEstadoPartida(Integer intentosRestantes) {
        String palabraDescubierta = getPalabraDescubierta();
        System.out.println("Este es tu estado de la palabra actual " + palabraDescubierta + " .");
        System.out.println("Te quedan " + intentosRestantes + " intentos restantes.");
    }

    public String getPalabraDescubierta() {
        return String.valueOf(ahorcadoRepository.getPalabraDescubierta());
    }

    private void informarResultadoFinPartida() {
        if (palabraCompletada) {
            System.out.println("Felicidades! Has superado al ahorcado.");
        } else {
            String palabraEscogida = getPalabraEscogida();
            System.out.println("Te has quedado sin intentos. La palabra a adivinar era " + palabraEscogida + ".");
        }
    }

    public String getPalabraEscogida() {
        return ahorcadoRepository.getPalabraEscogida();
    }

}
