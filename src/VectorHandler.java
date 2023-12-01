import java.util.ArrayList;
import java.util.Scanner;
public class VectorHandler {
    private ArrayList<MyVector> vectors = new ArrayList<MyVector>();

    public VectorHandler() {
    }
    private void compareLengths() throws DifferentVectorsLengthsException{
        ArrayList<Integer> lengths = new ArrayList<Integer>();
        for(MyVector v : vectors){
            lengths.add(v.getLength());
        }
        int length = lengths.get(0);
        for(Integer len : lengths){
            if(length != len){
                throw new DifferentVectorsLengthsException("Vectors have different lengths!", lengths);
            }
        }
    }
    public MyVector addVectors() throws DifferentVectorsLengthsException{
        compareLengths();
        MyVector resultVector = vectors.get(0);
        for(int i = 1; i < vectors.size(); i++){
            resultVector.addVector(vectors.get(i));
        }
        return resultVector;
    }
    public void setVectors( int numberOfVectors){
         if(!vectors.isEmpty()){
                vectors.clear();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert vectors:");
        for(int i=0;i<numberOfVectors;i++){
            MyVector vector = new MyVector(scanner.next());
            vectors.add(vector);
        }
    }
}
