package cn.song.builder;

public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return null;
    }


    @Override
    public float price() {
        return 0;
    }
}
