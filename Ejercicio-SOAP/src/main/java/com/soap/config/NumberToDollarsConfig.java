package com.soap.config;

import com.soap.client.NumberToDollarsClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class NumberToDollarsConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.soap.ws.NumbersConversion");
        return marshaller;
    }

    @Bean
    public NumberToDollarsClient numberToDollarsClient(Jaxb2Marshaller marshaller) {
        NumberToDollarsClient client = new NumberToDollarsClient();
        client.setDefaultUri("https://www.dataaccess.com/webservicesserver/NumberConversion.wso");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
