package ru.sbt.mipt.oop.RemoteControl.Comands;

import ru.sbt.mipt.oop.HomeParts.SmartHome;

public class ActivateAlertAlarm implements RemoteCommand {

    public SmartHome smartHome;

    public ActivateAlertAlarm(SmartHome smartHome){
        this.smartHome = smartHome;
    }
    @Override
    public void execute() {
        smartHome.getAlarm().activate("11111111");
        smartHome.getAlarm().setToAlertAlarm();
    }
}
