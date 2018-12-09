package ru.sbt.mipt.oop.HomeParts.Alarm;

public interface AlarmState {

    void changeState(AlarmState state);

    void activate(String password);

    void deactivate(String password);

    void setToAlertAlarm();
}
