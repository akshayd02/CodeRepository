package com.study.SpringAop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.aspect.LoggingAspect;
import com.study.model.Bike;
import com.study.model.Car;
import com.study.model.Vehicle;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
        
        LoggingAspect aspect = factory.getBean(LoggingAspect.class);
        aspect.log();
        Vehicle vehicle = factory.getBean(Bike.class);
        
        
        
        vehicle.init();
        vehicle.exec();
    }
}
