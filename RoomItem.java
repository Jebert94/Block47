public class RoomItem extends Room {
    private Item item;

    RoomItem(String roomDescription, String itemName, int itemCategory, int itemBuffOrNerf) throws InterruptedException {
        super(roomDescription);
        Item item = new Item(itemName, itemCategory, itemBuffOrNerf);
        this.item = item;
    }

    @Override
    public void enter() throws InterruptedException {
        TypedText.typedFast(roomDescription);
        TypedText.typedFast("Do you want to pick up the " + item.getName() + " ?" );
        TypedText.typedFast("Yes");
        TypedText.typedFast("No");
        String answer = Main.input.nextLine();
        if(answer.equalsIgnoreCase("yes")){
            Player player = Player.getInstance();
            player.addItemToInventory(this.item);
        }
        if(answer.equalsIgnoreCase("no")){
            TypedText.typedFast("You decided that the " + item.getName()+ " is useless garbage and yeet it out a window");
        }

    }
}