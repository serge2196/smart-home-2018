package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.HomeParts.SmartHome;

public interface EventProcessor {
    void processEvent(SmartHome smartHome, SensorEvent event);
}
