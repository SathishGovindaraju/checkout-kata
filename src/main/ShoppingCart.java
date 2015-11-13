package main;

public class ShoppingCart {
    private String item;

    public int checkout() {
        if(item == null){
            return 0;
        } else if(item.equals("B")){
            return 30;
        } else if(item.equals("C")){
            return 20;
        } else if(item.equals("D")){
            return 15;
        } else{
            return 50;
        }
    }

    public void addItem(String item) {
        this.item = item;
    }
}
