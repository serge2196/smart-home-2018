package ru.sbt.mipt.oop.RemoteControl.Comands;

import ru.sbt.mipt.oop.HomeParts.Door;
import ru.sbt.mipt.oop.HomeParts.Light;
import ru.sbt.mipt.oop.HomeParts.Room;
import ru.sbt.mipt.oop.HomeParts.SmartHome;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class TurnOnHallLight implements RemoteCommand {

    public SmartHome smartHome;

    public TurnOnHallLight(SmartHome smartHome){
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.executeAction(obj -> {
            if (obj instanceof Room) {
                Room room = (Room) obj;
                if (room.getName().equals("hall")) {
                    room.executeAction(obj1 -> {
                        if (obj1 instanceof Light) {
                            Light light = (Light) obj1;
                            light.setOn(true);
                        }
                    });
                }
            }
        });

    }
}
