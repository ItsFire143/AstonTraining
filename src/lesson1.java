public class lesson1 {
    public static void printThreeWords(){ //1
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    public static void checkSumSign(){ //2
        int a = 5, b = 12;
        int x = a + b;
        if (x >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
    public static void printColor(){ //3
        int value = 12;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 & value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }
    public static void compareNumbers(){ //4
        int a = -1;
        int b = 4;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
    public static void diapasonCheck(int a, int b){ //5
        int sum = a + b;
        if (sum >= 10 & sum <= 20) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
    public static void numberSign (int a) { //6
        if (a >= 0) {
            System.out.println("Число " + a + " положительное");
        } else {
            System.out.println("Число " + a + " отрицательное");
        }
    }
    public static void numberSignBoolean (int a) { //7
        if (a >= 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
    public static void linePrinter(String line, int b){ //8
        for(int i = 0; i < b; i++) {
            System.out.println(line);
        }
    }
    public static void leapYear(int year){ //9
        if (year % 400 == 0) {
            System.out.println("Год високосный");
        } else if (year % 100 == 0){
            System.out.println("Год не високосный");
        } else if (year % 4 == 0) {
            System.out.println("Год високосный");
        } else {
            System.out.println("Год не високосный");
        }
    }
    public static void replaceArray() { //10
        int[] array = {1,1,0,0,1,0,1,1,0,0};
        int length = array.length;
        System.out.print("Изначальный массив:  ");
        for (int i = 0; i < length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.print("Массив после замены: ");
        for (int i = 0; i < length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void hundredArray(){ //11
        int[] array = new int[100];
        System.out.print("Массив от 1 до 100: ");
        for (int i = 0; i < 100; i++) {
            array[i] = i+1;
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void multiplySixArray(){ //12
        int[] array = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        int length = array.length;
        System.out.print("Изначальный массив:     ");
        for (int i = 0; i < length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.print("Массив после умножения: ");
        for (int i = 0; i < length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
            System.out.print(array[i] + " ");
        }
    }
    public static void squareArray(int len){ //13
        int[][] array = new int[len][len];
        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++) {
                if (j == i || j+i == len-1) {
                    array[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            System.out.println();
            for (int j = 0; j < len; j++) {
                System.out.print(array[i][j]);
            }
        }
        System.out.println();
    }
    public static void fillArray(int len, int initialValue){ //14
        int[] array = new int[len];
        for (int i = 0; i < len; i++){
            array[i] = initialValue;
            System.out.print(array[i] + " ");
        }
    }
}
