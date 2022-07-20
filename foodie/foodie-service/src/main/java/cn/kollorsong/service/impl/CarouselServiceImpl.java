package cn.kollorsong.service.impl;

import cn.kollorsong.mapper.CarouselMapper;
import cn.kollorsong.pojo.Carousel;
import cn.kollorsong.service.CarouselService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
@Slf4j
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public Carousel getCarouselById(String id) {
        Example userexample = new Example(Carousel.class);
        Example.Criteria criteria = userexample.createCriteria();
        criteria.andEqualTo("id",id);
        Carousel carousel = carouselMapper.selectOneByExample(userexample);
        return carousel;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void oneStep() {
        Carousel carousel = new Carousel();
        carousel.setCatId("1");
        carousel.setImageUrl("wwww.baidu.com");
        carousel.setId("1");
        carousel.setType(1);
        carousel.setSort(1);
        carousel.setIsShow(0);
        carousel.setCreateTime(new Date());
        carousel.setUpdateTime(new Date());
        carouselMapper.insert(carousel);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void twoStep() {
        Carousel carousel2 = new Carousel();
        carousel2.setCatId("2");
        carousel2.setImageUrl("wwww.baidu.com");
        carousel2.setType(2);
        carousel2.setId("2");
        carousel2.setSort(1);
        carousel2.setIsShow(0);
        carousel2.setCreateTime(new Date());
        carousel2.setUpdateTime(new Date());
        carouselMapper.insert(carousel2);
        int k = 1/0;

        Carousel carousel3 = new Carousel();
        carousel3.setCatId("1");
        carousel3.setId("1");
        carousel3.setType(3);
        carousel3.setImageUrl("www.baidu.com");
        carousel3.setSort(1);
        carousel3.setIsShow(0);
        carousel3.setCreateTime(new Date());
        carousel3.setUpdateTime(new Date());
        carouselMapper.insert(carousel3);
        carouselMapper.insert(carousel3);


    }


}
