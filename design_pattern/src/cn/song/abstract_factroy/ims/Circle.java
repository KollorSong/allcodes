package cn.song.abstract_factroy.ims;

import cn.song.abstract_factroy.inters.Shape;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("draw Circle");
    }
}
