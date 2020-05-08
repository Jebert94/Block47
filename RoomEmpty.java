public class RoomEmpty extends Room {

    public RoomEmpty(String roomDescription) {
        super(roomDescription);
    }
    public void enter() throws InterruptedException{
        TypedText.typedFast(getRoomDescription());
        setAlreadyBeenInRoom(true);
    }
}