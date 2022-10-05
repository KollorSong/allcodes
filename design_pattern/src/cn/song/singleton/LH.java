package cn.song.singleton;

public class LH {

    private static LH lh = null;

    private LH() {
    }


    public static synchronized LH getInstance(){
        if (lh == null){
            lh = new LH();
        }
        return lh;
    }




}
