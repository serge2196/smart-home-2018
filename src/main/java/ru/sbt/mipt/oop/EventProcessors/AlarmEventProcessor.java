package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.HomeParts.SmartHome;
import ru.sbt.mipt.oop.SensorEvent;

import static ru.sbt.mipt.oop.SensorEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.SensorEventType.ALARM_DEACTIVATE;

public class AlarmEventProcessor implements EventProcessor {

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isAlarmEvent(event)) return;
        if (event.getType() == ALARM_ACTIVATE) {
            smartHome.getAlarm().activate("11111111");
        } else {
            smartHome.getAlarm().deactivate("11111111");
        }
    }
    private boolean isAlarmEvent(SensorEvent event) {
        return event.getType() == ALARM_ACTIVATE || event.getType() == ALARM_DEACTIVATE;
    }

}
