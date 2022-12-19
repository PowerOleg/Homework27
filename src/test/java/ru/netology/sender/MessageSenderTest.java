package ru.netology.sender;

import org.junit.Test;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class MessageSenderTest {

    @Test
    public void testMessageSenderLanguageMockPositive() {
        GeoService geoService = new GeoServiceImpl();
        LocalizationService localizationService = new LocalizationServiceImpl();

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

    }
}
