package com.soap;

import com.soap.client.NumberToDollarsClient;
import com.soap.config.NumberToDollarsConfig;
import com.soap.ws.NumbersConversion.NumberToDollarsResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NumberToDollarsConfig.class, loader = AnnotationConfigContextLoader.class)
public class NumberToDollarsClientLiveTest {

    @Autowired
    private NumberToDollarsClient numberToDollarsClient;

    @Test
    public void whenSendRequest_thenRecieveValidResponse() {
        BigDecimal bigDecimal = new BigDecimal(55);
        NumberToDollarsResponse testNumberToDollars = numberToDollarsClient.getNumberToDollars(bigDecimal);
        assertEquals("fifty five dollars", testNumberToDollars.getNumberToDollarsResult());
    }

    @Test
    public void whenSendBadRequest_thenRecieveBadResponse() {
        BigDecimal bigDecimal = new BigDecimal(55);
        NumberToDollarsResponse testNumberToDollars = numberToDollarsClient.getNumberToDollars(bigDecimal);
        assertNotEquals("fifty five four", testNumberToDollars.getNumberToDollarsResult());
    }

}
