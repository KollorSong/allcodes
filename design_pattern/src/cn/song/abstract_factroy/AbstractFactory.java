package cn.song.abstract_factroy;

import cn.song.abstract_factroy.inters.Color;
import cn.song.abstract_factroy.inters.Shape;

public abstract class AbstractFactory {

    public abstract Color getColor(String color);
    public abstract Shape getShape(String shapeType);



}
