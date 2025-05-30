public class Main {
   public static void main(String[] args) {

// исключения в массивах
         String[][] array = {
                 {"1", "2", "3", "15"},
                 {"5", "3", "Шашлык", "8"},
                 {"9", "10", "11", "12"},
                 {"13", "Tiger", "15", "16"}
         };

         try {
             int result = ArrayChecker.TransAndSumArray(array);
             System.out.println("Сумма массива " + result);
         } catch (MyArraySizeException e) {
             System.err.println("Ошибка размара массива " + e.getMessage());
         } catch (ArrayDataException e) {
             System.err.println("Ошибка данных " + e.getMessage());
             System.out.println("Сумма корректных значений " + e.getCellErrSum());
         }

// исклюения в индексе массива
       try {
           ArrayIndexCatcher.accessInvalidIndex();
       } catch (ArrayIndexOutOfBoundsException e) {
           System.out.println(" ");
       }

   }
}
