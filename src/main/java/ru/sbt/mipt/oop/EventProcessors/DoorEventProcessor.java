package ru.sbt.mipt.oop.EventProcessors;


import ru.sbt.mipt.oop.HomeParts.Door;
import ru.sbt.mipt.oop.HomeParts.SmartHome;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorCommand;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;


public class DoorEventProcessor implements EventProcessor {

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isDoorEvent(event)) return;
        smartHome.executeAction(object -> {
            if (object instanceof Door) {
                Door door = (Door) object;
                if (event.getType() == DOOR_OPEN) {
                    door.changeDoorState(event.getObjectId(), true);
                } else {
                    door.changeDoorState(event.getObjectId(), false);
                }
            }
        });
    }

    private boolean isDoorEvent(SensorEvent event) {
        return event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED;
    }

}