package com.intercepter;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Log
@Interceptor
public class LogInterceptor {

//    @AroundInvoke
//    public Object intercept(InvocationContext ctx) throws Exception {
//        Object proceed = ctx.proceed();
//        return proceed;
//    }


    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception {

        long start = System.currentTimeMillis();
        Object proceed = ctx.proceed();
        long end = System.currentTimeMillis();

        String paramTypes = "";
        Class<?>[] parameters = ctx.getMethod().getParameterTypes();
        for (Class<?> param : parameters) {
            paramTypes += param.getSimpleName();
            paramTypes += ",";
        }

  
        return proceed;
    }
}
