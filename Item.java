public class Item {
    private String name;
    private int category; // 0 = health item, 1 = Attack item, 2 = Agility item
    private int buffOrNerf;

    Item(String name, int category, int buffOrNerf){
        this.name = name;
        this.category = category;
        this.buffOrNerf = buffOrNerf;
    }

    public String getName(){
        return this.name;
    }

    public int getCategory(){
        return this.category;
    }

    public int getBuffOrNerf(){
        return this.buffOrNerf;
    }
}