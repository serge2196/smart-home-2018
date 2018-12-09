package ru.sbt.mipt.oop.HomeParts;

import ru.sbt.mipt.oop.Action;

public class Light implements Part{
    private boolean isOn;
    private final String id;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }
    public void changeLightState(String senId, boolean on){
        if(senId.equals(id)){
            isOn = on;
            if (on){
                System.out.println("Light " + id + " was turned on");
            } else{
                System.out.println("Light " + id + " was turned off");
            }
        }
    }
}
