/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1consoleframework;

/**
 *
 * @author User
 */
public class ArrayManager {
    private int[] items;
    private int size;
    
    ArrayManager(){
    items=new int[10];
    size = 0;
    }
    ArrayManager (int _size) {
        items= new int [10];
        size = _size;
    }
    public void print (){
        for (int i=0; i<size;i++){
            if(i==size-1){
                System.out.println(items[i]+"\n");
            } else {
            System.out.println(items[i]+",");
        }
        }
    }
    public void add (int item) throws ArrayfullException{
        if (size >= items.length) {
            throw new ArrayfullException();
        }
        items[size]=item;
        size+=1;
    }
}
