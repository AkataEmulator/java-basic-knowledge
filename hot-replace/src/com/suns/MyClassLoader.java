package com.suns;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author 见贤不思齐
 * @time 2018/11/9.
 * @desc
 */
public class MyClassLoader extends URLClassLoader {
    /**
     * Constructs a new URLClassLoader for the specified URLs using the
     * default delegation parent {@code ClassLoader}. The URLs will
     * be searched in the order specified for classes and resources after
     * first searching in the parent class loader. Any URL that ends with
     * a '/' is assumed to refer to a directory. Otherwise, the URL is
     * assumed to refer to a JAR file which will be downloaded and opened
     * as needed.
     *
     * <p>If there is a security manager, this method first
     * calls the security manager's {@code checkCreateClassLoader} method
     * to ensure creation of a class loader is allowed.
     *
     * @param urls the URLs from which to load classes and resources
     * @throws SecurityException    if a security manager exists and its
     *                              {@code checkCreateClassLoader} method doesn't allow
     *                              creation of a class loader.
     * @throws NullPointerException if {@code urls} is {@code null}.
     * @see SecurityManager#checkCreateClassLoader
     */
    public MyClassLoader(URL[] urls) {
        super(urls);
    }

    /**
     * 打破双亲委派模型加载，保证自己的类被自己的 ClassLoader 加载
     */
    @Override
    protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class c = findLoadedClass(name);
        if (c == null) {
            try {
                c = findClass(name);
            } catch (ClassNotFoundException e) {
            }
        }
        if (c == null) {
            c = super.loadClass(name, resolve);
        }
        return c;
    }
}
