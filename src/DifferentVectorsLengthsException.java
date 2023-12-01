import java.util.ArrayList;

public class DifferentVectorsLengthsException extends Exception {
    private ArrayList<Integer> lengths = new ArrayList<Integer>();

    public DifferentVectorsLengthsException(String message, ArrayList<Integer> lengths) {
        super(message);
        this.lengths = lengths;
    }

    public ArrayList<Integer> getLengths() {
        return lengths;
    }
}
