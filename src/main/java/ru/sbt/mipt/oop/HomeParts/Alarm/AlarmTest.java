package ru.sbt.mipt.oop.HomeParts.Alarm;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.HomeParts.Alarm.Alarm;
import ru.sbt.mipt.oop.HomeParts.Alarm.AlarmOff;
import ru.sbt.mipt.oop.HomeParts.Alarm.AlarmOn;
import ru.sbt.mipt.oop.HomeParts.Alarm.AlertAlarm;

import static org.junit.jupiter.api.Assertions.*;

public class AlarmTest {
    String pass = "11111111";
    Alarm alarm;

    @Test
    public void turnOnTest() {
        alarm = new Alarm();
        alarm.activate(pass);
        assertTrue(alarm.getState() instanceof AlarmOn);
    }

    @Test
    public void turnOffTest() {
        alarm = new Alarm();
        alarm.activate(pass);
        alarm.deactivate(pass);
        assertTrue(alarm.getState() instanceof AlarmOff);
    }

    @Test
    public void turnOffBadPasswordTest1() {
        alarm = new Alarm();
        alarm.activate(pass);
        alarm.deactivate("22222222");
        assertTrue(alarm.getState() instanceof AlertAlarm);
    }

    @Test
    public void turnOffBadPasswordTest2() {
        alarm = new Alarm();
        alarm.activate(pass);
        alarm.setToAlertAlarm();
        alarm.deactivate("22222222");
        assertTrue(alarm.getState() instanceof AlertAlarm);
    }

    @Test
    public void turnAlertTest() {
        alarm = new Alarm();
        alarm.activate(pass);
        alarm.setToAlertAlarm();
        assertTrue(alarm.getState() instanceof AlertAlarm);
    }


}
