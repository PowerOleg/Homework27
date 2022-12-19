package ru.netology.sender;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.mockito.BDDMockito.given;

public class MessageSenderTest {


    @Test
    public void testMessageSenderRusMockPositive() {
        final String expectedRus = "Добро пожаловать";
        final String expectedEng = "Welcome";
        GeoService geoService = Mockito.mock(GeoService.class);
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);

        given(geoService.byIp(Mockito.anyString())).willReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        given(localizationService.locale(Country.RUSSIA)).willReturn(expectedRus);
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.16.0.0");
        String result = messageSender.send(headers);
        Assertions.assertEquals(expectedRus, result);



//        try (PrintWriter printWriter = new PrintWriter(new File("text.txt"))) {
//            printWriter.write(result);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(result);
    }
}
