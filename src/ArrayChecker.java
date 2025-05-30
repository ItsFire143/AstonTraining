import java.util.ArrayList;
import java.util.List;

public class ArrayChecker {
    public static int TransAndSumArray(String[][] array) throws MyArraySizeException, ArrayDataException {

        int sum = 0;

        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен иметь 4 строки");
        }

        for (String[] strings : array) {
            if (strings.length != 4) {
                throw new MyArraySizeException("Не во всех строках есть 4-х ячейки");
            }
        }

        List<String> errors = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    errors.add("Ячейка " + i + " " + j + " не валидное значение");
                }
            }
        }

        if (!errors.isEmpty()) {
            throw new ArrayDataException(errors, sum);
        }

        return sum;
    }
}

