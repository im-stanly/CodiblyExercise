package pl.Codibly.Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleSort {

    public List<Double> sort(List<Double> input){
        if (input == null)
            throw new RuntimeException();

        List<Double> inputWithoutNull = deleteNullFromList(input);
        if (inputWithoutNull == null)
            throw new RuntimeException();
        if (inputWithoutNull.size() < 2)
            return inputWithoutNull;

        int countChange = 1;
        while(countChange != 0){
            countChange = 0;
            for (int i = 0; i < inputWithoutNull.size() - 1; i++){
                Double num1 = inputWithoutNull.get(i), num2 = inputWithoutNull.get(i+1);
                double difference = num1 - num2;

                if (difference > 0){
                    inputWithoutNull.set(i+1, num1);
                    inputWithoutNull.set(i, num2);
                    countChange++;
                }
            }
        }
        return inputWithoutNull;
    }

    private List<Double> deleteNullFromList(List<Double> list){
        // i use try catch cos when try remove null from list created from Array throws exception
        try {
            list.removeAll(Collections.singleton(null));
            return list;
        }
        catch (Exception ex){
            List<Double> listWithoutNull = new ArrayList<>();

            for(Double number: list){
                if (number != null)
                    listWithoutNull.add(number);
            }
            return listWithoutNull;
        }
    }
}
