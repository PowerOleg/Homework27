package ru.netology.geo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class GeoServiceTest {

    @ParameterizedTest
    @ValueSource(strings = {})
    public void testByIpPositive() {
        String expected = "New York";
        String expected2 = "Moscow";
        Country expectedCountry = Country.RUSSIA;
        Country expectedCountry2 = Country.USA;
//        String expected3 = LOCALHOST;
        Location expected4 = new Location(null, null, null, 0);
        Location expected5 = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Location expected6 = new Location("New York", Country.USA, " 10th Avenue", 32);
        Location expected7 = new Location("Moscow", Country.RUSSIA, null, 0);
        Location expected8 = new Location("New York", Country.USA, null,  0);





        
    }



}
