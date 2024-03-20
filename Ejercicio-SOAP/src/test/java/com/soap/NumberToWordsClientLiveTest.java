package com.soap;

import com.soap.client.NumberToWordsClient;
import com.soap.config.NumberToWordsConfig;
import com.soap.ws.NumbersConversion.NumberToWordsResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NumberToWordsConfig.class, loader = AnnotationConfigContextLoader.class)
public class NumberToWordsClientLiveTest {

    @Autowired
    private NumberToWordsClient numberToWordsClient;

    @Test
    public void whenSendRequest_thenRecieveValidResponse() {
        BigInteger bigInteger = new BigInteger("55");
        NumberToWordsResponse testNumberToWords = numberToWordsClient.getNumberToWords(bigInteger);
        assertEquals("fifty five ", testNumberToWords.getNumberToWordsResult());
    }

    @Test
    public void whenSendBadRequest_thenRecieveBadResponse() {
        BigInteger bigInteger = new BigInteger("55");
        NumberToWordsResponse testNumberToWords = numberToWordsClient.getNumberToWords(bigInteger);
        assertNotEquals("fifty four ", testNumberToWords.getNumberToWordsResult());
    }

}
