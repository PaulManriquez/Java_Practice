package com.Main.EagerLazyByConstructor;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Qualifier("LAZYBEAN")
public class LazyBean {

    private static boolean instantiated = false;

    public LazyBean() {
        instantiated = true;
        System.out.println("LazyBean CONSTRUCTOR → Now I’m truly alive.");
    }

    public void doSomething() {
        System.out.println("Lazy bean doing something");
    }

    public static boolean isInstantiated() {
        return instantiated;
    }
}

