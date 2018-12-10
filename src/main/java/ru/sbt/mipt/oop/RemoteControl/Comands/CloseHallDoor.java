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

        for(Room room : smartHome.getRooms()){
            if(room.getName().equals("hall")){
                for (Light light : room.getLights()){
                    light.changeLightState(light.getId(),false);
                }
                for(Door door : room.getDoors()){
                    door.changeDoorState(door.getId(), false);
                }
            }
        }
//        smartHome.executeAction(obj -> {
//            if (obj instanceof Room) {
//                Room room = (Room) obj;
//                if (room.getName().equals("hall")) {
//                    room.executeAction(obj1 -> {
//                        if (obj1 instanceof Door) {
//                            Door door = (Door) obj1;
//                            System.out.println("Halldoor is closed ");
//                            door.setOpen(false);
//                        }
//                    });
//                    smartHome.executeAction(obj2 -> {
//                        if (obj2 instanceof Light) {
//                            Light light = (Light) obj2;
//                            light.changeLightState(light.getId(),false);
//                        }
//                    });
//                }
//            }
//        });
//        smartHome.executeAction(obj -> {
//            if (obj instanceof Room) {
//                Room room = (Room) obj;
//                if (room.getName().equals("hall")) {
//                    room.executeAction(obj1 -> {
//                        if (obj1 instanceof Door) {
//                            Door door = (Door) obj1;
//                            System.out.println("Halldoor is closed ");
//                            door.changeDoorState(door.getId(), false);
//                        }
//                    });
//                }
//            }
//        });
    }
}

