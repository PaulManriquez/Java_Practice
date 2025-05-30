package com.Main.LifeCycle;


import com.Main.Main;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//* BeanNameAware gives your bean access to the name
//  it was registered with inside the Spring container —
//  automatically called during bean initialization.
//* By default the name is inyected in the setBeanName(String name)
//  as the Name of the component you settle in the component ["MyNameIsLifeCycleBean"] or
//  by default it will be inyected the bean class name (LifeCycleBean)


//ORDER OF EXECUTION 1) 2) 3) the return type must be void
@Component("MyNameIsLifeCycleBean")
//@Scope("prototype") // For test porpuses you can test the behavior of the type of bean and its life cycle
public class LifeCycleBean implements BeanNameAware, InitializingBean, DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(LifeCycleBean.class);


    // During container startup
//    Object bean = new LifeCycleBean();
//    if (bean instanceof BeanNameAware) {
//        ((BeanNameAware) bean).setBeanName("lifeCycleBean");
//    }

    // (3)
    //Runs just before the bean is destroyed (i.e., when the application context is shutting down)
    //
    //Used for cleanup logic (e.g., closing connections, releasing resources)
    //
    //Do not will be executed for beans type prototype
    @Override
    public void destroy(){ // DisposableBean
        System.out.println("==== 4)  PRE DESTROY: ");
        logger.info("4) Pre destroy");
    }


    // (2)
    //Runs after the bean is constructed and dependencies are injected (@Autowired, etc.)
    //
    //Used for initialization logic (e.g., setting up resources, validation, etc.)
    @PostConstruct
    public void init(){
        System.out.println("==== 2) POST CONSTRUCT: ");
        logger.info("2) Post construct");
    }

    // (1)
    @Override
    public void setBeanName(String name) {
        System.out.println("==== 1) SET BEAN NAME: " + name);
        logger.info("1) Bean Name ===>:{}", name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("==== 3) AFTER PROPERTIES SET: ");
        logger.info("3) After properties set");
    }


}
