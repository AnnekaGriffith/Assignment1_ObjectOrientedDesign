/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsa_que;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ozzma
 */

public class Line {
private int tsaLine;
private String name;
private double time; 

    public Line (int tsaLine, String name, double time)
    {
        this.tsaLine = tsaLine;
        this.name = name;
        this.time =time;
    }
    public int getTSALine ()
    {
        return tsaLine;
    }
    public String getName ()
    {
        return name;
    }
    public double getTime ()
    {
        return time;
    }
    public void setTime(double time)
    {
        this.time = time;
    }
    public void print ()
    {
        System.out.println(" " + tsaLine + " " + name +" "+ time);
    }
    
}
