package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.HomeParts.Light;
import ru.sbt.mipt.oop.HomeParts.SmartHome;
import ru.sbt.mipt.oop.SensorEvent;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

public class HallDoorEventProcessor implements EventProcessor {

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if(event.getType() != DOOR_CLOSED) return;
        if (Integer.parseInt(event.getObjectId()) != 4) return;         //getOblectId is String: need change string -> int
        smartHome.executeAction(obj -> {
            if (obj instanceof Light) {
                Light light = (Light) obj;
                light.changeLightState(light.getId(),false);
            }
        });
    }
}
