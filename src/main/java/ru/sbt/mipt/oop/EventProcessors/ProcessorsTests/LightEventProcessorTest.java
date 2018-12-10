package ru.sbt.mipt.oop.EventProcessors.ProcessorsTests;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.EventProcessors.DoorEventProcessor;
import ru.sbt.mipt.oop.EventProcessors.LightEventProcessor;
import ru.sbt.mipt.oop.FileSmartHomeLoader;
import ru.sbt.mipt.oop.HomeParts.Light;
import ru.sbt.mipt.oop.HomeParts.Room;
import ru.sbt.mipt.oop.HomeParts.SmartHome;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.SmartHomeLoader;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;


public class LightEventProcessorTest   {

    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
    SmartHome smartHome = smartHomeLoader.loadSmartHome();

    String lightId = "3";

    SensorEvent sensorEvent1 = new SensorEvent(SensorEventType.LIGHT_ON, lightId);
    SensorEvent sensorEvent2 = new SensorEvent(SensorEventType.LIGHT_OFF, lightId);

    public LightEventProcessorTest() throws IOException {
    }

    public static Light getLight(SmartHome smartHome, String id) {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(id)) {
                    return light;
                }
            }
        }
        return null;
    }

    @Test
    public void testLightEventProcessor() throws IOException {
        if (getLight(smartHome, lightId).isOn()) {
            new LightEventProcessor().processEvent(smartHome, sensorEvent2); //выключаем включенную лампу и чекаем
            assertTrue(!getLight(smartHome, lightId).isOn());
        } else {
            new LightEventProcessor().processEvent(smartHome, sensorEvent1);   //включаем выключенную лампу и чекаем

            assertTrue(getLight(smartHome, lightId).isOn());
        }
    }
}
