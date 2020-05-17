package com.company;

import org.junit.Assert;
import org.junit.Test;

public class DecodeTests {

    private void check(int exp, String tested){
        int actual = Integer.decode(tested);
        Assert.assertEquals(exp, actual);
    }

    @Test
    public void radix10(){
        check(1234, "1234");
    }

    @Test
    public void radix16(){
        check(2020, "0x7e4");
    }

    @Test
    public void radix16_2(){
        check(1337, "#539");
    }

    @Test
    public void radix8(){
        check(1488, "02720");
    }

    @Test
    public void min(){
        check(Integer.MIN_VALUE, "-2147483648");
    }

    @Test
    public void max(){
        check(Integer.MAX_VALUE, "2147483647");
    }

    @Test
    public void positive(){
        check(1234, "+1234");
    }

    @Test
    public void negative(){
        check(-1234, "-1234");
    }

    @Test (expected = NullPointerException.class)
    public void nul(){
        Integer.decode(null);
    }

    @Test(expected = NumberFormatException.class)
    public void wrongSymbols(){
        Integer.decode("forthealliance");
    }

    @Test(expected = NumberFormatException.class)
    public void signAstray(){
        Integer.decode("12-433");
    }

    @Test(expected = NumberFormatException.class)
    public void empty(){
        Integer.decode("");
    }

    @Test(expected = NumberFormatException.class)
    public void tooBig(){
        Integer.decode("4815162342");
    }
}
