package com.soap.client;

import com.soap.ws.NumbersConversion.NumberToDollars;
import com.soap.ws.NumbersConversion.NumberToDollarsResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.math.BigDecimal;

public class NumberToDollarsClient extends WebServiceGatewaySupport {

    public NumberToDollarsResponse getNumberToDollars(BigDecimal value) {
        NumberToDollars numberToDollars = new NumberToDollars();
        numberToDollars.setDNum(value);

        return (NumberToDollarsResponse) getWebServiceTemplate().marshalSendAndReceive(numberToDollars);
    }

}
