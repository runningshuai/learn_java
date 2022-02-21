package learnProxy;

/*生成一个对象的代理对象
* 生成代理对象用newProxyInstance，需要三个参数：1类加载器，2接口-指明哪个对象的代理对象，
* 3 InvocationHandler指明这个代理对象要做什么事
* */
public interface Person {
    String eat(String name);

    String work(String name);
}
