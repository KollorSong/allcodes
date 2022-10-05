package cn.song.abstract_factroy;

import cn.song.abstract_factroy.ims.Blue;
import cn.song.abstract_factroy.ims.Green;
import cn.song.abstract_factroy.ims.Red;
import cn.song.abstract_factroy.inters.Color;
import cn.song.abstract_factroy.inters.Shape;

public class ColorFactory extends AbstractFactory{

    @Override
    public Color getColor(String color) {
        if (color == null)
            return null;
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }
}
