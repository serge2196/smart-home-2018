package ru.sbt.mipt.oop.RemoteControl;

import ru.sbt.mipt.oop.RemoteControl.Comands.RemoteCommand;

import java.util.HashMap;
import java.util.Map;

public class SmartHomeRemoteController implements RemoteControl {

    public Map<String, RemoteCommand> buttonCodeToCommand = new HashMap<String, RemoteCommand>();

    @Override
    public void onButtonPressed(String buttonCode) {

        RemoteCommand command = buttonCodeToCommand.get(buttonCode);
        command.execute();

    }

    public void addCommand(String buttonCode, RemoteCommand command) {
        buttonCodeToCommand.put(buttonCode, command);
    }
}
