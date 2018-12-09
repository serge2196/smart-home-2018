package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.HomeParts.Light;
import ru.sbt.mipt.oop.HomeParts.Room;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.HomeParts.SmartHome;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if(!isLightEvent(event)) return;
        smartHome.executeAction(object -> {
            if (object instanceof Light) {
                Light light = (Light)object;
                if (event.getType() == LIGHT_ON) {
                    light.changeLightState(event.getObjectId(), true);
                } else {
                    light.changeLightState(event.getObjectId(), false);
                }
            }
        });
    }

    private boolean isLightEvent(SensorEvent event) {
        return event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF;
    }


}




/*    public static void processLightEvent(SmartHome smartHome, SensorEvent event) {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(event.getObjectId())) {
                    if (event.getType() == LIGHT_ON) {
                        light.setOn(true);
                        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
                    } else {
                        light.setOn(false);
                        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
                    }
                }
            }
        }
    }
}*/
