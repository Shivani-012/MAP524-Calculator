package com.example.assignment1;

import java.util.ArrayList;

public class Calculator {

    // declare array list for user values
    ArrayList<String> userValues;

    // constructor
    Calculator(){
        userValues = new ArrayList<String>();
    }

    // push method that add the String parameter to the user vales array list
    public void push (String value){
        userValues.add(value);
    }

    // calculate method that performs calculates the contents of user values
    public int calculate(){

        // declare and initialize result integer
        int result = 0;

        // if array list is invalid (less than 3 elements), return unique error result
        if (userValues.size() < 3){
            return -999;
        }

        else {
            // loop through user values array list
            for (int i = 0; i < userValues.size(); i++){
                // if this is the first iteration
                if (i == 0){
                    // check if first 3 elements of array are valid (number, operator, number)
                    if (verify(userValues.get(i), userValues.get(i+1), userValues.get(i+2))){
                        // calculate the result by calling eval function
                        result = eval(Integer.parseInt(userValues.get(i)), userValues.get(i+1), Integer.parseInt(userValues.get(i+2)));
                    }
                    // else 1+ elements are invalid, return unique error result
                    else {
                        return -999;
                    }
                    i += 2; // add 2 to i since the first 3 elements were just handled
                            // next iteration will begin at index 3 (aka the 4th element)
                }
                // else is not first iteration
                else {
                    // check if next 2 elements of array are valid (operator, number)
                    if (verify(userValues.get(i), userValues.get(i+1))){
                        // calculate the result by calling eval function with previous result as first number
                        result = eval(result, userValues.get(i), Integer.parseInt(userValues.get(i+1)));

                        i++; // increment i by 1 to cover the second element that was just evaluated
                    }
                    // else invalid elements were found, return unique error result
                    else {
                        return -999;
                    }
                }
            }
        }
        return result;
    }

    // verify method that checks if the parameters are a valid number, operator and number (in order)
    public boolean verify(String num1, String operator, String num2){
        // call isNumber() and isOperator() method to validate parameters, return true is valid
        if (isNumber(num1) && isOperator(operator) && isNumber(num2)){
            return true;
        }
        return false; // return false if invalid
    }

    // overloaded verify method that checks if the parameters are a valid number, and operator (in order)
    public boolean verify(String operator, String num2){
        // call isNumber() and isOperator() method to validate parameters, return true is valid
        if (isOperator(operator) && isNumber(num2)){
            return true;
        }
        return false; // return false if invalid
    }

    // method that checks if its String parameter is a valid single-digit number
    public boolean isNumber(String value){
        // if value is a number, return true
        if (value.equals("0") || value.equals("1") || value.equals("2") || value.equals("3")
                || value.equals("4") || value.equals("5") || value.equals("6") || value.equals("7")
                || value.equals("8") || value.equals("9")){
            return true;
        }
        return false; // return false if value is not a valid single-digit number
    }

    // method that checks if its String parameter is a valid operator
    public boolean isOperator(String value){
        // if value is an operator, return true
        if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")
                || value.equals("=") || value.equals("%") || value.equalsIgnoreCase("POW")
                || value.equalsIgnoreCase("MIN")  || value.equalsIgnoreCase("MAX")){
            return true;
        }
        return false; // return false if value is not a valid operator
    }

    // method that accepts two numbers and an operator as parameters and performs the specified operation on the numbers
    public int eval(int num1, String operator, int num2){
        switch (operator){
            // if operator is "+", return the sum of the 2 numbers
            case "+":
                return (num1 + num2);
            // if operator is "-", return the difference between the 2 numbers
            case "-":
                return (num1 - num2);
            // if operator is "*", return the product of the 2 numbers
            case "*":
                return (num1 * num2);
            // if operator is "/", return the quotient of the 2 numbers
            case "/":
                return (num1 / num2);
            // if operator is "/", return the modulo of the 2 numbers
            case "%":
                return (num1 % num2);
            // if operator is "POW", return the result of num1 to the power of num2
            case "POW":
                return (int) Math.pow(num1, num2);
            // if operator is "MIN", return the smallest number of the 2 numbers
            case "MIN":
                return Math.min(num1, num2);
            // if operator is "MAX", return the largest number of the 2 numbers
            case "MAX":
                return Math.max(num1, num2);
        }
        return -999; // if program did not enter a case, error occurred. return unique error result
    }

    // method that clear the user values array list
    public void clear(){
        userValues.clear();
    }

    // method that return the values of the user values array list as a String
    public String getValues(){
        String valuesString = ""; // declare and initialize string to hold all elements

        // loop through all elements in userValues
        for (int i = 0; i < userValues.size(); i++) {
            valuesString += " " + userValues.get(i); // append each element to valuesString
        }

        return valuesString; // return valuesString
    }

}
