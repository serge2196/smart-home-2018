package ru.sbt.mipt.oop.HomeParts.Alarm;

import ru.sbt.mipt.oop.SensorEvent;

public class Alarm {

    private AlarmState state;

    public Alarm() {
       // this.password = password;
        this.state = new AlarmOff(this);
    }

//    public void changePassword(String password){
//        this.password = password;
//    }

    public void changeState(AlarmState state){
        this.state = state;
    }

//    public String getPassword() {
//        return password;
//    }

//    boolean checkPassword (String password1) {
//        if(password1.equals(password)) return true;
//        return false;
//    }
    public void activate(String password) {
        state.activate(password);
    }

    public void deactivate(String password) {
        state.deactivate(password);
    }

    public void setToAlertAlarm() {
        state.setToAlertAlarm();
    }

    public AlarmState getState() {
        return state;
    }

}