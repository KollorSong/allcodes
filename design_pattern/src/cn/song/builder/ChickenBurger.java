package cn.song.builder;

public class ChickenBurger extends Burger{
    @Override
    public String name() {
        return null;
    }

    @Override
    public Packing packing() {
        return super.packing();
    }


    @Override
    public float price() {
        return super.price();
    }
}
