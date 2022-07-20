package cn.kollorsong;

import cn.kollorsong.service.CarouselService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

//@SpringBootTest(classes = Application.class)
//@RunWith(SpringRunner.class)
public class TestTransational {

    @Resource
    private CarouselService carouselService;

//    @Test
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void test(){

        carouselService.oneStep();

        carouselService.twoStep();

    }
}
