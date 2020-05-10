public class Gameplay {

    /*
    Creating a New room object will also create the object inside that room.
        Ex:
            RoomEnemy- will also create an enemy object via the perameters.
                Parameters(int roomNumber, String roomDescription, String EnemyName, int enemyAttack, int enemyHealth, int enemyAgility )

            RoomEmpty- nothing in there
                Parameters(int roomNumber, String roomDescription
                
            RoomItem- Similar to EnemyRoom, It will also create an Item object at the same time
                Parameters(int roomNumber, String roomDescription, String NameofObject, int itemCategory, int points that Item adds)
               
                Notes on some of these parameters:
                    -roomNumber has to be between 1-3
                    -ItemCategories are:
                        Health(Armor)=0
                        Attack(weapons)=1
                        Agility(Boost)=2
                    -roomdescription is the string that will be displayed when the player enters that room

    */



    public static void mainGameplay() throws InterruptedException {
        Room fl3Rm1 = new RoomEnemy(1,"Enemy Room", "Max", 1, 4, 1);
        Room fl3Rm2 = new RoomEmpty(2,"Theres nothing in here.");
        Room fl3Rm3 = new RoomItem(3,"Theres an Item in this room", "Dagger", 1, 2);
        Floor thirdFloor = new Floor("Third Floor", fl3Rm1, fl3Rm2, fl3Rm3);
        thirdFloor.moveBetweenRooms();

        Room fl2Rm1 = new RoomEnemy(1,"Enemy Room", "Coked up Hello Kitty", 3, 4, 4);
        Room fl2Rm2 = new RoomEmpty(2,"Theres nothing in here.");
        Room fl2Rm3 = new RoomItem(3,"Theres an Item in this room", "AK-47", 1, 5);
        Floor secondFloor = new Floor("Second Floor", fl2Rm1, fl2Rm2, fl2Rm3);
        secondFloor.moveBetweenRooms();

    }  
}