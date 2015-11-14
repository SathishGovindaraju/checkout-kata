package main;

public class ItemD extends Item {
    @Override
    public boolean equals(Object obj) {
        return obj instanceof ItemD;
    }

    @Override
    public int hashCode() {
        return 4;
    }
}
