package cn.song.abstract_factroy.ims;

import cn.song.abstract_factroy.inters.Shape;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("draw Square");
    }
}
