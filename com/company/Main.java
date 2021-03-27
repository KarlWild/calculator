package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] array = input.split("\\s");
        List<Integer> numbers = new ArrayList<>();
        int flag = 0;
        for (int i = 0; i < array.length; i += 2) {
            for (char s : array[i].toCharArray()) {
                if (Character.isDigit(s)) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                numbers.add(Integer.parseInt(array[i]));
            } else {
                numbers.add(RomanToArabicConverter.romanToArabic(array[i]));
                flag = 2;
            }
        }
        int result = 0;
        switch (array[1]) {
            case "+":
                result = numbers.get(0) + numbers.get(1);
                break;
            case "-":
                result = numbers.get(0) - numbers.get(1);
                break;
            case "/":
                result = numbers.get(0) / numbers.get(1);
                break;
            case "*":
                result = numbers.get(0) * numbers.get(1);
                break;
        }
        if(flag == 2) System.out.println(RomanToArabicConverter.arabicToRoman(result));
        else System.out.println(result);
    }
}
