package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThermostatTest {

    @Test
    void test() {

        Thermostat t1 = new Thermostat();

        t1.newTemperature((float) 20.1);

        assertEquals("20.1 OFF O", t1.screenInfo());
        assertTrue(t1.getEventLog().endsWith("20.1 Off mode - Heating is off.\n"));

        t1.switchState(Manual.getInstance());
        assertEquals("20.1 ON M", t1.screenInfo());
        assertTrue(t1.getEventLog().contains("Manual mode is activated.\n"));
        assertTrue(t1.getEventLog().contains("20.1 Manual mode - Heating is on.\n"));

        t1.newTemperature((float) 21.5);
        assertTrue(t1.getEventLog().endsWith("21.5 Manual mode - Heating is on.\n"));
        t1.newTemperature((float) 21.1);
        assertTrue(t1.getEventLog().endsWith("21.1 Manual mode - Heating is on.\n"));

        t1.switchState(new Timer(19));
        assertEquals("21.1 ON T 14", t1.screenInfo());
        assertTrue(t1.getEventLog().contains("Timer mode is activated 19 minutes."));
        assertTrue(t1.getEventLog().contains("21.1 Timer mode (14 minutes left) - Heating is on."));

        t1.newTemperature((float) 21.9);
        assertTrue(t1.getEventLog().endsWith("21.9 Timer mode (9 minutes left) - Heating is on.\n"));
        t1.newTemperature((float) 22.8);
        assertTrue(t1.getEventLog().endsWith("22.8 Timer mode (4 minutes left) - Heating is on.\n"));

        t1.newTemperature((float) 22.5);
        assertTrue(t1.getEventLog().contains("Off mode is activated."));
        assertTrue(t1.getEventLog().contains("22.5 Off mode - Heating is off."));
        t1.newTemperature((float) 21.4);
        assertTrue(t1.getEventLog().contains("21.4 Off mode - Heating is off."));

        t1.switchState(new Timer(19));

        t1.switchState(new Program((float) 20.0));
        assertEquals("21.4 OFF P 20.0", t1.screenInfo());
        assertTrue(t1.getEventLog().endsWith("Off mode is activated.\n" +
                "21.4 Off mode - Heating is off.\n" +
                "Program mode is activated at 20.0 degrees.\n" +
                "21.4 Program mode (at 20.0 degrees) - Heating is off.\n"));

        t1.newTemperature((float) 19.2);
        assertTrue(t1.getEventLog().contains("19.2 Program mode (at 20.0 degrees) - Heating is on."));
        t1.newTemperature((float) 20.1);
        assertTrue(t1.getEventLog().contains("20.1 Program mode (at 20.0 degrees) - Heating is off."));

        t1.switchState(new Timer(19));
        assertTrue(t1.getEventLog().endsWith("Off mode is activated.\n" +
                      "20.1 Off mode - Heating is off.\n" +
                      "Timer mode is activated 19 minutes.\n" +
                      "20.1 Timer mode (14 minutes left) - Heating is on.\n"));

        t1.resetEventLog();
        assertEquals("", t1.getEventLog());

    }
}