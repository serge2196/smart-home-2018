package ru.sbt.mipt.oop.RemoteControl.Tests;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.HomeParts.Alarm.AlertAlarm;
import ru.sbt.mipt.oop.HomeParts.Door;
import ru.sbt.mipt.oop.HomeParts.Room;
import ru.sbt.mipt.oop.HomeParts.SmartHome;
import ru.sbt.mipt.oop.RemoteControl.Comands.ActivateAlertAlarm;
import ru.sbt.mipt.oop.RemoteControl.SmartHomeRemoteController;

import java.util.Collection;
import static org.junit.jupiter.api.Assertions.*;

public class ActivateAlertAlarmTest {

    private SmartHome smartHome = new SmartHome();
    private SmartHomeRemoteController smartHomeRemoteControl = new SmartHomeRemoteController();

    @Test
    public void test() {

        smartHome.addRoom(new Room(null, (Collection<Door>) null, "room"));
        smartHomeRemoteControl.addCommand("A", new ActivateAlertAlarm(smartHome));
        smartHomeRemoteControl.onButtonPressed("A");

        assertTrue(smartHome.getAlarm().getState() instanceof AlertAlarm);
    }
}

