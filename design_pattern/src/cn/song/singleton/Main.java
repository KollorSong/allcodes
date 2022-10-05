package cn.song.singleton;

public class Main {


    public static void main(String[] args) {

        System.out.println("=============EH====================");

        EH instance1 = EH.getInstance();
        EH instance2 = EH.getInstance();
        System.out.println(instance1 == instance2);


        System.out.println("===============LH===================");

        LH instance3 = LH.getInstance();
        LH instance4 = LH.getInstance();
        System.out.println(instance3 == instance4);

        System.out.println("=================DoubleCheck=================");

        DoubleCheck instance5 = DoubleCheck.getInstance();
        DoubleCheck instance6 = DoubleCheck.getInstance();
        System.out.println(instance5 == instance6);

        System.out.println("=================StaticLoad==================");
        StaticLoad instance7 = StaticLoad.getInstance();
        StaticLoad instance8 = StaticLoad.getInstance();
        System.out.println(instance7 == instance8);


        System.out.println("================Enum==========================");
        SingleEnum singleEnum1 = SingleEnum.SINGLE_ENUM;
        SingleEnum singleEnum2 = SingleEnum.SINGLE_ENUM;
        System.out.println(singleEnum1 == singleEnum2);


    }



}
