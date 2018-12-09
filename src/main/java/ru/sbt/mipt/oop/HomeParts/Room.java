package ru.sbt.mipt.oop.HomeParts;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.HomeParts.Door;
import ru.sbt.mipt.oop.HomeParts.Light;

import java.util.Collection;

public class Room implements Part {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Room(Collection<Light> lights, Door door, String name) {
        this.lights = lights;
        this.doors.add(door);
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    @Override
    public void executeAction(Action action) {
        for(Door door : doors){
            door.executeAction(action);
        }
        for(Light light : lights){
            light.executeAction(action);
        }
    }
}
