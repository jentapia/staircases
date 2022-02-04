/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staircases1017;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author jennifer
 */


public class Staircases1017 {
    
    long [][] dp = new long[501][501];
    int minValue = 5;
    int maxValue = 500;
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Staircases1017();
    }
    
    public Staircases1017(){
        
        int n = getInt("ENTER A NUMBER OF BRIKS: ", minValue, maxValue); 
    
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                dp[i][j]= -1;
            }
        }
            
        System.out.println("\nRESULT: "+Solve(n,n-1) + "\n-----------------------");
            
    }
    
    public long Solve(int i, int j){
    
        if(i == 0) return 1;
        if(j == 0) return 0;
        if(dp[i][j] == -1){
            dp[i][j]=Solve(i,j-1);
            if(i >= j){
                dp[i][j] += Solve(i - j, j - 1);
            }
        }
        return dp[i][j];
        
    }
    
    public int getInt(String prompt, int minValue, int maxValue){
        
        BufferedReader myBR = new BufferedReader(new InputStreamReader(System.in));
        
        int userInput = 0;
           
        boolean valid = false; 
           
        do{
            System.out.println(prompt); //output prompt
            System.out.println("(You must enter an integer number between " + minValue + " and " + maxValue + ")");
            
            try{
                userInput = Integer.parseInt(myBR.readLine()); //read input
                valid = true;
            }
            catch(Exception e){
                System.out.println("That is not a number. Please try again\n");
            }
            
        }while ((!valid) || (userInput < minValue) || (userInput > maxValue));
           
        return userInput;
        
    }
}
