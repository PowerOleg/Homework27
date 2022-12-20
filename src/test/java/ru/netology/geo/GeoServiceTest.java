package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ru.netology.entity.Country;

public class GeoServiceTest {
    GeoService geoService;
    @BeforeEach
    public void init() {
        geoService = new GeoServiceImpl();
    }

    @ParameterizedTest
    @ValueSource(strings = {"96.44.183.149", "96.0.0.0", "96.44.0.0", "96.44.255.255"})
    public void testByIpUsaPositive(String argument) {
        String expectedCity = "New York";
        Country expectedCountry = Country.USA;

        Country resultCountry = geoService.byIp(argument).getCountry();
        String resultCity = geoService.byIp(argument).getCity();

        Assertions.assertEquals(expectedCountry, resultCountry);
        Assertions.assertEquals(expectedCity, resultCity);
    }

    @ParameterizedTest
    @ValueSource(strings = {"172.0.32.11", "172.16.0.0", "172.31.255.255"})
    public void testByIpRusPositive(String argument) {
        String expectedCity = "Moscow";
        Country expectedCountry = Country.RUSSIA;

        Country resultCountry = geoService.byIp(argument).getCountry();
        String resultCity = geoService.byIp(argument).getCity();

        Assertions.assertEquals(expectedCountry, resultCountry);
        Assertions.assertEquals(expectedCity, resultCity);
    }

    @Test
    public void testByIpLocalhostPositive() {
        String argument = "127.0.0.1";
        Country resultCountry = geoService.byIp(argument).getCountry();
        String resultCity = geoService.byIp(argument).getCity();

        Assertions.assertNull(resultCountry);
        Assertions.assertNull(resultCity);
    }
}