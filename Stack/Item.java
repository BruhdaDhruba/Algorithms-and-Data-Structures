public class Item {
    private ItemType type;
    private int value = 0;

    public Item(ItemType t, int v){
        type = t;
        value = v;
    }

    public ItemType getType(){
        return type;
    }

    public int getValue(){
        return value;
    }

    public static Item Value(int y){
        return new Item(ItemType.VALUE, y);
    }
    public static Item Mul(){
        return new Item(ItemType.MUL, 0);
    }
    public static Item Add(){
        return new Item(ItemType.ADD, 0);
    }
    public static Item Sub(){
        return new Item(ItemType.SUB, 0);
    }
    public static Item Div(){
        return new Item(ItemType.DIV, 0);
    }
}

