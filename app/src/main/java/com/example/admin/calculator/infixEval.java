package com.example.admin.calculator;

/**
 * Created by Admin on 9/28/2017.
 */

import java.util.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class infixEval{
    //Data Fields
    /** The operator stack */
    private static Stack<Character> operatorStack=new Stack<Character>();
    /** The operand stack */
    private static Stack<Integer> operandStack=new Stack<Integer>();
    /** The operators */
    private static final String OPERATORS = "()+-*/%^";
    /** The precedence of the operators matches order in OPERATORS. */
    private static final int[] PRECEDENCE = {0,0,1,1,2,2,2,3};

    /**
     * This method evaluates the infix expression
     * @param expression The infix expression
     * @return Returns the final result
     */
    public static int evaluate(String expression) {
        insertInitialExpressionIntoStacks(expression);
        return finalResult();
    }

    /**
     * Inserts the initial expression into the stacks
     * @param theExpression The infix expression
     */
    private static void insertInitialExpressionIntoStacks(String theExpression) {
        String[] expressionArray = null;
        if(theExpression.contains(" "))
            expressionArray = theExpression.split("\\s+");
        else{
            String output = "";
            for(int i = 0; i < theExpression.length();i++) {
                char ch = theExpression.charAt(i);

                switch(ch)
                {
                    case '+': // its + or -
                    case '-':
                        output += " ";
                        output += ch;
                        output += " ";
                        break; // (precedence 1)

                    case '*': // its * or / or $
                    case '/':
                        output += " ";
                        output += ch;
                        output += " ";
                        break; // (precedence 2)

                    case '(': // its a left paren
                        output += " ";
                        output += ch;
                        output += " ";
                        break;

                    case ')': // its a right paren
                        output += " ";
                        output += ch;
                        output += " ";
                        break;

                    default: // must be an operand
                        output += ch;
                        // write it to output
                        break;

                }// end switch


            }
            expressionArray = output.split("\\s+");

            List<String> list = new ArrayList<>();
            Collections.addAll(list, expressionArray);
            list.removeAll(Arrays.asList(" "));
            list.removeAll(Arrays.asList(""));
            expressionArray = list.toArray(new String[list.size()]);

			/*expressionArray = new String[theExpression.length()];
			for(int i = 0;i < theExpression.length();i++)
				expressionArray[i] = new String(Character.toString(theExpression.charAt(i))); */
        }
        for (String str:expressionArray){
            char Char = str.charAt(0);
            if (isOperator(Char))
                processOperator(Char);
                //add else if here. Check if token is an operand
            else
                operandStack.push(Integer.parseInt(str));
            //else throw new SyntaxErrorException
        }
        //return Arrays.toString(expressionArray);
    }

    /**
     * This method performs the actual operations as the operators
     * are popped off.
     */

    private static void performOperations() {
        char currentOperator;
        int leftOperand = 0;
        int rightOperand = 0;
        int theOperationValue=0;
        currentOperator = operatorStack.pop();
        try {
            rightOperand = operandStack.pop();
            leftOperand = operandStack.pop();
        } catch(SyntaxErrorException e) {
            e.getMessage();
        }

        switch(currentOperator){
            case '+':
                theOperationValue = leftOperand+rightOperand;
                break;
            case '-':
                theOperationValue = leftOperand-rightOperand;
                break;
            case '/':
                theOperationValue = leftOperand/rightOperand;
                break;
            case '*':
                theOperationValue = leftOperand*rightOperand;
                break;
            case '%':
                theOperationValue = leftOperand%rightOperand;
                break;
            case '^':
                theOperationValue =(int) Math.pow(leftOperand, rightOperand);
                break;
        }
        operandStack.push(theOperationValue);
    }

    /**
     * This method processes the operators
     * @param curr
     */
    private static void processOperator(char curr) {
        if(operatorStack.empty() || curr == '(')
            operatorStack.push(curr);
        else {
            while (!operatorStack.empty() && precedence(operatorStack.peek())>=precedence(curr)) {
                if(operatorStack.peek() == '('){
                    if(curr == ')')
                        operatorStack.pop();
                    break;
                }
                else if(curr == ')'){
                    while(operatorStack.peek() != '(')
                        performOperations();
                    operatorStack.pop();
                    break;
                }
                else
                    performOperations();

            }
            if(curr != ')'&& curr != '(')
                operatorStack.push(curr);
        }

    }

    /** Determine the precedence of an operator.
     @param op The operator
     @return the precedence

     */

    private static int precedence(char op) {
        return PRECEDENCE[OPERATORS.indexOf(op)];
    }

    private static int finalResult() {
        //add somewhere if(operand stack has more than one element)
        //throw SyntaxErrorException
        int finalResult;
        if(operatorStack.empty()) {
            try {
                finalResult = operandStack.pop();
            } catch(SyntaxErrorException e) {
                e.getMessage();
            }
        }
        else
            while(!operatorStack.empty())
                performOperations();
        finalResult = operandStack.pop();
        return finalResult;
    }

    /** Determine whether a character is and operator.
     * @param ch The character to be tested
     * @return true if ch is an operator
     */
    private static boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }

}


