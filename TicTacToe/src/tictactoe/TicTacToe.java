package tictactoe;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Board board = new Board();
        char userContinue = ' ';
        Scanner input = new Scanner(System.in);
        String userInput;
        int[] coordinate = new int[2];
        int currentPlayer = 1;
        while(userContinue != 'q' && userContinue != 'Q'){
            board.PromptUser();
            userInput = input.nextLine();
            
            coordinate = parseInputInt(userInput);
            
            if(coordinate[0] == 9) {
                userContinue = parseChar(userInput);
                if(userContinue != 'q') 
                    System.out.println("Invalid data entered, try again");
            }
            
            if(coordinate[0] != 9){
                
                // ToDo: entering - causes exception
                if(board.cellValues[coordinate[0]][coordinate[1]] == 0){
                    board.cellValues[coordinate[0]][coordinate[1]] = currentPlayer;
                    if (isWinCondition(currentPlayer, board)) {
                        board.PrintBoard();
                        System.out.println("Player " + currentPlayer + " wins!!!");
                        userContinue = 'q';
                    }
                    if (currentPlayer == 1) {
                        currentPlayer++;
                    } else {
                        currentPlayer--;
                    }
                }
                else {
                    System.out.println("That cell is already chosen, pick a different one");
                }
            }
        }
    }
    
    public static boolean isWinCondition(int player, Board board){
        
        // Horizontal
        int countedMatches = 0;
        
        for(int i = 0; i < board.cellValues[0].length; i++){
            countedMatches = 0;
            for (int x = 0; x < board.cellValues[0].length; x++) {
                if (board.cellValues[i][x] == player) {
                    countedMatches++;
                }
            }
            if (countedMatches == 3) {
                return true;
            }
        }
        
        // Vertical
        for(int i = 0; i < board.cellValues[0].length; i++) {
            countedMatches = 0;
            for (int x = 0; x < board.cellValues[0].length; x++) {
                if (board.cellValues[x][i] == player) {
                    countedMatches++;
                }
            }
            if (countedMatches == 3) {
                return true;
            }
        }
        
        // Anglular
        countedMatches = 0;
        for(int x = 0; x < board.cellValues[0].length; x++){
            if (board.cellValues[x][x] == player){
                countedMatches++;
            }
        }
        if(countedMatches == 3){
            return true;
        }
        countedMatches = 0;
        int i = 0;
        for(int x = board.cellValues[0].length - 1; x >= 0; x--){
            if (board.cellValues[x][i] == player){
                countedMatches++;
            }
            i++;
        }
        if(countedMatches == 3){
            return true;
        }
        
        return false;
    }
    
    public static int[] parseInputInt(String input){
        int[] selected = {9,9};
        int entered = 0;
        try{
        for(int x = 0; x < input.length(); x++){
            if(input.charAt(x) != ' ' && input.charAt(x) != 'q' && input.charAt(x) != 'Q') {
               selected[entered] = Character.getNumericValue(input.charAt(x));
               entered++;
            }
        }
        }catch (Exception e){
            // An exception will allow the default value of selected to return which indicates an error
        }
        return selected;
    }
    
    public static char parseChar(String input){
            for(int x = 0; x < input.length(); x++){
                if(input.charAt(x) == 'q' || input.charAt(x) == 'Q')
                    return 'q';
            }         
        return ' '; // Returning this is an error result
    }
}

class Board {
    
    public int[][] cellValues = new int[3][3];   
     
    public void PromptUser(){
        System.out.println( "Enter the cell you want to mark using two ints or enter Q to exit:");
        PrintBoard();
    }
    
    public void PrintBoard(){
        for(int x = 0; x < cellValues[0].length; x++){
            for(int i = 0; i < cellValues[1].length; i++){
                if(cellValues[x][i] == 0) System.out.print(" ");
                else if(cellValues[x][i] == 1) System.out.print("X");
                else System.out.print("O");
                if(i != 2) System.out.print(" | ");
                if(i == 2 && x != 2) {System.out.println(); System.out.println("---------");}
                if(i == 2 && x == 2) System.out.println();
            }                
        }
    }
}
