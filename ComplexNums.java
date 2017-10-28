/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadraticformula;

/**
 *
 * @author Anneka Bath
 */
//*****************************************************************
//ComplexNums: Creates complex numbers from the quadratic variable
//*****************************************************************
public class ComplexNums { 
    //****************************
    //ComplexNums:sets private variables a,b,&c 
    //****************************
    private double a,b,c;
    public ComplexNums(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //********************
    //get calls for a,b,&c
    //********************
    public double getA()
    {
        return a;
    }
    public double getB()
    {
        return b;
    }
    public double getC()
    {
        return c;
    }
    //********************
    //set calls for a,b,&c
    //********************
    
}
