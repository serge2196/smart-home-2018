package ru.sbt.mipt.oop.HomeParts;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.HomeParts.Alarm.Alarm;
import ru.sbt.mipt.oop.HomeParts.Room;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Part{
    Alarm alarm;
    Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
        alarm = new Alarm();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
        this.alarm = new Alarm();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    @Override
    public void executeAction(Action action) {
        for(Room room : rooms){
            room.executeAction(action);
        }
    }

    public Alarm getAlarm() {
        return alarm;
    }

}
