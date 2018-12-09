package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.SensorEvent;

public interface SensorEventProvider {
    SensorEvent getNextSensorEvent();
}
