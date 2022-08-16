package cn.kollorsong;

import com.baomidou.dynamic.datasource.AbstractRoutingDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
//@MapperScan(basePackages = {"cn.kollorsong.mapper"})
@ComponentScan(basePackages = {"cn.kollorsong","org.n3r.idworker"})
//不需要添加就可以开启事务管理(SpringBootApplication - EnableAutoConfig 启动自动配置默认有)
//@EnableTransactionManagement
@Slf4j
public class Application {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(Application.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");

        log.info("\n---------------------------------------------------------------------------------------------------\n\t" +
                "Application chat-service is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "\n\t" +
                "Swagger文档: \thttp://" + ip + ":" + port + path + "/doc.html\n" +
                "----------------------------------------------------------------------------------------------------");
    }



}
