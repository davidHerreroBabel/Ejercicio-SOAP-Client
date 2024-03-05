package es.neesis.services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public Double calculateResult(double value1, double value2, String operation) {
        switch (operation) {
            case "Sumar" -> {
                return value1 + value2;
            }
            case "Restar" -> {
                return value1 - value2;
            }
            case "Multiplicar" -> {
                return value1 * value2;
            }
            case "Dividir" -> {
                return value1 / value2;
            }
        }
        return Double.NaN;
    }
}
