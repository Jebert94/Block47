
public abstract class Room {
    private String roomDescription;
    private boolean alreadyBeenInRoom;

    public Room(String roomDescription){
        this.alreadyBeenInRoom = false;
        this.roomDescription = roomDescription;
    }

    public void enter() throws InterruptedException{

    }

    /******Getters and Setters************* */

    public String getRoomDescription(){
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription){
         this.roomDescription = roomDescription;
    }

    public boolean getAlreadyBeenInRoom(){
        return alreadyBeenInRoom;
    }

    public void setAlreadyBeenInRoom(boolean alreadyBeenInRoom){
        this.alreadyBeenInRoom = alreadyBeenInRoom;
    }
}