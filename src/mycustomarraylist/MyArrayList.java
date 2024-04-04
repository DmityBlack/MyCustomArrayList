
package mycustomarraylist;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;


public class MyArrayList<E> implements ArrayList<E> {
    private E[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    
    public MyArrayList(int capacity) {
        if (capacity<=0) {
            throw new IllegalArgumentException("Capacity <= 0");
        }else{
            list = (E[])new Object[capacity];
            size=0;
        }
    }

    public MyArrayList() {
        list = (E[]) new Object[DEFAULT_CAPACITY];
        size=0;
    }
    
    public int getSize() {
        return size;
    }
    
    
    private void checkIndex(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
    private void grow(){
       E[] newList = (E[])new Object[size+size/2];
        for (int i = 0; i<size;i++) {
            newList[i]=list[i];
        }
        list=newList;
        
    }
    @Override
     public void add(E e) {
        if(list.length>size){
            list[size] = e;
            size++;
        }else{
            grow();
            list[size] = e;
            size++;
        }
        
    }
    
    @Override
    public void add(int index, E e) {
        checkIndex(index);
        for (int i = size; i > index; i--) {
            list[i] = list [i-1];
        }
        list[index]=e;
        size++;    
     
    }

    @Override
    public boolean addAll(Collection <? extends E> c) {
        if(!c.isEmpty()){
            for (E e : c) {
//                this.add(e);
                if(list.length>size){
                    list[size] = e;
                    size++;
                }else{
                    grow();
                    list[size] = e;
                    size++;
                }
            }
            
        }else{
            throw new IllegalArgumentException("addAll: Collection " + c + " is null" );
            
        }
        
        return false;
    }
//    
    @Override
    public void clear() {
        list = (E[]) new Object[DEFAULT_CAPACITY];
        size=0;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return list[index]; 
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            list[i] = list [i+1];
        }
        list[size-1]=null;
        size--;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int position = -1;
        if(o!=null){
            for ( int i = 0; i < size; i++) {
                if(o.equals(list[i])){
                    remove(i);
                    position=i;
                }
            }
        }
        if(position==-1){
            throw new IllegalArgumentException("Object " + o + " not found");
        }
        return true;
    }

    @Override
    public void sort(Comparator<? super E> c) {
        
    }
    
    
    public void display(){
        for (E e : list) {
            System.out.print(e + " ");
        }
    }

    
    
}
