package ru.sbt.mipt.oop.RemoteControl.Comands;

import ru.sbt.mipt.oop.HomeParts.Light;
import ru.sbt.mipt.oop.HomeParts.SmartHome;

public class TurnOffAllLights implements RemoteCommand {

    public SmartHome smartHome;

    public TurnOffAllLights(SmartHome smartHome){
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        this.smartHome.executeAction(com -> {
            if (com instanceof Light){
                Light light = (Light) com;
                light.setOn(false);
            }
        });


    }
}
