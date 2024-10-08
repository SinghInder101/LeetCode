import java.util.*;
class Solution {
    public int evalRPN(String[] tokens) {

         Stack<String> stack = new Stack<String>();

        for(int i = 0; i < tokens.length ; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/") || tokens[i].equals("*")) {
                int one = Integer.parseInt(stack.pop());
                int two = Integer.parseInt(stack.pop());

                int result = 0; // Variable to store the result

                // Perform the corresponding operation based on the operator
                if (tokens[i].equals("+")) {
                    result = two + one; // Perform addition
                } else if (tokens[i].equals("-")) {
                    result = two - one; // Perform subtraction
                } else if (tokens[i].equals("/")) {
                    result = two / one; // Perform division
                } else if (tokens[i].equals("*")) {
                    result = two * one; // Perform multiplication
                }

                // Push the result back onto the stack (if needed)
                stack.push(String.valueOf(result));
            }
            else{
                stack.push(tokens[i]);
            }

        }
        return Integer.parseInt(stack.pop());

    }
}