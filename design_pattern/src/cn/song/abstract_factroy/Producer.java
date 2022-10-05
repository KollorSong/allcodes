package cn.song.abstract_factroy;

public class Producer {


    public static AbstractFactory getFactory(String factoryType){
        if (factoryType == null)
            return null;
        if (factoryType.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        }
        if (factoryType.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }



}
