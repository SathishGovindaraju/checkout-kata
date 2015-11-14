package main;

public class ItemB extends Item {
    @Override
    public boolean equals(Object obj) {
        return obj instanceof ItemB;
    }

    @Override
    public int hashCode() {
        return 2;
    }
}
