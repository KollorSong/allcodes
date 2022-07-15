package cn.kollorsong.service.impl;

import cn.kollorsong.mapper.CarouselMapper;
import cn.kollorsong.pojo.Carousel;
import cn.kollorsong.service.CarouselService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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


}
