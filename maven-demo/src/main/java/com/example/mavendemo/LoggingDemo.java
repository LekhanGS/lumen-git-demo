package com.example.mavendemo;


import org.apache.log4j.Logger;

public class LoggingDemo {
    private Logger logger;

    public LoggingDemo(){
        this.logger= Logger.getLogger(this.getClass().getName());
    }

    public void doSomething(){
        logger.info("Hello From the method");
    }

}
