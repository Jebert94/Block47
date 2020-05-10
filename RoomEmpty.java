public class RoomEmpty extends Room {

    public RoomEmpty(int roomNumber, String roomDescription) {
        super(roomNumber, roomDescription);
    }
    public void enter() throws InterruptedException{
        TypedText.typedFast(getRoomDescription());
        setAlreadyBeenInRoom(true);
    }
}