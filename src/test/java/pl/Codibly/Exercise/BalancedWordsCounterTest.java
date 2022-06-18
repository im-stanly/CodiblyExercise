package pl.Codibly.Exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedWordsCounterTest {

    private BalancedWordsCounter balancedWordsCounter = new BalancedWordsCounter();

    @Test
    public void case1(){
        String input = "aabbabcccba";
        int answer = 28;

        int responde = balancedWordsCounter.count(input);

        assertEquals(answer, responde);
    }

    @Test
    public void ifInputEmptyShouldReturnZero(){
        String input = "";
        int answer = 0;

        int responde = balancedWordsCounter.count(input);

        assertEquals(answer, responde);
    }


    @Test
    public void ifInInputNotOnlyLettersShouldTrowException(){
        String input = "abababa1";

        assertThrows(RuntimeException.class,
                () -> balancedWordsCounter.count(input));
    }

    @Test
    public void ifInputNullShouldThrowException(){
        String input = null;

        assertThrows(RuntimeException.class,
                () -> balancedWordsCounter.count(input));
    }
}