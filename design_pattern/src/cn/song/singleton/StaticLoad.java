package cn.song.singleton;

public class StaticLoad {

    private static class Holder{
        private static final StaticLoad staticLoad= new StaticLoad();
    }

    private StaticLoad() {
    }


    public static StaticLoad getInstance(){
        return Holder.staticLoad;
    }




}
