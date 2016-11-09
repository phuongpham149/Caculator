package com.example.phuong.caculator;

/**
 * Created by phuong on 09/11/2016.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Caculator {

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static int getPriority(String token) {
        if (token.equals("+") || token.equals("-"))
            return 1;
        if (token.equals("*") || token.equals("/"))
            return 2;
        return 0;
    }

    private static List<String> formatExpression(String mathExpression) {
        String token = "";
        mathExpression = mathExpression.trim();
        List<String> infixExpression = new ArrayList<>();
        for (int i = 0; i < mathExpression.length(); i++) {
            char ch = mathExpression.charAt(i);
            if (isOperator(ch) || ch == ')' || ch == '(') {
                if (!"".equals(token)) {
                    infixExpression.add(token);
                    token = "";
                }
                infixExpression.add(ch + "");
            } else if (ch != ' ') {
                token += ch;
            }
        }
        if (!"".equals(token))
            infixExpression.add(token);
        return infixExpression;
    }

    private static List<String> toPostfixExpression(List<String> tokens) {
        List<String> postfixExpression = new ArrayList<>();
        Stack<String> tempStack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token.charAt(0))) {
                int currentPriority = getPriority(token);
                while (!tempStack.isEmpty() && currentPriority <= getPriority(tempStack.peek())) {
                    postfixExpression.add(tempStack.pop());
                }
                tempStack.push(token);
            } else if (token.equals(")")) {
                do {
                    String operator = tempStack.pop();
                    if (operator.equals("("))
                        break;
                    postfixExpression.add(operator);
                } while (true);
            } else if (token.equals("(")) {
                tempStack.push(token);
            } else {
                postfixExpression.add(token);
            }
        }
        while (!tempStack.isEmpty()) {
            postfixExpression.add(tempStack.pop());
        }
        return postfixExpression;
    }

    private static double computeExpression(double value1, double value2, char operator) {
        switch (operator) {
            case '+':
                return value1 + value2;
            case '-':
                return value1 - value2;
            case '*':
                return value1 * value2;
            case '/':
                return value1 / value2;
            default:
                return 0.0;
        }
    }

    private static double computePostfixExpression(List<String> postfixExpression) {
        Stack<Double> tempStack = new Stack<>();
        for (String token : postfixExpression) {
            if (isOperator(token.charAt(0))) {
                double value2 = tempStack.pop();
                double value1 = tempStack.pop();
                tempStack.push(computeExpression(value1, value2, token.charAt(0)));
            } else {
                tempStack.push(Double.parseDouble(token));
            }
        }
        return tempStack.pop();
    }

    public static double computeMathExpression(String mathExpression) {
        return computePostfixExpression(toPostfixExpression(formatExpression(mathExpression)));
    }

    Caculator() {
    }

}
