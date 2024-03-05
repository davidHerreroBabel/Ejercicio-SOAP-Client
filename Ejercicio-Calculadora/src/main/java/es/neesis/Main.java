package es.neesis;

import es.neesis.applications.ConstructorApplication;
import es.neesis.configuration.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConstructorApplication application = context.getBean(ConstructorApplication.class);;

        System.out.println("Sumar\n" +
                "Restar\n" +
                "Multiplicar\n" +
                "Dividir\n" +
                "Salir\n" +
                "Seleccione una operación: ");

        Scanner scanner = new Scanner(System.in);
        String operation = scanner.nextLine();
        System.out.println("Introduzca el operando 1: ");
        Double value1 = scanner.nextDouble();
        System.out.println("Introduzca el operando 2: ");
        Double value2 = scanner.nextDouble();

        Double result = application.calculateResult(value1, value2, operation);
        if (result.equals(Double.NaN)) {
            System.out.println("Esta operación no está disponible. Vuelva a intentarlo.");
        }
        else {
            System.out.println("El resultado de su operación es: " + result);
        }
    }

}