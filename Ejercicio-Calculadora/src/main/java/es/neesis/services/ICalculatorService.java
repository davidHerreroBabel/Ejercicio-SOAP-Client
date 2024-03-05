package es.neesis.services;

public interface ICalculatorService {

    public Double calculateResult(double value1, double value2, String operation);

    public Boolean isOperationExit(String operation);

}
