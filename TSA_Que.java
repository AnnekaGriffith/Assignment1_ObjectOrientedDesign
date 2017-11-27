/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsa_que;
import java.io.File;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
/**
 *
 * @author ozzma
 */
public class TSA_Que {
    private int lineMaxA;
    private int lineMaxB;
    private int TSAline;
    private String [] N;
    private Scanner maxLineQ;
    private Scanner people;

    /***************************************************************************
    OpenFile: opens test file and throws and error if one isn't found
    ***************************************************************************/
    public void openFile()
    {
        try
        {
            maxLineQ = new Scanner (new File ("C:\\Users\\ozzma\\Documents\\OOB&P"
                    + "\\Lectures\\TSA_Que\\test\\TSA.txt"));
        }
        catch(Exception e)
        {
            System.out.println("no file found");
        }
    }
    /***************************************************************************
    readFile: Reads in the integer values and assigns then to lineMaxA, or 
    lineMaxB.  
    ***************************************************************************/
    public void readFile()
    {
        try 
        {
            String numA = maxLineQ.next();
            String numB = maxLineQ.next();
            String numN = maxLineQ.next();
            int maxQueA = validEntry(numA);
            int maxQueB = validEntry(numB);
            int Nline = validEntry(numN);
            while (maxQueA < 0 || maxQueB < 0) 
            {
                String numA2 = maxLineQ.next();
                String numB2 = maxLineQ.next();
                String numN2 = maxLineQ.next();
                
                maxQueA = validEntry(numA2);
                maxQueB = validEntry(numB2);
                Nline = validEntry(numN2);
            } 
            people = new Scanner (new File ("C:\\Users\\ozzma\\Documents\\OOB&P"
                    + "\\Lectures\\TSA_Que\\test\\name.txt"));
            String [] N = new String [Nline];
            for(int i= 0; i<Nline; i++)
            {
                String makeN = people.nextLine();
                N[i] = makeN;
            }
            people.close();
            setPeople(N);
            setA(maxQueA);
            setB(maxQueB);
            setTSAline(Nline);
        }
        catch(Exception e)
        {
           System.out.println("not an int try again");
        }
    }
    /***************************************************************************
    closeFile: Closes the file that was opened
    ***************************************************************************/
    public void closeFile()
    {
        maxLineQ.close();  
    }
    /***************************************************************************
    setTSALine: Sets value for TSAline
     * @param testUserInput
     * @return num
    ***************************************************************************/
    public int validEntry(String testUserInput)
    {
        int num = 0;
        String tester = testUserInput;
        if (tester.length()<1)
        {
            System.out.println("No integer value: Please provide an integer value");
            num = -1;
        }
        else
        {
            for (int i = 0; i<tester.length();i++)
            {
                char c = tester.charAt(i);
                if (Character.isDigit(c))
                { 
                    Integer userNum = Integer.valueOf(tester);
                    num = userNum;
                }
                else
                {
                    
                    System.out.println("invalid entry: Please provide an integer value");
                    num = -1;
                }
            }
        }
        return num;
    }
    public void setA(int lineMaxA)
    {
        this.lineMaxA = lineMaxA;
    }
    public void setB(int lineMaxB)
    {
        this.lineMaxB = lineMaxB;
    }
    public int getA()
    {
        return lineMaxA;
    }
    public int getB()
    {
        return lineMaxB;
    }
    public void setPeople(String [] N)
    {
        this.N = N;
    }
    public String [] getPeople()
    {
        return N;
    }
    public void setTSAline(int TSAline)
    {
        this.TSAline = TSAline;
    }
    /***************************************************************************
    getTSAline: Gets value for TSAline
    return: TSAline value
     * @return 
    ***************************************************************************/
    public int getTSAline()
    {
        return TSAline;
    }
    public LinkedList <Line> makeLine()
    {

        String [] nLine = getPeople();
        double time = 0;
        int lineValue =0;
        LinkedList<Line> arrayN = new LinkedList();
        for (int i =0; i<nLine.length; i++)
        {
            if (getA() < 1)
            {
                Random value = new Random();
                double timeValue = 1.0 + (10.0 - 1.0) * value.nextDouble();
                lineValue = 2;
                String name = nLine[i];
                time = time + timeValue;
                Line lineN = new Line(lineValue, name, time);
                arrayN.add(lineN);
                
            }
            else if (getB() < 1)
            {
                Random value = new Random();
                double timeValue = 1.0 + (10.0 - 1.0) * value.nextDouble();
                lineValue = 1;
                String name = nLine[i];
                time = time + timeValue;
                Line lineN = new Line(lineValue, name, time);
                arrayN.add(lineN);
            }
            else
            {
                Random value = new Random();
                double timeValue = 1.0 + (10.0 - 1.0) * value.nextDouble();
                String name = nLine[i];
                time = time + timeValue;
                Random AorB = new Random();
                lineValue = AorB.nextInt(2)+ 1;
                Line lineN = new Line(lineValue, name, time);
                arrayN.add(lineN);
            }
        }        

        return arrayN;
    }
    
    public void displayUI()
    {
        System.out.println("Please provide values for your Queue A, Queue B and "
                + "how many people are going through the TSA");
        readFile();
        System.out.println("you gave Queue A a max of " + getA() + " people.");
        System.out.println("you gave Queue B a max of " + getB() + " people.");
        System.out.println("The simulation will handle " + getTSAline() + " people.");
    }

    public static void main(String[] args) {
        
        TSA_Que TSA = new TSA_Que();
        TSA.openFile();
        TSA.displayUI();
        LinkedList <Line> N = TSA.makeLine();

        LinkedBlockingQueue <Line> QueA = new LinkedBlockingQueue<Line>(TSA.getA());
        LinkedBlockingQueue <Line> QueB = new LinkedBlockingQueue<Line>(TSA.getB());
        LinkedBlockingQueue <Line> QueC = new LinkedBlockingQueue<Line>();
        MakeQue QueLine = new MakeQue(QueA, QueB);
        QueLine.setQue(N);
        
        
        CheckerA checkA = new CheckerA(QueA, QueC, QueLine);
        CheckerB checkB =new CheckerB(QueB, QueC, QueLine);
        CheckerC checkC =new CheckerC(QueC, QueLine);
        //ObservingN obsConsumerA = new ObservingN(QueA, QueB, QueLine);
        //RemovingN remConsumer = new RemovingN(QueA, QueB, QueLine);
        

        
        Thread MakeQThread = new Thread(QueLine);
        Thread AThread = new Thread(checkA);
        Thread BThread = new Thread(checkB);
        Thread CThread = new Thread(checkC);
        //Thread remNThread = new Thread(remConsumer);

        
        MakeQThread.start();
        AThread.start();
        BThread.start();
        CThread.start();
        //remNThread.start();        
        /*LinkedBlockingQueue QueB = new LinkedBlockingQueue(TSA.getB());
        MakeQua makeB = new MakeQ(QueB);
        makeB.setArray(B);
        ObservingN obsConsumerB = new ObservingN(QueB, makeB);
        RemovingN remConsumerB = new RemovingN(QueB, makeB);
        Thread MakeQThreadB = new Thread(makeB);
        Thread obsNThreadB = new Thread(obsConsumerB);
        Thread remNThreadB = new Thread(remConsumerB);
        MakeQThreadB.start();
        obsNThreadB.start();
        remNThreadB.start();
        TSA.closeFile();*/
    }
}
