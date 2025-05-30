import java.util.List;

public class ArrayDataException extends Exception {
    private final int cellErrSum;
    public ArrayDataException(List<String> errors, int cellErrSum) {
        super("Ошибки: " + String.join(" ", errors));
        this.cellErrSum = cellErrSum;
    }

    public int getCellErrSum(){
        return cellErrSum;
    }
}
