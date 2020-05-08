public class Gameplay {
    public static void mainGameplay() throws InterruptedException {
        Room fl3Rm1 = new RoomEnemy("Enemy Room", "Max", 1, 4, 1);
        Room fl3Rm2 = new RoomEmpty("Theres nothing in here.");
        Room fl3Rm3 = new RoomItem("Theres an Item in this room", "Dagger", 0, 2);
        Floor thirdFloor = new Floor("Third Floor", fl3Rm1, fl3Rm2, fl3Rm3);
        thirdFloor.moveBetweenRooms();

        Room fl2Rm1 = new RoomEnemy("Enemy Room", "Coked up Hello Kitty", 3, 4, 4);
        Room fl2Rm2 = new RoomEmpty("Theres nothing in here.");
        Room fl2Rm3 = new RoomItem("Theres an Item in this room", "AK-47", 0, 5);
        Floor secondFloor = new Floor("Second Floor", fl2Rm1, fl2Rm2, fl2Rm3);
        secondFloor.moveBetweenRooms();

    }
}