package main;

public class Item {

    private String itemName;

    public Item(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public boolean equals(Object obj) {
        return ( (Item) obj).getItemName().equals(this.itemName);
    }

    @Override
    public int hashCode() {
        return itemName.hashCode();
    }
}
