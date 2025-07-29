// A celebrity is a person who is known to all but does not know anyone at a party. A party is being organized by some people. 
//  A square matrix mat is used to represent people at the party such that if an element of row i and column j is set to 1 it means ith person knows jth person.
//  You need to return the index of the celebrity in the party, if the celebrity does not exist, return -1.

// Note: Follow 0-based indexing.

// Examples:

// Input: mat[][] = [[0 1 0],
//                 [0 0 0], 
//                 [0 1 0]]
// Output: 1
// Explanation: 0th and 2nd person both know 1. Therefore, 1 is the celebrity. 
// Input: mat[][] = [[0 1],
//                 [1 0]]
// Output: -1
// Explanation: The two people at the party both know each other. None of them is a celebrity.



public class CelebrityProblem {

    // Method to find the celebrity in the party
    public static int findCelebrity(int[][] mat, int n) {
        // Step 1: Find the potential celebrity
        int candidate = 0;
        int j = n - 1;

        // Use two pointers, eliminating non-celebrities
        while (candidate < j) {
            if (mat[candidate][j] == 1) {
                // Candidate knows j, so candidate cannot be a celebrity
                candidate++;
            } else {
                // Candidate doesn't know j, so j cannot be a celebrity
                j--;
            }
        }

        // Step 2: Verify the candidate
        // Candidate must not know anyone and everyone must know candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate && (mat[candidate][i] == 1 || mat[i][candidate] == 0)) {
                return -1;
            }
        }

        // If candidate passes both checks, they are the celebrity
        return candidate;
    }

    //Another method

    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length ;
        for(int i = 0 ; i < n ; i++){
            boolean isCeleb = true;
            for(int j = 0 ; j < n ; j++){
               if(mat[i][j] != 0){
                   isCeleb = false;
                   break;
               }
            }
            if(isCeleb){
                for(int j = 0 ; j < n ; j++){
                    if(i != j && mat[j][i] == 0){
                        isCeleb = false;
                        break;   
                    }
                }
                
            }
            if(isCeleb)
                return i;
        }
        return -1;
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        int[][] mat = { 
            { 0, 1, 0 },
            { 0, 0, 0 }, 
            { 0, 1, 0 } 
        };
        int n = mat.length;

        int result = findCelebrity(mat, n);
        if (result == -1) {
            System.out.println("No celebrity at the party.");
        } else {
            System.out.println("The celebrity is person: " + result);
        }
    }
}
