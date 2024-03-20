package com.soap.client;

import com.soap.ws.NumbersConversion.NumberToWords;
import com.soap.ws.NumbersConversion.NumberToWordsResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.math.BigInteger;

public class NumberToWordsClient extends WebServiceGatewaySupport {

    public NumberToWordsResponse getNumberToWords(BigInteger value) {
        NumberToWords numberToWords = new NumberToWords();
        numberToWords.setUbiNum(value);

        return (NumberToWordsResponse) getWebServiceTemplate().marshalSendAndReceive(numberToWords);
    }

}
