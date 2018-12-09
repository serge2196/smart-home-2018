package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.HomeParts.SmartHome;

import java.io.IOException;

public interface SmartHomeLoader {
    SmartHome loadSmartHome() throws IOException;
}
