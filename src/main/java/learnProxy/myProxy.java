package learnProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class myProxy {
    private Person my = new maYun();

    public Person getProxy(){
        //匿名函数
        return (Person) Proxy.newProxyInstance(myProxy.class.getClassLoader(),
                my.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        if(method.getName().equals("eat")){
                            return method.invoke(my, args);
                        }

                        if(method.getName().equals("work")){
                            return method.invoke(my, args);
                        }
                        return null;
                    }
                });
    }
}
