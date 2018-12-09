package ru.sbt.mipt.oop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import ru.sbt.mipt.oop.EventProcessors.DoorEventProcessor;
import ru.sbt.mipt.oop.EventProcessors.LightEventProcessor;
import ru.sbt.mipt.oop.HomeParts.Alarm.AlarmOn;
import ru.sbt.mipt.oop.HomeParts.SmartHome;
import ru.sbt.mipt.oop.HomeEventsObserver;

import java.io.IOException;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class Application {

//    static SmartHome smartHome;
//    static RandomSensorEventProvider eventProvider;
//    static HomeEventsObserver homeEventsObserver;

//    public static void main(String[] args) throws IOException {
//        smartHome = new FileSmartHomeLoader().loadSmartHome();
//        smartHome.getAlarm().changeState(new AlarmOn(smartHome.getAlarm(), "11111111"));
//        eventProvider = new RandomSensorEventProvider();
//        homeEventsObserver = new HomeEventsObserver(eventProvider);
//        homeEventsObserver.configureEventProcessors();
//        homeEventsObserver.runEventsCycle(smartHome);
//    }

    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(HomeConfiguration.class);
        EventManager eventManager = context.getBean(EventManager.class);
        eventManager.runEventsCycle();

    }

}
