package ru.sbt.mipt.oop.RemoteControl.Comands;

import ru.sbt.mipt.oop.HomeParts.SmartHome;

public class ActivateAlarm implements RemoteCommand {

    public SmartHome smartHome;

    public ActivateAlarm(SmartHome smartHome){
        this.smartHome = smartHome;
    }
    @Override
    public void execute() {
        smartHome.getAlarm().activate("11111111");
    }
}
