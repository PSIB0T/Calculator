package com.example.arvindo.calculator;

/**
 * Created by arvindo on 2/8/17.
 */

public class Operators {
    static String operator = "+";

    static double operation(double x, double y){
        double ans = 0;
        switch (operator){
            case "+":
                ans = x + y;
            break;

            case "-":
                ans = x - y;
            break;

            case "*":
                ans = x * y;
            break;

            case "/":
                if(y != 0)
                    ans = x / y;
            break;

            default:
                ans = x;

        }
        return ans;
    }

    static void setOperator(String op){
        operator = op;
    }
}
