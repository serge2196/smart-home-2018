package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.EventManager;
import com.coolcompany.smarthome.events.SensorEventsManager;
import ru.sbt.mipt.oop.EventProcessors.EventProcessor;
import ru.sbt.mipt.oop.HomeParts.SmartHome;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;

import java.util.HashMap;
import java.util.Map;

public class EventManagerAdapter implements EventManager {

    private SmartHome smartHome;
    private SensorEventsManager sensorEventsManager = new SensorEventsManager();

    public EventManagerAdapter() {
        this.sensorEventsManager = new SensorEventsManager();
    }

    public EventManagerAdapter(SensorEventsManager sensorEventsManager) {
        this.sensorEventsManager = sensorEventsManager;
    }

    public EventManagerAdapter(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void runEventsCycle() {
        sensorEventsManager.start();
    }

    @Override
    public void addEventsProcessor(EventProcessor eventProcessor) {
        sensorEventsManager.registerEventHandler(ccEvent -> {
            eventProcessor.processEvent(smartHome, adaptEvent(ccEvent));
        });

    }


    private static Map<String, SensorEventType> eventTypeMap = new HashMap<>();
    static {
        eventTypeMap.put("LightIsOn", SensorEventType.LIGHT_ON);
        eventTypeMap.put("LightIsOff", SensorEventType.LIGHT_OFF);
        eventTypeMap.put("DoorIsOpen", SensorEventType.DOOR_OPEN);
        eventTypeMap.put("DoorIsClosed", SensorEventType.DOOR_CLOSED);
        eventTypeMap.put("DoorIsLocked", SensorEventType.ALARM_ACTIVATE);
        eventTypeMap.put("DoorIsUnlocked", SensorEventType.ALARM_DEACTIVATE);
    }

    private SensorEvent adaptEvent(CCSensorEvent ccEvent){
        return new SensorEvent(eventTypeMap.get(ccEvent.getEventType()),ccEvent.getObjectId());
    }
}
