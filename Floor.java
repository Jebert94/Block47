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
        System.out.println("1: Enter room 1. ");
        System.out.println("2: Enter room 2. ");
        System.out.println("3: Enter room 3. ");



        while(!roomsOnFloor.get(0).getAlreadyBeenInRoom() || !roomsOnFloor.get(1).getAlreadyBeenInRoom() || !roomsOnFloor.get(2).getAlreadyBeenInRoom()){
            int answer = Main.input.nextInt();
            System.out.println();
            switch(answer){
                case 1:
                    if(!roomsOnFloor.get(0).getAlreadyBeenInRoom()){
                        roomsOnFloor.get(0).enter();
                        Main.clearScreen();
                        TypedText.typedFast("Youre back in the hallway.");
                        checkForUnexploredRooms();
                    }
                    else{
                        AlreadyBeenInRoom();
                    }
                    break;

                case 2:
                    if(!roomsOnFloor.get(1).getAlreadyBeenInRoom()){
                        roomsOnFloor.get(1).enter();
                        Main.clearScreen();
                        TypedText.typedFast("Youre back in the hallway.");
                        checkForUnexploredRooms();
                    }
                    else{
                        AlreadyBeenInRoom();
                    }
                    break;

                case 3:
                    if(!roomsOnFloor.get(2).getAlreadyBeenInRoom()){
                        roomsOnFloor.get(2).enter();
                        Main.clearScreen();
                        TypedText.typedFast("Youre back in the hallway.");
                        checkForUnexploredRooms();
                    }
                    else{
                        AlreadyBeenInRoom();
                    }
                    break;

                default:
                    TypedText.typedFast("You need to pick another room");
                break;
					
            }
        }
        TypedText.typedFast("Looks like you've been through all the rooms. It's time to go to the next floor");


    }

    public void checkForUnexploredRooms() throws InterruptedException {
        int count = 0;
        for(Room room : roomsOnFloor){
            if(!room.getAlreadyBeenInRoom()){
                count++;
            }
        }
        if(count == 1){
            TypedText.typedFast("You still have to explore room:");
            displayUnexploredRooms();
            System.out.println();
            TypedText.typedFast("You have no choice but to go in there...");
        }
        if(count > 1){
            TypedText.typedFast("You still have to explore rooms:");
            displayUnexploredRooms();
            System.out.println();
            TypedText.typedFast("What room would you like to go into next?");
        }
    }

    public void displayUnexploredRooms() throws InterruptedException {
        for(Room room : roomsOnFloor){
            if(!room.getAlreadyBeenInRoom()){
                System.out.println(String.valueOf(room.getRoomNumber())+":"+" Enter room "+String.valueOf(room.getRoomNumber())+".");
            }
        }
    }

    public void AlreadyBeenInRoom() throws InterruptedException {
        TypedText.typedFast("You've already been in this room. Theres no reason to go back.");
        checkForUnexploredRooms();

    }
}