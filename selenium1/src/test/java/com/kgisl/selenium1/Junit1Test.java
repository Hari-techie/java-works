package com.kgisl.selenium1;

import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

public class Junit1Test {
    @BeforeClass 
    public static void setup() 
    {  System.out.println("before class"); }

    @Before 
    public void before() 
    {  System.out.println("before"); }


    @Test 
    public void method1() 
    {  System.out.println("method1");
    }

    @Test 
    public void method2() 
    {  System.out.println("method2"); }
}
