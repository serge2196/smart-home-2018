package ru.sbt.mipt.oop.EventProcessors.ProcessorsTests;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.EventProcessors.DoorEventProcessor;
import ru.sbt.mipt.oop.EventProcessors.LightEventProcessor;
import ru.sbt.mipt.oop.FileSmartHomeLoader;
import ru.sbt.mipt.oop.HomeParts.Door;
import ru.sbt.mipt.oop.HomeParts.Room;
import ru.sbt.mipt.oop.HomeParts.SmartHome;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.SmartHomeLoader;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;


public class DoorEventProcessorTest {

    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
    SmartHome smartHome = smartHomeLoader.loadSmartHome(); 

    String doorId = "4";

    SensorEvent sensorEvent1 = new SensorEvent(SensorEventType.DOOR_OPEN, doorId);
    SensorEvent sensorEvent2 = new SensorEvent(SensorEventType.DOOR_CLOSED, doorId);

    public DoorEventProcessorTest() throws IOException {
    }

    public static Door getDoor(SmartHome smartHome, String id) {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(id)) {
                    return door;
                }
            }
        }
        return null;
    }

    @Test
    public void testDoorEventProcessor() throws IOException {
        if (getDoor(smartHome, doorId).getOpen()) {
            new DoorEventProcessor().processEvent(smartHome, sensorEvent2); //закрываем открытую дверь и чекаем
            assertTrue(!getDoor(smartHome, doorId).getOpen());
        } else {
            new DoorEventProcessor().processEvent(smartHome, sensorEvent1);   //oткрываем закрытую дверь и чекаем
            assertTrue(getDoor(smartHome, doorId).getOpen());
        }
    }
}
