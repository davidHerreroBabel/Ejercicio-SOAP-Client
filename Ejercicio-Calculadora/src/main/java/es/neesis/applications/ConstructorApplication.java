package es.neesis.applications;

import es.neesis.services.ICalculatorService;
import org.springframework.stereotype.Component;

@Component
public class ConstructorApplication {

    private final ICalculatorService calculatorService;

    public ConstructorApplication(ICalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public Double calculateResult(Double value1, Double value2, String operation) {
        return calculatorService.calculateResult(value1, value2, operation);
    }

    public Boolean isOperationExit(String operation) {
        return calculatorService.isOperationExit(operation);
    }

}
