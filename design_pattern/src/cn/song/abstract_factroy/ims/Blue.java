package cn.song.abstract_factroy.ims;

import cn.song.abstract_factroy.inters.Color;

public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("fill blue");
    }
}
