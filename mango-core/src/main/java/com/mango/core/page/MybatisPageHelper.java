package com.mango.core.page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class MybatisPageHelper {
    /**
     * 调用分页插件进行分页查询
     * @param pageRequest 分页请求数据
     * @param mapper Dao对象，就是mybatis中的mapper
     * @param queryMethodName mapper中的方法名，要分页的查询名
     * @param args 方法参数
     * @return
     */
    public static PageResult findPage(PageRequest pageRequest,Object mapper,String queryMethodName,Object... args) {
        int pageNum=pageRequest.getPageNum();
        int pageSize=pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);

        Class<? extends Object> clazz = mapper.getClass();
//        Object object = SpringContextUtil.getBean(className);
//        Method method = ReflectionUtils.findMethod(clazz, queryMethodName);
        Method method=getMethod(clazz,queryMethodName,args);
//        List  list=(List )ReflectionUtils.invokeMethod(method, object);
//        Method queryMethod = getMethod(clazz, method, args);
        try {
            Object result= method.invoke(mapper);
            return getPageResult(pageRequest,new PageInfo<>((List)result));
        }catch (Exception e){
            e.printStackTrace();
        }

 return null;

    }

    private static Method getMethod(Class<?> clazz, String queryMethodName, Object[] args) {
        Method queryMethod = null;
        Method[] methods = clazz.getMethods();
        for(Method method:methods) {
            if(method.getName().equals(queryMethodName)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                System.out.println("查询出来的："+parameterTypes.length+"，传输的："+args.length);
                if(parameterTypes.length == args.length) {
                    boolean isSameMethod = true;
                    for(int i=0; i<parameterTypes.length; i++) {
                        Object arg = args[i];
                        if(arg == null) {
                            arg = "";
                        }
                        if(!parameterTypes[i].equals(args[i].getClass())) {
                            isSameMethod = false;
                        }
                    }
                    if(isSameMethod) {
                        queryMethod = method;
                        System.out.println("方法名"+method.getName());
                        break ;
                    }
                }
            }
        }
        return queryMethod;
    }

    private static PageResult getPageResult(PageRequest pageRequest, PageInfo<Object> pageInfo) {
    PageResult pageResult=new PageResult();
    pageResult.setPageNum(pageInfo.getPageNum());
    pageResult.setPageSize(pageInfo.getPageSize());
    pageResult.setTotalPages(pageInfo.getPages());
    pageResult.setTotalSize(pageInfo.getTotal());
    pageResult.setContent(pageInfo.getList());
    return pageResult;
    }
}
