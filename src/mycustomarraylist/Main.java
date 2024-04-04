package mycustomarraylist;
import java.util.ArrayList;


public class Main{
    public static void main(String[] args) {
    MyArrayList<Integer> MyArray = new MyArrayList<>();
    
        for (int i = 0; i < 10; i++) {
            MyArray.add(i);
        }
        System.out.println(MyArray.getSize());
        MyArray.remove(9);
        System.out.println(MyArray.getSize());
        
        MyArray.display();
    }

}
