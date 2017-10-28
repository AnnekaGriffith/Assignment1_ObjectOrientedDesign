/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Dictionary2 Class: scalable dictionary that stores an English word and its 
 * meanings using linked lists or trees or both. 
 *                      
 * example: Store:  Apple => fruit, computer
 *                  Query: Apple?
 *                  Answer: fruit, computer
 *
 * @author Anneka Bath
 * * date 10/23/17
 */

public final class Dictionary2 

{
    private Scanner dictionaryData;
    private BinaryTree root = null;
    
    //******************************************************************
    //OpenFile: opens test file and throws exception if no file is found
    //******************************************************************
    public void openFile() 
    {
        try
        {
            dictionaryData = new Scanner (new File ("C:\\Users\\ozzma\\Documents\\"
                    + "OOD&P\\Dictionary2\\test\\Dictionary_Test.txt"));
        }
        catch(Exception e )
        {
            System.out.println("no file");
        }
    } 
    //*************************************************************************
    //readFile: reads file and sends it to makeRoot to be stored and looked up 
    //found for later
    //**************************************************************************
    public void readFile()
    {
        try
        {
            while (dictionaryData.hasNext())
            {
                System.out.print("Store: ");
                String key = dictionaryData.next(); 
                //gets first string of data
                System.out.print(key + "=>"); 
                String value  = dictionaryData.nextLine();
                //nextline get the rest of the line of data
                System.out.print(value + "\n");
                makeRoot(key, value); 
            }
        }
        catch(Exception e )
        {
            System.out.println("invalid definition");
        }
        
    }
    //**************************************
    //closeFile: colses file that was opened
    //**************************************
    public void closeFile()
    {
        dictionaryData.close();
    }
    //*************************************************************************
    //makeRoot: checks to see if the root is a null value if it's null it 
    //create a Binary tree node with key and value as its stored information. If
    //else BinaryTree root is sent to addLeaf where it can be created into a 
    //left or a right leaf.
    //*********************************************
    public void makeRoot( String key, String value )
    {
        if ( root == null )
        {
            root = new BinaryTree( key, value );
        }
        else
        {
            root.addLeaf( key, value );
        }
    }
    //**************************************************************************
    //findMyKey: recieves a String userKey and prints out formated text, and 
    //sends userKey to getValue to retrive the definition value of the Stored key
    //**************************************************************************
    public void findMyKey(String userKey)
    {
        //getValue(userKey);
        System.out.println("Quary: " + userKey + "?");
        System.out.println("Answer: " + getValue(userKey));
    }
    //**************************************************************************
    //getValue: recieves a key value. The key is sent to findKey where it is 
    //checked against every root value in the binary root till the root hits a 
    //null key value, or a matching key. 
    //returns: String value, or null
    //**************************************************************************
    public String getValue( String key )
    {
        if (root == null)
        {
            return null;
        }
        else
        {
            String value = root.findKey(key);
            return value;
        }
        
    }
    //*********
    //main:
    //*********
    public static void main(String[] args) 
    {
        System.out.println("Create a dictionary: ");
        Dictionary2 defined = new Dictionary2();
        defined.openFile();
        defined.readFile();
        defined.findMyKey("pie");
        defined.findMyKey("pi");
        defined.findMyKey("cat");
        defined.findMyKey("apple");
        defined.closeFile();
    }
    
}
