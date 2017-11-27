/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsa_que;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

public class MakeQue implements Runnable {
    private LinkedList <Line> N;
    private LinkedBlockingQueue queueA;
    private LinkedBlockingQueue queueB;
    private boolean running;
    public void setQue (LinkedList <Line> N)
    {
        this.N = N;
    }
    public LinkedList <Line> getQue()
    {
        return N;
    }

    public MakeQue(LinkedBlockingQueue queueA, LinkedBlockingQueue queueB) {
        this.queueA = queueA;
        this.queueB = queueB;
        running = true;
    }
    
    // We need to check if the producer thread is
    // Still running, and this method will return
    // the state (running/stopped).
    public boolean isRunning() {
        return running;
    }

    @Override
    public void run() {
        
        // We are adding elements using put() which waits
        // until it can actually insert elements if there is
        // not space in the queue.
        LinkedList <Line> Nline = getQue();

        while(!Nline.isEmpty())
        {   
            try 
            {
                if ( (Nline.peek().getTSALine())== 1)
                {   
                    Line Avalue = Nline.peek();
                    queueA.put(Avalue);
                    System.out.println("P\tAdding element A: " );
                    Avalue.print();
                    Thread.sleep(1000);
                    Nline.remove();
                }
                else
                {
                    Line Bvalue = Nline.peek();
                    queueB.put(Bvalue);
                    String B = Bvalue.toString();
                    System.out.println("P\tAdding element B: ");
                    Bvalue.print();
                    Thread.sleep(1000);
                    Nline.remove(); 
                }
                
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        
        System.out.println("P Completed.");
        running = false;
    }

}
