package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.HomeParts.Alarm.AlarmOn;
import ru.sbt.mipt.oop.HomeParts.Alarm.AlertAlarm;
import ru.sbt.mipt.oop.HomeParts.SmartHome;
import ru.sbt.mipt.oop.SensorEvent;

public class EventProcessorsDecorator implements EventProcessor {

        EventProcessor eventProcessor;

    public EventProcessorsDecorator(EventProcessor eventProcessor){
        this.eventProcessor = eventProcessor;
    }

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if(smartHome.getAlarm().getState() instanceof AlarmOn){
            smartHome.getAlarm().setToAlertAlarm();
        } else if(smartHome.getAlarm().getState() instanceof AlertAlarm){

        } else
            eventProcessor.processEvent(smartHome,event);

    }
}
