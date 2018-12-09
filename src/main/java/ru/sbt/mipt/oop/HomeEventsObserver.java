package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventProcessors.*;
import ru.sbt.mipt.oop.HomeParts.SmartHome;
import ru.sbt.mipt.oop.SensorEventProvider;

import java.util.ArrayList;
import java.util.Collection;

public class HomeEventsObserver {

    private static Collection<EventProcessor> eventProcessors = new ArrayList<>();
    private SensorEventProvider sensorEventProvider;

    public HomeEventsObserver(SensorEventProvider sensorEventProvider) {
        this.sensorEventProvider = sensorEventProvider;
    }
    public void runEventsCycle(SmartHome smartHome) {
        SensorEvent event = sensorEventProvider.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventProcessor process : eventProcessors) {
                process.processEvent(smartHome, event);
            }
            event = sensorEventProvider.getNextSensorEvent();
        }
        if (event == null)
            System.out.println("No more events");
    }

    public void addEventProcessor(EventProcessor processor) {
        eventProcessors.add(processor);
    }

    public void configureEventProcessors(){
        addEventProcessor(new EventProcessorsDecorator(new DoorEventProcessor()));
        addEventProcessor(new EventProcessorsDecorator(new LightEventProcessor()));
        addEventProcessor(new EventProcessorsDecorator(new HallDoorEventProcessor()));
        addEventProcessor(new AlarmEventProcessor());
    }
}