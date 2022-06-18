package pl.Codibly.Exercise;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    private BubbleSort bubbleSort = new BubbleSort();

    @Test
    void case1(){
        Double[] inputArray = {1.0, 4.0, 5.0, 6.0, 8.0, 3.0, 8.0};
        Double[] answerArray = {1.0, 3.0, 4.0, 5.0, 6.0, 8.0, 8.0};
        List<Double> inputList = Arrays.asList(inputArray);

        List<Double> responseList = bubbleSort.sort(inputList);

        assertArrayEquals(answerArray, responseList.toArray());
    }

    @Test
    public void case2(){
        Double[] inputArray = {-9.3, 0.2, 4.0 ,0.1 ,5.0 , 9.0 };
        Double[] answerArray = {-9.3,0.1,0.2,4.0,5.0,9.0};
        List<Double> inputList = Arrays.asList(inputArray);

        List<Double> responseList = bubbleSort.sort(inputList);

        assertArrayEquals(answerArray, responseList.toArray());
    }

    @Test
    public void ifInputEmptyShouldReturnEmptyList(){
        Double[] inputArray = {};
        Double[] answerArray = {};
        List<Double> inputList = Arrays.asList(inputArray);

        List<Double> responseList = bubbleSort.sort(inputList);

        assertArrayEquals(answerArray, responseList.toArray());
    }

    @Test
    public void ifNullInInputShouldRemoveIt(){
        Double[] inputArray = { 5.0001, null};
        Double[] answerArray = {5.0001};
        List<Double> inputList = Arrays.asList(inputArray);

        List<Double> responseList = bubbleSort.sort(inputList);

        assertArrayEquals(answerArray, responseList.toArray());
    }

    @Test
    public void ifListIsNullShouldThrowRuntimeEx(){
        List<Double> inputList = null;

        assertThrows(RuntimeException.class,
                () -> bubbleSort.sort(inputList));
    }
}