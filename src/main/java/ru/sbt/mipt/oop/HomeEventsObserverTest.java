package ru.sbt.mipt.oop;

import org.junit.Test;
import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.EventProcessors.EventProcessor;
import ru.sbt.mipt.oop.HomeParts.SmartHome;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomeEventsObserverTest {

    public class MySensorEventProvider implements SensorEventProvider{

        private int count = 0;
        private SensorEvent sensorEvent;

        public MySensorEventProvider(SensorEvent sensorEvent){
            this.sensorEvent = sensorEvent;

        }

        @Override
        public SensorEvent getNextSensorEvent() {
            if(count < 1){

                count++;
                return sensorEvent;

            } else
                return null;
        }
    }

    public class EventProcessorTest implements EventProcessor{

        int count = 0;
        private SensorEvent sensorEvent;

        int getCount(){
            return this.count;
        }

        @Override
        public void processEvent(SmartHome smartHome, SensorEvent event) {
            count++;
            this.sensorEvent = sensorEvent;

        }
    }

    @Test
    public void observerTest() throws IOException {
        SmartHome smartHome = new FileSmartHomeLoader().loadSmartHome();
        ;
        SensorEvent sensorEvent = new SensorEvent(SensorEventType.LIGHT_ON, "1");
        HomeEventsObserver homeEventsObserver = new HomeEventsObserver(new MySensorEventProvider(sensorEvent));

        EventProcessor eventProcessor1 = new EventProcessorTest();
        EventProcessor eventProcessor2 = new EventProcessorTest();


        homeEventsObserver.addEventProcessor(eventProcessor1);
        homeEventsObserver.addEventProcessor(eventProcessor1);
        homeEventsObserver.addEventProcessor(eventProcessor2);

        homeEventsObserver.runEventsCycle(smartHome);

        assertEquals(2,((EventProcessorTest) eventProcessor1).getCount());
        assertEquals(1,((EventProcessorTest) eventProcessor2).getCount());
    }



}
