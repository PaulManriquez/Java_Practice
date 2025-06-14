package com.Main.EagerLazyByConstructor;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component//EAGER BY DEFAULT
public class EagerBean {

    private LazyBean lazyBean;

    //================ LAZYBEAN is instantiated
    //Because is called by a EAGER bean, it is created to
    @Autowired
    public EagerBean(
            @Qualifier("LAZYBEAN") LazyBean lazyBean) {
        this.lazyBean = lazyBean;
    }
    //=================================================

    @PostConstruct
    public void postConstruct(){
        System.out.println("Im an EAGER default bean,\n i was instanced by default in the application context");
    }

    @PreDestroy
    public void onShutdown() {
        System.out.println("===========================================");
        System.out.println("Triggering lazy bean before shutdown...");
        // This line triggers lazy instantiation
        if(!lazyBean.isInstantiated()){
            System.out.println("LazyBean has not be instantiated in the spring copntext yet");
        }else{
            System.out.println("LAZY BEAN INSTANTIATED");
        }

        //The trigger of a method in lazy bean , instantiate in the spring context
        lazyBean.doSomething();
        //======================

        if(!lazyBean.isInstantiated()){
            System.out.println("LazyBean has not be instantiated in the spring copntext yet");
        }else{
            System.out.println("LAZY BEAN INSTANTIATED");
        }

    }

}
