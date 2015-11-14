package main;

public class ItemA extends Item {
    @Override
    public boolean equals(Object obj) {
        return obj instanceof ItemA;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
