package ru.sbt.mipt.oop.EventProcessors.ProcessorsTests;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.EventProcessors.DoorEventProcessor;
import ru.sbt.mipt.oop.EventProcessors.HallDoorEventProcessor;
import ru.sbt.mipt.oop.FileSmartHomeLoader;
import ru.sbt.mipt.oop.HomeParts.Door;
import ru.sbt.mipt.oop.HomeParts.Light;
import ru.sbt.mipt.oop.HomeParts.Room;
import ru.sbt.mipt.oop.HomeParts.SmartHome;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.SmartHomeLoader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class HallDoorEventProcessorTest {

    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
    SmartHome smartHome = smartHomeLoader.loadSmartHome();

    String doorId = hallDoorId(smartHome).getId();

    SensorEvent sensorEvent1 = new SensorEvent(SensorEventType.DOOR_CLOSED, doorId);

    public HallDoorEventProcessorTest() throws IOException {
    }

    public static Door hallDoorId(SmartHome smartHome) {
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall")) {
                for (Door door : room.getDoors()){
                    return door;
                }
            }
        }
        return null;
    }

    public int lightOnCounter(SmartHome smartHome){
        int count = 0;
        for (Room homeRoom : smartHome.getRooms()) {
            for (Light light : homeRoom.getLights()) {
                if(light.isOn()){
                    count ++;
                }
            }
        }
        return count;
    }

    @Test
    public void testDoorEventProcessor() throws IOException {

        new HallDoorEventProcessor().processEvent(smartHome, sensorEvent1);
        assertEquals( 0, lightOnCounter( smartHome ) );

    }

}
