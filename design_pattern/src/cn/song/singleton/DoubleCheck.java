package cn.song.singleton;

public class DoubleCheck {

    private static DoubleCheck doubleCheck = null;

    private DoubleCheck() {
    }


    public static DoubleCheck getInstance(){

        if (doubleCheck == null){
            synchronized (DoubleCheck.class){
                if (doubleCheck == null){
                    doubleCheck = new DoubleCheck();
                }
            }
        }

        return doubleCheck;

    }


}
