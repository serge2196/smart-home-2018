package ru.sbt.mipt.oop.RemoteControl.Tests;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.HomeParts.Door;
import ru.sbt.mipt.oop.HomeParts.Light;
import ru.sbt.mipt.oop.HomeParts.Room;
import ru.sbt.mipt.oop.HomeParts.SmartHome;
import ru.sbt.mipt.oop.RemoteControl.Comands.TurnOffAllLights;
import ru.sbt.mipt.oop.RemoteControl.Comands.TurnOnAllLights;
import ru.sbt.mipt.oop.RemoteControl.SmartHomeRemoteController;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TurnOnAllLightTest {

    private SmartHome smartHome = new SmartHome();
    private SmartHomeRemoteController smartHomeRemoteControl = new SmartHomeRemoteController();
    private Light light1 = new Light("1", false), light2 = new Light("2", false);
    private Door door1 = new Door(true, "1"), door2 = new Door(true, "2");

    @Test
    public void test() {
//
        List<Light> lights1 = new ArrayList<>();
        lights1.add(light1);
        lights1.add(light2);
        List<Door> doors1 = new ArrayList<>();
        doors1.add(door1);

        smartHome.addRoom(new Room(lights1,  doors1, "room"));
        smartHomeRemoteControl.addCommand("A", new TurnOnAllLights(smartHome));
        smartHomeRemoteControl.onButtonPressed("A");


        for(Light light : lights1){
            assertTrue(light.isOn());
        }
    }
}
