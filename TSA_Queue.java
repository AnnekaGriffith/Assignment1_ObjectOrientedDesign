/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsa_queue;
import static java.sql.DriverManager.println;
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * simulation of a TSA line while Queues A, B, and C. Program simulates a line 
 * of 50 people and sends them through each check point. Each passenger is given 
 * a time stamp based on when they reach the queue. 
 * 
 * Each Queue has a checker that takes 1-15 minutes to process a person through.
 * each person enters through the queue at either Queue A or Queue B. Once they 
 * have gone through the first checker (either checker A or Checker B) they are 
 * sent to Queue C which is the final check point. Each Queue will have to check 
 * the length of their line to expedite the checker process. 
 * 
 * Each person entering a line will have a unique timestamp to avoid any 
 * confusion on who entered the line first. Once the program has prossed 50 
 * people the simulation ends. Each iteration of the simulation will have a max 
 * length that is set upon opening the attached file.   
 * 
 * ex: Queue A
 *      [][][][][][][]O
 *                      \ _  Queue C
 *     Queue B          /     [][][][][][][][]O
 *      [][][][][][][]O
 *  
 * key: [] = Queue spot     O = Checker
 * 
 * @author: Anneka Bath
 * date: 11/27/17
 * 
 * Issues: learning to set up Queues
 * 
 */
public class TSA_Queue {
    int lineMaxA;
    int lineMaxB;
    int numN;
    private int TSAline; 
    private Scanner maxLineQ; 
    /***************************************************************************
    OpenFile: opens test file and throws and error if one isn't found
    ***************************************************************************/
    public void openFile()
    {
        try
        {
            maxLineQ = new Scanner (new File ("C:\\Users\\ozzma\\Documents\\"
                    + "OOB&P\\Lectures\\TSA_Queue\\test\\TSA.txt"));
            
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
            while(maxLineQ.hasNext())
            {
                lineMaxA = maxLineQ.nextInt();
                System.out.println("Queue A has a length of " + lineMaxA );
                lineMaxB = maxLineQ.nextInt();
                System.out.println("Queue B has a length of " + lineMaxB );
                numN = maxLineQ.nextInt();
                System.out.println("line lenght = " + numN);
                setTSAline(numN);
                int N[] = makeLine();
                printLine(N);
                putInQueAorB(N, lineMaxA, lineMaxB);
                System.out.println();
                
                
            }
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
    ***************************************************************************/
    public void setTSAline(int TSAline)
    {
        this.TSAline = TSAline;
    }
    /***************************************************************************
    getTSAline: Gets value for TSAline
    return: TSAline value
    ***************************************************************************/
    public int getTSAline()
    {
        return TSAline;
    }
    /***************************************************************************
    makeLine: Makes an array N that is the length of TSAline and assigns each cell
    value with a 1 or a 2 at random. 
    return: int N [TSAline]
    ***************************************************************************/
    public int [] makeLine()
    {
        int N[] = new int [getTSAline()];
        for (int i =0; i<TSAline; i++)
        {
            Random value = new Random();
            int lineValue = value.nextInt(2)+ 1;
            N[i] = lineValue;
            System.out.print(lineValue + (" "));
        }
        return N;       
    }
    public void putInQueAorB(int N[], int lineMaxA, int lineMaxB)
    {
        int lineA[] = new int [lineMaxA]; 
        int lineB[] = new int [lineMaxB];
        for (int i=0; i< N.length; i++)
        {
            if (N[i] == 1)
            {
                for(int j=0; j< lineMaxA;j++)
                {
                   int value =N[i];
                   lineA[j] = value;
                }
            }
            else
            {
                for(int j=0; j< lineMaxB;j++)
                {
                    int value =N[i];
                    lineB[j] = value;
                }
            }
            printLine(lineA);
            printLine(lineB);
        }
    }
    public void printLine(int N[])
    {
        for (int i = 0; i<N.length; i++)
        {
            System.out.print(N[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        TSA_Queue TSA = new TSA_Queue();
        TSA.openFile();
        TSA.readFile();
        TSA.closeFile();
        
    }
    
}
