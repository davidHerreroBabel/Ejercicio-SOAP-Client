package es.neesis.applications;

import es.neesis.services.ICalculatorService;
import org.springframework.stereotype.Component;

@Component
public class NewApplication {

    private final ICalculatorService calculatorService;

    public NewApplication(ICalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public void sendMail(String to, String subject, String body) {
        mailService = new MailService();
        mailService.sendMail(to, subject, body);
    }

}
