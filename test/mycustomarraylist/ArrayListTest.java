package mycustomarraylist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {
    private MyArrayList<Integer> MyArrayList = new MyArrayList<>();
        
    
    @Before
    public void setUp()throws Exception{
        for (int i = 0; i < 100; i++) {
            MyArrayList.add(i);
        }
    }
    
    @Test
    public void whenAdded100ElementsThenSizeMustBe100(){
        Assert.assertEquals(100,MyArrayList.getSize());
    }
        
    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased(){
        Assert.assertTrue(MyArrayList.remove(5));
        Assert.assertEquals(99, MyArrayList.getSize());
        
    }
    
    @Test
    public void whenElementRemovedThenSizeMustBeDecreased(){
        Integer a = 999;
        MyArrayList.add(a);
        Assert.assertEquals(101, MyArrayList.getSize());
        Assert.assertTrue(MyArrayList.remove(a));
        Assert.assertEquals(100, MyArrayList.getSize());
    }
    @Test (expected = IllegalArgumentException.class)
    public void whenNonExistenElementRemovedThenReturnFalse(){
        Integer a = 999;
        Assert.assertFalse(MyArrayList.remove(a));
        Assert.assertEquals(100, MyArrayList.getSize());
    }
    
    @Test
    public void whenListClearedThenSizeMustBe0(){
        MyArrayList.clear();
        Assert.assertEquals(0, MyArrayList.getSize());
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenTrownException(){
        MyArrayList.get(100);
    }
    
    @Test
    public void methodGetReturnedRightValue(){
        Integer a = MyArrayList.get(0);
        Assert.assertEquals((Integer)0, a);
    }
}
