package cn.kollorsong.common.aspect;


import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.Arrays;

/**
 * 打印请求参数和返回结果
 */
@Aspect
@Configuration
@Slf4j
public class LoggerAspect {

    //    private Logger logger = LoggerFactory.getLogger(this.getClass());
    // 定义切点Pointcut
    @Pointcut(" execution(* cn.kollorsong.controller.*..*(..)) " +
//            "|| execution(* com.shsnc.chatservice.admin.pc.admin.*..*(..)) " +
//            "|| execution(* com.shsnc.chatservice.admin.pc.admin.*..*(..)) " +
            "")
    public void executeService() {
    }

    @Around("executeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        String targetMethodParams = Arrays.toString(pjp.getArgs());
        String params = "";
        //获取请求参数集合并进行遍历拼接
        if (StrUtil.isNotBlank(targetMethodParams)) {
            if ("POST".equals(method)) {
                params = JSON.toJSONString(targetMethodParams);
            } else if ("GET".equals(method)) {
                params = URLDecoder.decode(queryString, "UTF-8");
            }
        }
        log.info("==============================start================================================");
        log.info("请求开始===uri:" + uri);
        log.info("请求开始===地址:" + url);
        log.info("请求开始===类型:" + method);
        log.info("请求开始===参数:" + params);
        log.info("===============================end=================================================");

        // result的值就是被拦截方法的返回值
        Object result = pjp.proceed();
        log.info("===============================start===============================================");
        log.info("请求结束===返回值:" + JSON.toJSON(result));
        log.info("===============================end=================================================");

        return result;
    }
}