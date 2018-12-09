package ru.sbt.mipt.oop.HomeParts.Alarm;

public class AlertAlarm implements AlarmState {

    Alarm alarm;
    String password;

    public AlertAlarm(Alarm alarm, String password) {
        this.alarm = alarm;
        this.password = password;
    }

    @Override
    public void changeState(AlarmState state) {
        alarm.changeState(state);
    }

    @Override
    public void activate(String password) {
        System.out.println("Alert Alarm! What are you doing???");

    }

    @Override
    public void deactivate(String password) {
        if (this.password.equals(password)) {
            alarm.changeState(new AlarmOff(alarm));
            System.out.println("Alarm is deactivated");
        }
    }
    @Override
    public void setToAlertAlarm() {
            System.out.println("AlertAlarm already activated");
    }
}
