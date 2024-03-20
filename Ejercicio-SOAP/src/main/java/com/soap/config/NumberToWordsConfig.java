package com.soap.config;

import com.soap.client.NumberToWordsClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class NumberToWordsConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.soap.ws.NumbersConversion");
        return marshaller;
    }

    @Bean
    public NumberToWordsClient numberToWordsClient(Jaxb2Marshaller marshaller) {
        NumberToWordsClient client = new NumberToWordsClient();
        client.setDefaultUri("https://www.dataaccess.com/webservicesserver/NumberConversion.wso");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
