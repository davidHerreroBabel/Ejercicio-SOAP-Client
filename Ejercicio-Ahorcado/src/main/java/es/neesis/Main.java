package es.neesis;

import es.neesis.applications.ConstructorApplication;
import es.neesis.configuration.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConstructorApplication application = context.getBean(ConstructorApplication.class);
        application.run();
    }
}