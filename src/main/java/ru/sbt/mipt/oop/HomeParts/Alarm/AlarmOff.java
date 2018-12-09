package ru.sbt.mipt.oop.HomeParts.Alarm;

public class AlarmOff implements AlarmState {

    Alarm alarm;

    public AlarmOff(Alarm alarm){
        this.alarm = alarm;
 }

    @Override
    public void changeState(AlarmState state) {
        alarm.changeState(state);
    }

    @Override
    public void activate(String password) {
            alarm.changeState(new AlarmOn(alarm, password));
            System.out.println("Alarm is activated");
    }

    @Override
    public void deactivate(String password) {
        System.out.println("Alarm already deactivated");
    }

    @Override
    public void setToAlertAlarm() {
        //alarm.changeState(new AlertAlarm(alarm, password));
    }
}
