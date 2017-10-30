/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author agriffith
 */
public class BinaryTree {
    private final String key;
    private String value;
    private BinaryTree left, right;
    //**************************************************************************
    //BinaryTree constructor: sets the value of key and value when it is called.
    //**************************************************************************
    public BinaryTree( String key, String value )
    {
        this.key = key;
        this.value = value;
    }
    //********************************************
    //Get calles Getv: gets value, GetK: gets key
    //********************************************
    public String getV()
    {
        return value;
    }
    public String getK()
    {
        return key;
    }

    //**************************************************************************
    //addLeaf: gets a key and value. Key is compared to the previous key value 
    //in the binary tree. if it is less than getK (previous value) than it is 
    //made into a new left BinaryTree node if the left value is null, else left 
    //its sent back in to the addLeaf method.if the key is greater than getK 
    //(previous value) than it is made into a new right BinaryTree node if the 
    //right value is null, else right its sent back in to the addLeaf method.
    //else the key's value is updated in the BinaryTree
    //**************************************************************************
    public void addLeaf( String key, String value )
    {
        if ( key.compareTo( getK() ) < 0 )         
        {             
            if ( left == null )             
            {   
                left = new BinaryTree( key, value );                         
            }             
            else             
            {                 
                left.addLeaf( key, value );          
            }         
        }         
        else if ( key.compareTo( getK() ) > 0 )
        {
            if ( right == null )
            {
                right = new BinaryTree( key, value );
            }
            else
            {
                right.addLeaf( key, value );
            }
        }
        else
        {
            //update this one
            this.value = value;
        }
    }
    //**************************************************************************
    //findKey: checks to see if the key matches any keys in the BinaryTree, if 
    //it does getV is called to return the value of the key. Otherwise if key is 
    //less than previos getK (previous value) than it left is sent back to 
    //findKey and increments the node however if the left value is null te return 
    //is null.if the key is greater than getK(previous value) than it right is 
    //sent back to findKey and increments the node however if the right value is 
    //null then null is returned. 
    //returns: getV(), null, or null
    //**************************************************************************

    public String findKey( String key )
    {
        if ( getK().equals(key) )
        {
            return getV();
        }

        if ( key.compareTo( getK()) < 0 )
        {
            if (left == null)
            {
                return null;
            }
            else
            {
                return left.findKey(key);
            }
           
        }
        else
        {
            if(right == null)
            {
                return null;
            }
            else
            {
                return right.findKey(key);
            }
        }
    }   
}
