
public abstract class Room {
    protected String roomDescription;
    protected boolean alreadyBeenInRoom;

    public Room(String roomDescription) throws InterruptedException {
        this.alreadyBeenInRoom = false;
        this.roomDescription = roomDescription;
    }

    public void enter() throws InterruptedException{

    }

}