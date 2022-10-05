package cn.song.abstract_factroy;

import cn.song.abstract_factroy.ims.Circle;
import cn.song.abstract_factroy.ims.Rectangle;
import cn.song.abstract_factroy.ims.Square;
import cn.song.abstract_factroy.inters.Color;
import cn.song.abstract_factroy.inters.Shape;

public class ShapeFactory extends AbstractFactory{
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
