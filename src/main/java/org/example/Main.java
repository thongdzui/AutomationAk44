package org.example;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static boolean kiemTraNamNhuan(int year) {
        //viet mot chuong trinh kiem tra nam nhap vao co phai la nam nhuan hay ko?
        //nam nhuan la nam chia het cho 4 ma ko chia het cho 100
        /*
        2024 expected true
        2023 expected false
        -1 expected error
        * */
        if (year < 0) throw new IllegalArgumentException("Nam la so duong");
        return year % 4 == 0 && year % 100 > 0;
    }
    /*
    viet mo chuong trinh nhap vao moi chuoi xac dinh chuoi do la number hay la chu
    neu la so thi la so nguyen hay so thap phan
     */
    public static boolean kiemTraMotChuoi(String text) {
        if(text == null) return false;
        try {
            Integer.parseInt(text);
            //kiem tra so nguyen hay so thap phan
            //Double.parseDouble(text);
            return true;
        }catch (NumberFormatException e){
            return false;
        }

    }
    /*
    Kiem tra do phuc tap cua password
    length > 8 chars
    include Uppercase, lowercase
    include digits
    inclue special characters: @#$%
     */
    public static boolean isPasswordValid(String password){
        if(password.length() < 8 ) return false;

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        for(int i =0 ; i < password.length(); i++)
        {
            if( Character.isLowerCase(password.charAt(i)))
                hasLowercase = true;
            if (Character.isUpperCase(password.charAt(i)))
                hasUppercase = true;
            if (Character.isDigit(password.charAt(i)))
                hasDigit = true;
            if (!Character.isLetterOrDigit(password.charAt(i)))
                hasSpecialChar = true;

            if (hasUppercase && hasLowercase && hasDigit && hasSpecialChar)
                return true;
        }

        return false;
    }

    /*
    Tìm số lớn nhất và lớn thứ 2 của mảng cho trc
    array = {1,2,6,8,10,9,7};
     */
    private static void timSoLonNhatMang(int [] arr){
        int size = arr.length;
        int largest = arr[0];
        int smallest = arr[0];
        int secondLargest = arr[0];
        for(int i =0; i < arr.length; i++) {
            if (arr[i] > largest)
            {
                largest = arr[i];
            }
        }
        for(int i =0; i< arr.length; i++)
            if (arr[i]>secondLargest && arr[i]<largest)
            {
                secondLargest = arr[i];
            }

        System.out.print("Số lớn nhất "+largest + "\n");
        System.out.print("Số lớn nhì "+ secondLargest);
    }
    public static void main(String[] args) {
        String str1 = "Helooo@$%$##^&**$@sdfnsdj";
        int [] arr ={1,1};
        Arrays.stream(arr).sorted();

        timSoLonNhatMang(arr);

    }

}