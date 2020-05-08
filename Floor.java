import java.util.ArrayList;

public class Floor {
    String floorLevel;
    ArrayList<Room> roomsOnFloor = new ArrayList<Room>(3);

    public Floor(String floorLevel, Room room1, Room room2, Room room3){
        this.floorLevel = floorLevel;
        roomsOnFloor.add(room1);
        roomsOnFloor.add(room2);
        roomsOnFloor.add(room3);
        
    }

    public void moveBetweenRooms() throws InterruptedException {
        TypedText.typedFast("You are on the "+ floorLevel + ".");
        TypedText.typedFast("You come across three rooms\n");
        TypedText.typedFast("Where do you want to go?\n\n");
        System.out.println("1: Enter room 1. " + roomsOnFloor.get(0).getRoomDescription());
        System.out.println("2: Enter room 2. " + roomsOnFloor.get(1).getRoomDescription());
        System.out.println("3: Enter room 3. " + roomsOnFloor.get(2).getRoomDescription());



        while(!roomsOnFloor.get(0).getAlreadyBeenInRoom() || !roomsOnFloor.get(1).getAlreadyBeenInRoom() || !roomsOnFloor.get(2).getAlreadyBeenInRoom()){
            int answer = Main.input.nextInt();
            switch(answer){
                case 1:
                    roomsOnFloor.get(0).enter();
                    break;
                case 2:
                    roomsOnFloor.get(1).enter();
                    break;
                case 3:
                    roomsOnFloor.get(2).enter();
                    break;
                default:
                    TypedText.typedFast("You need to pick another room");
                break;
					
            }
        }
        TypedText.typedFast("Looks like you've been through all the rooms. It's time to go to the next floor");


    }
}