/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsa_que;

/**
 *
 * @author ozzma
 */

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class CheckerC implements Runnable {
    
    private LinkedBlockingQueue <Line> queueC;
    private MakeQue QueC;
    
    public CheckerC(LinkedBlockingQueue <Line> queueC, MakeQue QueC)
    {
        this.queueC= queueC;
        this.QueC = QueC;
    }
    
    //public void setValues ();
    
@Override
    public void run() {
        
        // As long as the producer is running,
        // we want to check for elements.
        while (QueC.isRunning()) {
            try 
            {
                while(!queueC.isEmpty())
                {
                    System.out.println("OC\tElements right now C: " + queueC);
                    int wait =0;
                    if(queueC.size()< 5)
                    {
                        Random value = new Random();
                        wait = value.nextInt(15)+ 1;
                    }
                    else if(queueC.size()< 10)
                    {
                        Random value = new Random();
                        wait = value.nextInt(10)+ 1;
                    }
                    else
                    {
                        Random value = new Random();
                        wait = value.nextInt(5)+ 1;
                    }

                    Thread.sleep(wait * 1000);
                    System.out.print("person being removed from C: ");
                    queueC.peek().print();
                    System.out.println("RC\tRemoving element C: "  + queueC.take() + " wait time:" + wait + " minutes");
                } 
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("OC Completed.");
        System.out.println("Final elements in the queue C: " + queueC);
        
    }

}
