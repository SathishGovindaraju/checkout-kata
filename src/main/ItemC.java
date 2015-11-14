package main;

public class ItemC extends Item {
    @Override
    public boolean equals(Object obj) {
        return obj instanceof ItemC;
    }

    @Override
    public int hashCode() {
        return 3;
    }
}
