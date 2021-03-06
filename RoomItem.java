public class RoomItem extends Room {
    private Item item;

    RoomItem(int roomNumber, String roomDescription, String itemName, int itemCategory, int itemBuffOrNerf)  {
        super(roomNumber, roomDescription);
        Item item = new Item(itemName, itemCategory, itemBuffOrNerf);
        this.item = item;
    }

    @Override
    public void enter() throws InterruptedException {
        TypedText.typedNormal(getRoomDescription());
        System.out.println();
        TypedText.typedFast("Do you want to pick up the " + item.getName() + " ?" );
        System.out.println("1: Yes");
        System.out.println("2: No");
        keepOrTossItem();
        System.out.println();
    }

    public void keepOrTossItem() throws InterruptedException {
        int answer = Main.input.nextInt();
        switch(answer){
        case 1:
            Player player = Player.getInstance();
            player.addItemToInventory(this.item);

            TypedText.typedFast("The item was added to your inventory.");
            break;

        case 2:
            TypedText.typedFast("You decided that the " + item.getName()+ " is useless garbage and yeet it out a window");
            break;
        default:
            TypedText.typedFast("Try again. Choose either 1: Yes, or 2: No");
            enter();
        }
        setAlreadyBeenInRoom(true);

        

    }



    
}