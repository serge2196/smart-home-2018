package ru.sbt.mipt.oop.RemoteControl.Comands;

import ru.sbt.mipt.oop.HomeParts.Door;
import ru.sbt.mipt.oop.HomeParts.Light;
import ru.sbt.mipt.oop.HomeParts.Room;
import ru.sbt.mipt.oop.HomeParts.SmartHome;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class CloseHallDoor implements RemoteCommand {

    private SmartHome smartHome;

    public CloseHallDoor(SmartHome smartHome){
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.executeAction(obj -> {
            if (obj instanceof Light) {
                Light light = (Light) obj;
                light.changeLightState(light.getId(),false);
            }
        });
        smartHome.executeAction(obj -> {
            if (obj instanceof Room) {
                Room room = (Room) obj;
                if (room.getName().equals("hall")) {
                    room.executeAction(obj1 -> {
                        if (obj1 instanceof Door) {
                            Door door = (Door) obj1;
                            door.changeDoorState(door.getId(), false);
                        }
                    });
                }
            }
        });
    }
}

