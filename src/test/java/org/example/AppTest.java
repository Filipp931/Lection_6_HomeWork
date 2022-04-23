package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.NoSuchElementException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private final String[] testArray = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
    @Test
    public void MyIteratorTestOfIteration()
    {
        MyIterator myIterator = new MyIterator(testArray);
        int i = 0;
        while (myIterator.hasNext()){
            String test = (String) myIterator.next();
            assertEquals(testArray[i], test );
            System.out.println(test);
            i++;
        }

    }

    @Test(expected = NoSuchElementException.class)
    public void MyIteratorOutOfBoundsTest(){
        MyIterator myIterator = new MyIterator(testArray);
        for (int i = 0; i < testArray.length+1; i++) {
            myIterator.next();
        }
    }
}
