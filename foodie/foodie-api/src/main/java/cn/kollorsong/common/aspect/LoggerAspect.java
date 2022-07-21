package cn.kollorsong.common.aspect;


import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 打印请求参数和返回结果
 */
@Aspect
@Component
@Slf4j
public class LoggerAspect {

    private static final String START_TIME = "request-start";
    private static final String REQUEST_ID = "request_id";


    // 定义切点Pointcut
    @Pointcut(" execution(* cn.kollorsong.controller.*..*(..)) " +
//            "|| execution(* com.shsnc.chatservice.admin.pc.admin.*..*(..)) " +
//            "|| execution(* com.shsnc.chatservice.admin.pc.admin.*..*(..)) " +
            "")
    public void executeService() {
    }

    @Before("executeService()")
    public void beforeLog(JoinPoint point) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        Map<String, String[]> parameterMap = request.getParameterMap();
        StringBuffer sb = new StringBuffer();
        String requestId = IdUtil.simpleUUID();
        sb.append("\n【request_id】：").append(requestId);
        sb.append("\n【请求 URL】：").append(request.getRequestURL());
        sb.append("\n【请求类名】：").append(point.getSignature().getDeclaringTypeName());
        sb.append("【请求方法名】：").append(point.getSignature().getName());
        sb.append("\n【body】：").append(JSONUtil.toJsonStr(point.getArgs()));
        sb.append("\n【请求参数】：").append(JSONUtil.toJsonStr(parameterMap));
        log.info(sb.toString());
        Long start = System.currentTimeMillis();
        request.setAttribute(START_TIME, start);
        request.setAttribute(REQUEST_ID, requestId);
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
        String params = "";
        //获取请求参数集合并进行遍历拼接
        Object[] args = pjp.getArgs();
        Stream<?> stream = ArrayUtils.isEmpty(args) ? Stream.empty() : Arrays.asList(args).stream();
        List<Object> logArgs = stream
                .filter(arg -> (!(arg instanceof HttpServletRequest) && !(arg instanceof HttpServletResponse)))
                .collect(Collectors.toList());
        //过滤后序列化无异常
        String string = JSON.toJSONString(logArgs);

        if ("POST".equals(method)) {
            params = string;
        } else if ("GET".equals(method)) {
            params = URLDecoder.decode(queryString, "UTF-8");
        }
        log.info("==============================start================================================");
        log.info("请求开始===uri:" + uri);
        log.info("请求开始===地址:" + url);
        log.info("请求开始===类型:" + method);
        log.info("请求开始===参数:" + params);
        log.info("===============================end=================================================");

        long start = System.currentTimeMillis();
        // result的值就是被拦截方法的返回值
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();

        log.info("===============================start===============================================");
        log.info("请求结束===返回值:" + JSON.toJSON(result));
        log.info("请求用时========:" + (end - start) + "毫秒");
        log.info("===============================end=================================================");

        return result;
    }

    /**
     * 后置通知
     */
    @AfterReturning("executeService()")
    public void afterReturning() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        String requestId = (String) request.getAttribute(REQUEST_ID);
        StringBuffer sb = new StringBuffer();
        sb.append("\n【request_id】：").append(requestId);
        Long start = (Long) request.getAttribute(START_TIME);
        Long end = System.currentTimeMillis();
        sb.append("\n【请求耗时】：").append((end - start)).append("毫秒");

        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        sb.append("\n【浏览器类型】：").append(userAgent.getBrowser().toString());
        sb.append("\n【操作系统】：").append(userAgent.getOperatingSystem());
        sb.append("\n【原始User-Agent】：").append(header);
        log.info(sb.toString());
//        log.info("【请求耗时】：{}毫秒", end - start);
//        log.info("【浏览器类型】：{}，【操作系统】：{}，【原始User-Agent】：{}", userAgent.getBrowser().toString(), userAgent.getOperatingSystem().toString(), header);
    }

    private String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 最终通知
     * @param joinPoint
     */
    @After("executeService()")
    public void after(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("after"+signature);
        System.out.println("after");
    }

    @AfterThrowing("executeService()")
    public void afterThrowing(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("AfterThrowing"+signature);
        System.out.println("AfterThrowing");
    }
}