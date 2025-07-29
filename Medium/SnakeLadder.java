// Given a 5x6 snakes and ladders board, find the minimum number of dice throws required to reach the destination or last cell (30th cell) from the source (1st cell).

// You are given an integer N denoting the total number of snakes and ladders and an array arr[] of 2*N size where 2*i and (2*i + 1)th values 
// denote the starting and ending point respectively of ith snake or ladder.The board looks like the following.
// Note: Assume that you have complete control over the 6 sided dice. No ladder starts from 1st cell                           
// Example 1:
// Input:
// N = 8
// arr[] = {3, 22, 5, 8, 11, 26, 20, 29, 
//        17, 4, 19, 7, 27, 1, 21, 9}
// Output: 3
// Explanation:
// The given board is the board shown
// in the figure. For the above board 
// output will be 3. 
// a) For 1st throw get a 2. 
// b) For 2nd throw get a 6.
// c) For 3rd throw get a 2.

// Your Task:
// You do not need to read input or print anything. Your task is to complete the function minThrow() 
// which takes N and arr as input parameters and returns the minimum number of throws required to reach the end of the game.

import java.util.LinkedList;
import java.util.Queue;

class Cell{
    int vertex;
    int distMove;
}

public class SnakeLadder {
    public int minThrow(int arr[] , int n){
        int mov[] = new int[31];
        for(int i = 0; i < n; i++){
            mov[arr[2*i] ] = arr[2 * i +1];
        }
        boolean[] visited = new boolean[31];
        visited[1] = true;
        Queue<Cell> q = new LinkedList<>();
        Cell c = new Cell();
        c.vertex = 1 ;
        c.distMove = 0;
        q.add(c);
        while(!q.isEmpty()){
            c = q.remove();
            int v = c.vertex;
            if(v == 30) break;
            for(int i = v + 1 ; i <= v + 6 && i <= 30; i++ ){
                if(!visited[i]){
                    visited[i] = true;
                    Cell cell = new Cell();
                    cell.distMove = c.distMove + 1;
                    if(mov[i] != -1)
                        cell.vertex = mov[i];
                    else
                        cell.vertex = i;
                    q.add(cell);        
                }
            }
        }
        return c.distMove;
    }
    public static void main(String[] args) {
        SnakeLadder sl = new SnakeLadder();
        int n = 8 ;
        int arr[] = {3, 22, 5, 8, 11, 26, 20, 29, 
                  17, 4, 19, 7, 27, 1, 21, 9};
       System.out.println( sl.minThrow(arr, n));
    }
}