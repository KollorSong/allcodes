package cn.song.singleton;

public class EH {

    private static EH eh = new EH();

    private EH() {
    }

    public static EH getInstance(){
        return eh;
    }

}
