import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> results = new ArrayList<>();
        
        // Loop through the expression to find operators
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            // If the character is an operator
            if (ch == '+' || ch == '-' || ch == '*') {
                // Split the expression into left and right parts
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);
                
                // Recursively solve for the left and right parts
                List<Integer> leftResults = diffWaysToCompute(left);
                List<Integer> rightResults = diffWaysToCompute(right);
                
                // Combine results from the left and right with the current operator
                for (int l : leftResults) {
                    for (int r : rightResults) {
                        if (ch == '+') {
                            results.add(l + r);
                        } else if (ch == '-') {
                            results.add(l - r);
                        } else if (ch == '*') {
                            results.add(l * r);
                        }
                    }
                }
            }
        }
        
        // Base case: if the expression contains only a number
        if (results.isEmpty()) {
            results.add(Integer.parseInt(expression));
        }
        
        return results;
    }
    
    public static void main(String[] args) {
        DifferentWaysToAddParentheses solver = new DifferentWaysToAddParentheses();
        
        // Example 1
        String expression1 = "2-1-1";
        List<Integer> result1 = solver.diffWaysToCompute(expression1);
        System.out.println(result1); // Output: [0, 2]

        // Example 2
    //     String expression2 = "2*3-4*5";
    //     List<Integer> result2 = solver.diffWaysToCompute(expression2);
    //     System.out.println(result2); // Output: [-34, -14, -10, -10, 10]
    }
}
