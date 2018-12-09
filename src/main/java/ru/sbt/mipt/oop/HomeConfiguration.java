package ru.sbt.mipt.oop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.sbt.mipt.oop.EventProcessors.*;
import ru.sbt.mipt.oop.HomeParts.SmartHome;
import ru.sbt.mipt.oop.FileSmartHomeLoader;
import ru.sbt.mipt.oop.SmartHomeLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class HomeConfiguration {

    private static SmartHome smartHome;
    private EventManager manager;

    public HomeConfiguration(){
        try {
            smartHome = new FileSmartHomeLoader().loadSmartHome();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public HomeConfiguration(SmartHomeLoader smartHomeLoader, EventManager manager){
        try {
            smartHome = new FileSmartHomeLoader().loadSmartHome();
            this.manager = manager;
            configureManager();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    @Bean
    EventManager eventManager(){
        manager = new EventManagerAdapter(smartHome);
        configureManager();
        return manager;
    }

    public void configureManager() {
        Collection<EventProcessor> eventProcessors = configureEventProcessors();
        for(EventProcessor eventProcessor : eventProcessors){
            manager.addEventsProcessor(eventProcessor);
        }
    }

    private static Collection<EventProcessor> configureEventProcessors(){
        Collection<EventProcessor> eventProcessors = new ArrayList<>();
        eventProcessors.add(new EventProcessorsDecorator(new DoorEventProcessor()));
        eventProcessors.add(new EventProcessorsDecorator(new LightEventProcessor()));
        eventProcessors.add(new EventProcessorsDecorator(new HallDoorEventProcessor()));
        eventProcessors.add(new AlarmEventProcessor());
        return eventProcessors;
    }
}