package cn.song.abstract_factroy;

import cn.song.abstract_factroy.inters.Shape;

public class Main {
    public static void main(String[] args) {
        AbstractFactory shape = Producer.getFactory("SHAPE");
        Shape rectangle = shape.getShape("RECTANGLE");
        rectangle.draw();
    }
}
