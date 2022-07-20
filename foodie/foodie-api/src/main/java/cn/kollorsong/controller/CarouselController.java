package cn.kollorsong.controller;

import cn.kollorsong.pojo.Carousel;
import cn.kollorsong.service.CarouselService;
import cn.kollorsong.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carousel")
@Slf4j
public class CarouselController {

    @Autowired
    private CarouselService carouselService;

    @GetMapping("/getCarousel/{id}")
    public String getCarousel(@PathVariable("id") String id){
        System.out.println(id);
        Carousel usersById = carouselService.getCarouselById(id);
        return JsonUtils.objectToJson(usersById);
    }

}
