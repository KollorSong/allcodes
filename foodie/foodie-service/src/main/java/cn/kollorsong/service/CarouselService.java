package cn.kollorsong.service;

import cn.kollorsong.pojo.Carousel;

public interface CarouselService {

    Carousel getCarouselById(String id);


    void oneStep();

    void twoStep();


}
