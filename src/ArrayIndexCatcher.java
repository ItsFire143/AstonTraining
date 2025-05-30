public class ArrayIndexCatcher {

    public static void accessInvalidIndex() throws ArrayIndexOutOfBoundsException {
        int[] array = {1, 2, 3, 4, 5};

        try {
            int value = array[10];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
