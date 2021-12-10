package org.ds.flink.app;

public class Hello {   
    public static void main(String... args) {
        for(;;) {
            System.out.println("hello");
            try {
                Thread.sleep(1000);
            } catch(Throwable t) {}
        }
        

    }
    
}
