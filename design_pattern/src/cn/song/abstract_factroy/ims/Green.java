package cn.song.abstract_factroy.ims;

import cn.song.abstract_factroy.inters.Color;

public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("fill Green");
    }
}
