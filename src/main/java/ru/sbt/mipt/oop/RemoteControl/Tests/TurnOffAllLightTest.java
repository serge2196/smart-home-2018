package ru.sbt.mipt.oop.RemoteControl.Tests;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.HomeParts.Door;
import ru.sbt.mipt.oop.HomeParts.Light;
import ru.sbt.mipt.oop.HomeParts.Room;
import ru.sbt.mipt.oop.HomeParts.SmartHome;
import ru.sbt.mipt.oop.RemoteControl.Comands.CloseHallDoor;
import ru.sbt.mipt.oop.RemoteControl.Comands.TurnOffAllLights;
import ru.sbt.mipt.oop.RemoteControl.SmartHomeRemoteController;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TurnOffAllLightTest {
    private SmartHome smartHome = new SmartHome();
    private SmartHomeRemoteController smartHomeRemoteControl = new SmartHomeRemoteController();
    private Light light1 = new Light("1", true), light2 = new Light("2", true);
    private Door door1 = new Door(true, "1"), door2 = new Door(true, "2");

    @Test
    public void test() {
//
        List<Light> lights1 = new ArrayList<>();
        lights1.add(light1);
 //       List<Light> lights2 = new ArrayList<>();
        lights1.add(light2);
        List<Door> doors1 = new ArrayList<>();
        doors1.add(door1);
  //      List<Door> doors2 = new ArrayList<>();
   //     doors2.add(door2);
        smartHome.addRoom(new Room(lights1,  doors1, "room"));
 //       smartHome.addRoom(new Room( lights2,  doors2, "hall"));
        smartHomeRemoteControl.addCommand("A", new TurnOffAllLights(smartHome));
        smartHomeRemoteControl.onButtonPressed("A");

//        for (Room room : smartHome.getRooms()){
//            // if(room.getName().equals("hall")) {
//            //System.out.println("YEA!!!");
//            for (Door door : room.getDoors()) {
//                System.out.println(door.getId() + " " + door.getOpen());
//                System.out.println("YEA!!!");
//            }
//            //System.out.println("YEA!!!");
//            //   }
//        }


        for(Light light : lights1){
            assertTrue(!light.isOn());
        }
    }
}
