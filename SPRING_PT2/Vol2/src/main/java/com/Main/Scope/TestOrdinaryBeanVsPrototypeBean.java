package com.Main.Scope;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestOrdinaryBeanVsPrototypeBean implements CommandLineRunner {

    private final OrdinaryBean singletonBean;
    private final ObjectProvider<BeanMadePrototype> prototypeProvider;

    public TestOrdinaryBeanVsPrototypeBean(OrdinaryBean singletonBean, ObjectProvider<BeanMadePrototype> prototypeProvider) {
        this.singletonBean = singletonBean;
        this.prototypeProvider = prototypeProvider;
    }


    @Override
    public void run(String... args) {
        System.out.println("---- Singleton Test ----");
        singletonBean.action();
        singletonBean.action(); // Same instance

        System.out.println("---- Prototype Test ----");
        BeanMadePrototype pb1 = prototypeProvider.getObject();
        pb1.action();

        BeanMadePrototype pb2 = prototypeProvider.getObject();
        pb2.action(); // New instance
    }
}