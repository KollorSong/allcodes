package cn.kollorsong.controller;




public class PropagationTestController {

    /**
     * @Author: kollorsong
     * @Description: 事务传播 - propagation
     *                  REQUEST：使用当前事务，如果当前没有事务，则自己新建一个事务，子fang'fang
     *                  SUPPORTS：当前有事务就使用当前事务，当前没有事务就不使用事务
     *                  MANDATORY：当前有事务就使用当前事务，当前没事务就抛错
     *                  REQUEST_NEW：如果当前有事务，则挂起事务，并创建一个新的事务，
     *                              如果当前没有事务，就同REQUEST
     *                  NOT_SUPPORT：
     *                  NEVER：
     *                  NESTED：
     * @DateTime: 2022/7/16 - 7:09 PM
     * @param: null
     * @Return:
     */


}
