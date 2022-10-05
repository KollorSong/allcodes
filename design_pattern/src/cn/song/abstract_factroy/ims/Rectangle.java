package cn.song.abstract_factroy.ims;

import cn.song.abstract_factroy.inters.Shape;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("draw Rectangle ...");
    }

}
