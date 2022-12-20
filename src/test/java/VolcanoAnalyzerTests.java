import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class VolcanoAnalyzerTests {
    VolcanoAnalyzer va;

    @BeforeEach
    public void setUp() throws Exception {
        va = new VolcanoAnalyzer();
        va.loadVolcanoes(Optional.empty());
    }

    @Test
    public void volcanoExists() {
        //Setup
        Volcano classUnderTest = new Volcano();

        //Execute


        //Assert
        assertNotNull(classUnderTest);
        //Teardown
    }


    @Test
    public void loadVolcanoes() throws IOException, URISyntaxException {
        //Setup
        Integer expected = 804;

        //Execute
        Integer actual = va.numbVolcanoes();

        //Assert
        assertEquals(expected, actual, "should have 804 volcanoes");

        //Teardown
    }


    //1. Return the volcanoes that erupted in the 1980s.

    @Test
    public void eruptedInEighties() {
        //Setup
        Integer expected = 40;

        //Execute
        Integer actual = va.eruptedInEighties().size();

        //Assert
        assertEquals(expected, actual, "should have 40 volcanoes");

        //Teardown
    }

    // 2. Return an array of the names of volcanoes that had an eruption with a Volcanic Explosivity Index (VEI) of 6 or higher.

    @Test
    public void highVEI() {
        //Setup
        String[] expected = { "Macauley Island", "Kikai", "Masaya", "Pago", "Taal", "Pinatubo", "Long Island", "Black Peak", "St. Helens", "Veniaminof", "Aniakchak", "Santorini", "Taupo", "Pago", "Pinatubo", "Raoul Island", "Okmok", "Apoyeque", "Ambrym", "Bona-Churchill", "Taupo", "Ksudach", "Ilopango", "Rabaul", "Pago", "Bona-Churchill", "Dakataua", "Ceboruco", "Changbaishan", "Quilotoa", "Kuwae", "Bardarbunga", "Huaynaputina", "Long Island", "Tambora", "Krakatau", "Santa Maria", "Novarupta", "Pinatubo" };

        //Execute
        String[] actual = va.highVEI();

        //Assert
        assertEquals( expected.length, actual.length, "should have 39 volcanoes");
        assertArrayEquals(expected, actual, "should have the correct volcanoes");
        //Teardown
    }

    // 3. Return the eruption with the highest number of recorded deaths.

    @Test
    public void mostDeadly() {
        //Setup
        Volcano expected = new Volcano();

        expected.setYear(450);
        expected.setTsu("");
        expected.setEQ("");
        expected.setName("Ilopango");
        expected.setLocation("El Salvador");
        expected.setCountry("El Salvador");
        expected.setLatitude(13.672);
        expected.setLongitude(-89.053);
        expected.setElevation(450);
        expected.setType("Caldera");
        expected.setVEI(6);
        expected.setAgent("");
        expected.setDEATHS("30000");

        //Execute
        Volcano actual = va.mostDeadly();

        //Assert
        assertEquals( expected.getYear(), actual.getYear(), "should have correct year");
        assertEquals( expected.getTsu(), actual.getTsu(), "should have correct Tsu");
        assertEquals(expected.getEQ(), actual.getEQ(), "should have correct EQ" );
        assertEquals( expected.getName(), actual.getName(),"should have correct Name" );
        assertEquals( expected.getLocation(), actual.getLocation(), "should have correct Location");
        assertEquals( expected.getCountry(), actual.getCountry(), "should have correct Country");
        assertEquals( expected.getLatitude(), actual.getLatitude(), "should have correct Latitude");
        assertEquals( expected.getLongitude(), actual.getLongitude(), "should have correct Longitude");
        assertEquals( expected.getElevation(), actual.getElevation(),"should have correct Elevation" );
        assertEquals( expected.getType(), actual.getType(), "should have correct Type");
        assertEquals( expected.getVEI(), actual.getVEI(), "should have correct VEI");
        assertEquals( expected.getAgent(), actual.getAgent(), "should have correct Agent");
        assertEquals( expected.getDEATHS(), actual.getDEATHS(), "should have correct DEATHS");
        //Teardown
    }


    // 4. Return the percentage of eruptions that caused tsunamis.

    @Test
    public void causedTsunami() {
        //Setup
        double expected = 17;

        //Execute
        double actual = va.causedTsunami();

        //Assert
        assertEquals( expected, actual, .1, "should be about 17.0 percent");
        //Teardown
    }


    // 5. Return the most common type of volcano in the set.
    @Test
    public void mostCommonType() {
        //Setup
        String expected = "Stratovolcano";

        //Execute
        String actual = va.mostCommonType();

        //Assert
        assertEquals( expected, actual, "should be Stratovolcano");

        //Teardown
    }


    // 6. Return the number of eruptions when supplied a country as an argument.
    @Test
    public void eruptionsByCountry() {
        //Setup
        int expected1 = 47;
        int expected2 = 189;
        int expected3 = 0;

        //Execute
        int actual1 = va.eruptionsByCountry("United States");
        int actual2 = va.eruptionsByCountry("Indonesia");
        int actual3 = va.eruptionsByCountry("Zimbabwe");

        //Assert
        assertEquals(expected1, actual1, "should be 47 eruptions in United States");
        assertEquals( expected2, actual2, "should be 189 eruptions in Indonesia");
        assertEquals( expected3, actual3, "should be 0 eruptions in Zimbabwe");
        //Teardown
    }

    //7. Return the average elevation of all eruptions.
    @Test
    public void averageElevation() {
        //Setup
        double expected = 1993.71;

        //Execute
        double actual = va.averageElevation();

        //Assert
        assertEquals( expected, actual, .1, "should be about 1993.71");

        //Teardown
    }


    //8. Return an array of types of volcanoes.
    @Test
    public void volcanoTypes() {
        //Setup
        String[] expected = { "Caldera", "Stratovolcano", "Complex volcano", "Shield volcano", "Pyroclastic shield", "Volcanic field", "Lava dome", "Subglacial volcano", "Crater rows", "Tuff cone", "Fissure vent", "Pyroclastic cone", "Submarine volcano", "Lava cone", "Pumice cone", "Mud volcano", "Cinder cone", "Compound volcano", "Maar"};
        //Execute
        String[] actual = va.volcanoTypes();

        //Assert
        assertEquals(expected.length, actual.length, "should have 19 volcano types");
        assertArrayEquals(expected, actual, "should have the correct volcano types");

        //Teardown
    }

    
    // 9. Return the percentage of eruptions that occurred in the Northern Hemisphere.
    @Test
    public void percentNorth() {
        //Setup
        double expected = 64.55;

        //Execute
        double actual = va.percentNorth();

        //Assert
        assertEquals( expected, actual, .1, "should be about 64.55 percent");

        //Teardown
    }

    // 10. Return the names of eruptions that occurred after 1800, 
    // that did NOT cause a tsunami, happened in the Southern Hemisphere,
    //  and had a VEI of 5.

    @Test
    public void manyFilters() {
        //Setup
        String[] expected = { "Galunggung", "Hudson, Cerro" };
        //Execute
        String[] actual = va.manyFilters();

        //Assert
        assertEquals( expected.length, actual.length, "should have 3 volcanoes");
        assertArrayEquals(expected, actual, "should have the correct volcanoes");

        //Teardown
    }

    //11. Return the names of eruptions that occurred at or above an elevation passed in as an argument.

    @Test
    public void elevatedVolcanoes() {
        //Setup
        String[] expected = { "Tungurahua", "Cotopaxi", "Bona-Churchill", "Bona-Churchill", "Ruiz", "Tungurahua", "Cotopaxi", "Cotopaxi", "Cotopaxi", "Cotopaxi", "Sabancaya", "Ararat", "Ruiz", "Cotopaxi", "Tungurahua", "Tungurahua", "Popocatepetl", "Sangay", "Ruiz", "Sabancaya", "Huila", "Popocatepetl", "Tungurahua", "Tungurahua", "Tungurahua", "Huila", "Tungurahua", "Huila", "Tungurahua", "Tungurahua", "Tungurahua", "Ubinas" };

        //Execute
        String[] actual = va.elevatedVolcanoes(4990);

        //Assert
        assertEquals( expected.length, actual.length, "should have 32 volcanoes above 4990");
        assertArrayEquals(expected, actual, "should have the correct volcanoes");

        //Teardown
    }

    // 11. Return the agents of death for the ten most deadly eruptions.
    @Test
    public void topAgentsOfDeath() {
        //Setup
        String[] expected = { "P", "M", "W", "A", "I" };

        //Execute
        String[] actual = va.topAgentsOfDeath();

        //Assert
        assertEquals( expected.length, actual.length, "should have 5 Agents of Death");
        assertArrayEquals(expected, actual, "should have the correct Agents of Death");

        //Teardown
    }
}