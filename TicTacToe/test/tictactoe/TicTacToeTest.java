/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author steve
 */
public class TicTacToeTest {
    
    public TicTacToeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of main method, of class TicTacToe.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        TicTacToe.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parseInputInt method, of class TicTacToe.
     */
    @Test
    public void testParseInputInt() {
        System.out.println("parseInputInt");
        String input = " 0 1";
        TicTacToe instance = new TicTacToe();
        int[] expResult = { 0,1 };
        int[] result = instance.parseInputInt(input);
        assertArrayEquals(expResult, result);
        
        input = "01";
        assertArrayEquals(expResult,instance.parseInputInt(input));
        
        input = "q";
        int[] errorResult = { 9,9 };
        result = instance.parseInputInt(input);
        assertArrayEquals(errorResult, result);
    }

    /**
     * Test of parseInputChar method, of class TicTacToe.
     */
    @Test
    public void testParseChar() {
        System.out.println("parseInputChar");
        String input = "Q";
        TicTacToe instance = new TicTacToe();
        char expResult = 'q';
        char result = instance.parseChar(input);
        assertEquals(expResult, result);
        
        input = "x";
        expResult = ' ';
        result = instance.parseChar(input);
        assertEquals(expResult, result);
    }  
    
    @Test
    public void testWinTestCondition() {
        TicTacToe instance = new TicTacToe();
        System.out.println("winTestCondtion");
        Board testBoard = new Board();
        for(int i = 0; i < testBoard.cellValues[0].length; i++){
            for (int x = 0; x < 3; x++) {
                testBoard.cellValues[i][x] = 1;
            }
            assertEquals(true, instance.isWinCondition(1, testBoard));
        }
    }
}
