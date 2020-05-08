public class RoomEmpty extends Room {

    public RoomEmpty(String roomDescription) throws InterruptedException {
        super(roomDescription);
    }
    public void enter() throws InterruptedException{
        TypedText.typedFast(roomDescription);
        alreadyBeenInRoom = true;
    }
}