package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.Main.*;

public class MainTest {
    @Test
    void namNhuan()
    {
        Assert.assertTrue(kiemTraNamNhuan(2024));

    }
    @Test
    void namKoNhuan()
    {
        Assert.assertFalse(kiemTraNamNhuan(2023));

    }
    @Test
    void namKohopLe() {
        try{
            kiemTraNamNhuan(-1);
        }catch (IllegalArgumentException e){
            Assert.assertEquals(e.getMessage(), "Nam la so duong");
        }

    }

    /*
    Define test case
    1 - input ="1" => số nguyên => true
    2 - input ="1.1" => số thập phân => true
    3 - input ="a" => chữ => false
    3.1 - input ="A" => chữ => false
    4 - input = null => false
    5 - input = "1.a" => false
    6 - input = "@" => false
    7 - input = "" =>false
     */
    @Test
    void verifyNumber()
    {
        Assert.assertTrue(kiemTraMotChuoi("1"));

    }

    @Test
    void verifyString()
    {
        Assert.assertFalse(kiemTraMotChuoi("a"));

    }
    @Test
    void verifyNull()
    {
        Assert.assertFalse(kiemTraMotChuoi(null));

    }
    @Test
    void verifyDouble()
    {
        Assert.assertTrue(kiemTraMotChuoi("1.1"));

    }
    @Test
    void verifySpecialCharacter()
    {
        Assert.assertFalse(kiemTraMotChuoi("#%"));

    }
    @Test
    void verifyEmpty()
    {
        Assert.assertFalse(kiemTraMotChuoi(""));

    }
    @Test
    void verifyNegativeNumber()
    {
        Assert.assertTrue(kiemTraMotChuoi("-9"));

    }
    /* Define test case PasswordValid
    1 - input ="jdfgd" => length < 8 => false
    2 - input ="sffsj" => not include Uppercase => false
    3 - input ="EGFNDG" => not include Lowercase => false
    4 - input ="vjfv5fa" => not include special character => false
    5 - input ="sdfdQWE" => not include number => false
    6 - input = "Qwdfvd@123" => valid Password => true
    * */

    @Test
    void passwordLessThan8Char()
    {
        Assert.assertFalse(isPasswordValid("sdf"));

    }
    @Test
    void passwordNotIncludeUppercase()
    {
        Assert.assertFalse(isPasswordValid("sdfsfqw"));

    }
    @Test
    void passwordNotIncludeLowercase()
    {
        Assert.assertFalse(isPasswordValid("RHDFVDA"));

    }
    @Test
    void passwordNotIncludeDigit()
    {
        Assert.assertFalse(isPasswordValid("hsQWdvdnv"));

    }

    @Test
    void passwordNotSpecialChar()
    {
        Assert.assertFalse(isPasswordValid("vjfv5f"));

    }
    @Test
    void passwordValid()
    {
        Assert.assertTrue(isPasswordValid("fdgdsfQw1213@#$#"));

    }

}
