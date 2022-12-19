package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;



import java.util.HashMap;
import java.util.Map;


import static org.mockito.BDDMockito.given;

public class MessageSenderTest {
    private GeoService geoService;
    private LocalizationService localizationService;

    @BeforeEach
    public void initialization() {
        geoService = Mockito.mock(GeoService.class);
        localizationService = Mockito.mock(LocalizationService.class);
    }
    @Test
    public void testMessageSenderRusMockPositive() {
        final String expected = "Добро пожаловать";

        given(geoService.byIp(Mockito.anyString())).willReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        given(localizationService.locale(Country.RUSSIA)).willReturn(expected);
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.16.0.0");
        String result = messageSender.send(headers);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMessageSenderEngMockPositive() {
        final String expected = "Welcome";

        given(geoService.byIp(Mockito.anyString())).willReturn(new Location("New York", Country.USA, null,  0));
        given(localizationService.locale(Country.USA)).willReturn(expected);
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.0.0");
        String result = messageSender.send(headers);
        Assertions.assertEquals(expected, result);
    }

}
