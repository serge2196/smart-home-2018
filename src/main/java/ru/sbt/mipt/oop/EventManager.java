package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventProcessors.EventProcessor;

public interface EventManager {
    void runEventsCycle();
    void addEventsProcessor(EventProcessor eventProcessor);
}
