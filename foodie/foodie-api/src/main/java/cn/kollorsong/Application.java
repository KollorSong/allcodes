package cn.kollorsong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"cn.kollorsong.mapper"})
@ComponentScan(basePackages = {"cn.kollorsong","org.n3r.idworker"})
//不需要添加就可以开启事务管理(SpringBootApplication - EnableAutoConfig 启动自动配置默认有)
//@EnableTransactionManagement
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }


}
