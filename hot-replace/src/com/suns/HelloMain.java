package com.suns;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author 见贤不思齐
 * @time 2018/11/9.
 * @desc
 */
public class HelloMain {
    private URLClassLoader classLoader;
    private Object worker;
    private long lastTime;
    private String classDir = "E:\\GitHub\\java-basic-knowledge\\hot-replace\\out\\classes\\";

    public static void main(String[] args) throws Exception {
        HelloMain helloMain = new HelloMain();
        helloMain.execute();
    }

    private void execute() throws Exception {
        while (true) {
            //监测是否需要重新加载
            if (checkIsNeededLoad()) {
                System.out.println("监测到新版本，需要重新装载");
                reload();
                System.out.println("重新装载成功");
            }
            //1s
            invokeMethod();
            Thread.sleep(1000);
        }
    }

    /**
     * 通过反射的方式调用
     * 原因：不想Worker被 AppClassLoader 加载，如果被 AppClassLoader 装载的话，再通过自定义的类装载器会有问题 todo
     */
    private void invokeMethod() throws Exception {
        Method method = worker.getClass().getDeclaredMethod("sayHello", null);
        method.invoke(worker, null);
    }

    private void reload() throws Exception {
        classLoader = new MyClassLoader(new URL[]{
                new URL("file:" + classDir)
        });
        System.out.println(classLoader);
        worker = classLoader.loadClass("com.suns.Worker").newInstance();
    }

    /**
     * 通过监测类文件是否被修改，如果被修改则重新装载
     *
     * @return 是否需要重新装载
     */
    private boolean checkIsNeededLoad() {
        File file = new File(classDir + "com\\suns\\Worker.class");
        long newTime = file.lastModified();
        if (lastTime < newTime) {
            lastTime = newTime;
            return true;
        }
        return false;
    }
}
