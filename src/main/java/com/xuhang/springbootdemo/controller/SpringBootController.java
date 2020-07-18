    package com.xuhang.springbootdemo.controller;


    import io.swagger.annotations.Api;
    import io.swagger.annotations.ApiOperation;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.core.MethodParameter;
    import org.springframework.http.HttpRequest;
    import org.springframework.http.MediaType;
    import org.springframework.http.converter.HttpMessageConverter;
    import org.springframework.http.server.ServerHttpRequest;
    import org.springframework.http.server.ServerHttpResponse;
    import org.springframework.lang.Nullable;
    import org.springframework.web.bind.annotation.ControllerAdvice;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.RestController;
    import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
    import redis.clients.jedis.Jedis;

    import javax.servlet.ServletRequest;
    import javax.servlet.http.HttpServletRequest;
    import java.lang.management.ManagementFactory;
    import java.net.InetAddress;
    import java.net.UnknownHostException;

    /**
     * @author：xuhang
     * @description：
     * @date：2018/10/31 14:28
     */

    /**
     * @RestController 表示的是@controller和@ResponseBody的合体。即将所有的返回打印在页面上
     */
    @Api(value="用户接口",tags={"UserAPi"})
    @RestController
    @ControllerAdvice
    public class SpringBootController implements ResponseBodyAdvice<Object> {
//        @Autowired
//        private Jedis jedis;



        //接口功能描述
//        @ApiOperation(value = "返回String",notes = "")
//        @GetMapping("hello")
//        public String HelloWord(){
//            return "Hello World Swagger2";
//        }

//        @ApiOperation(value = "测试redis", notes = "")
//        @GetMapping("testRedis")
//        public String testRedis(@RequestParam("name") String name){
//
//            jedis.set(name,name);
//
//            return jedis.get(name);
//
//
//        }
        @GetMapping("testHost")
        public String testHost(HttpServletRequest request) throws UnknownHostException {
            String remoteHost = request.getRemoteHost();
            String remoteAddr = request.getRemoteAddr();
            int remotePort = request.getRemotePort();
            String remoteUser = request.getRemoteUser();
            InetAddress localHost = InetAddress.getLocalHost();
            String ip=localHost.getHostAddress().toString(); //获取本机ip
            String hostName=localHost.getHostName().toString(); //获取本机计算机名称
            String split = ManagementFactory.getRuntimeMXBean().getName().split("@")[1];


            return "host:" + remoteHost + "    addr:" + remoteAddr + "  port:" + remotePort+"    hostName: "+hostName;
        }


        @Override
        public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
            return true;
        }

        @Nullable
        @Override
        public Object beforeBodyWrite(@Nullable Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest request, ServerHttpResponse serverHttpResponse) {

            System.out.println(request.getURI().getPath());
            return serverHttpResponse;
        }
    }
