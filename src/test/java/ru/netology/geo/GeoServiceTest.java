package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ru.netology.entity.Country;
import ru.netology.entity.Location;

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
//        Location expected = new Location("New York", Country.USA, null,  0);

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
//        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);

        Country resultCountry = geoService.byIp(argument).getCountry();
        String resultCity = geoService.byIp(argument).getCity();

        Assertions.assertEquals(expectedCountry, resultCountry);
        Assertions.assertEquals(expectedCity, resultCity);
    }
//
//    @ValueSource(strings = {"127.0.0.1"})

//        String expected3 = LOCALHOST;
//Location expected4 = new Location(null, null, null, 0);

//
//    Location expected7 = new Location("Moscow", Country.RUSSIA, null, 0);
}




//        Location expected6 = new Location("New York", Country.USA, " 10th Avenue", 32);