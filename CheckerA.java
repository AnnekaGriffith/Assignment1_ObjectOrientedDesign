/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsa_que;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author ozzma
 */
public class CheckerA implements Runnable {
    private LinkedBlockingQueue <Line>queueA;
    private LinkedBlockingQueue <Line> queueC;
    private MakeQue Que;
    
    public CheckerA(LinkedBlockingQueue <Line> queueA,LinkedBlockingQueue <Line> queueC, MakeQue Que) {
        this.queueA= queueA;
        this.queueC = queueC;
        this.Que = Que;
    }

    @Override
    public void run() {
        
        // As long as the producer is running,
        // we want to check for elements.
        while (Que.isRunning()) {
            try 
            {
                
                while(!queueA.isEmpty()){
                    System.out.println("OC\tElements right now A: " + queueA);
                    int wait =0;
                    if(queueA.remainingCapacity()> 10)
                    {
                        Random value = new Random();
                        wait = value.nextInt(15)+ 1;
                    }
                    else if(queueA.remainingCapacity()> 5)
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
                    System.out.print("person being removed from A: ");
                    queueA.peek().print();
                    Line value = queueA.peek();
                    System.out.println("RC\tRemoving element A: "  +  queueA.take() + " wait time:" + wait + " minutes");
                    queueC.put(value);
                }
                
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("OC Completed.");
        System.out.println("Final elements in the queue A: " + queueA);
        
    }
   
}
