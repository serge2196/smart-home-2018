package ru.sbt.mipt.oop.HomeParts.Alarm;

public class AlarmOn implements AlarmState {

    Alarm alarm;
    String password;

    public AlarmOn(Alarm alarm, String password){
        this.alarm = alarm;
        this.password = password;
    }

    @Override
    public void changeState(AlarmState state) {
        alarm.changeState(state);
    }

    @Override
    public void activate(String password1) {
        System.out.println("Alarm already activated");
    }

    @Override
    public void deactivate(String password) {
        if(this.password.equals(password)){
            alarm.changeState(new AlarmOff(alarm));
            System.out.println("Alarm is deactivated");
        }
    }

    @Override
    public void setToAlertAlarm() {
        alarm.changeState(new AlertAlarm(alarm, password));
        System.out.println("Sending sms");
    }
}
