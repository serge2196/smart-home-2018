package ru.sbt.mipt.oop.HomeParts;

import ru.sbt.mipt.oop.Action;

public class Door implements Part{
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean getOpen(){
        return this.isOpen;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }

    public void changeDoorState(String senId, boolean open){
        if(senId.equals(id)){
            isOpen = open;
            if (open){
                System.out.println("Door " + id + " was opened");
            } else{
                System.out.println("Door " + id + " was closed");
            }
        }
    }
}
