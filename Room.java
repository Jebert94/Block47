
public abstract class Room {
    private int roomNumber;
    private String roomDescription;
    private boolean alreadyBeenInRoom;
 

    public Room(int roomNumber, String roomDescription){
        this.roomNumber = roomNumber;
        this.roomDescription = roomDescription;
        this.alreadyBeenInRoom = false;


    }

    public void enter() throws InterruptedException{

    }

    /******Getters and Setters************* */

    public int getRoomNumber(){
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber){
         this.roomNumber = roomNumber;
    }

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