package ru.sbt.mipt.oop.RemoteControl.Tests;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.HomeParts.Alarm.AlertAlarm;
import ru.sbt.mipt.oop.HomeParts.Door;
import ru.sbt.mipt.oop.HomeParts.Light;
import ru.sbt.mipt.oop.HomeParts.Room;
import ru.sbt.mipt.oop.HomeParts.SmartHome;
import ru.sbt.mipt.oop.RemoteControl.Comands.ActivateAlertAlarm;
import ru.sbt.mipt.oop.RemoteControl.Comands.CloseHallDoor;
import ru.sbt.mipt.oop.RemoteControl.SmartHomeRemoteController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CloseHallDoorTest {

    private SmartHome smartHome = new SmartHome();
    private SmartHomeRemoteController smartHomeRemoteControl = new SmartHomeRemoteController();
    private Light light1 = new Light("1", true), light2 = new Light("2", true);
    private Door door1 = new Door(true, "1"), door2 = new Door(true, "2");

    @Test
    public void test() {
//
        List<Light> lights1 = new ArrayList<>();
        lights1.add(light1);
        List<Light> lights2 = new ArrayList<>();
        lights2.add(light2);
        List<Door> doors1 = new ArrayList<>();
        doors1.add(door1);
        List<Door> doors2 = new ArrayList<>();
        doors2.add(door2);
        smartHome.addRoom(new Room(lights1,  doors1, "room"));
        smartHome.addRoom(new Room( lights2,  doors2, "hall"));
        smartHomeRemoteControl.addCommand("A", new CloseHallDoor(smartHome));
        smartHomeRemoteControl.onButtonPressed("A");

        for (Room room : smartHome.getRooms()){
            if(room.getName().equals("room")) {
                System.out.println("YEA!!!");
                for (Light light : room.getLights()) {
                    System.out.println(light.getId() + " " + light.isOn());
                    System.out.println("YEA!!!");
                }
                //System.out.println("YEA!!!");
            }
        }


        for(Door door : doors2){
            assertTrue(!door.getOpen());
        }
    }
}
