import java.util.ArrayList;

public class MyVector {
    public ArrayList<Integer> values = new ArrayList<Integer>();


    public MyVector(String vectorString) {
        String[] valuesArray = vectorString.split(",");
        for(String s : valuesArray){
            try{
                Integer value = Integer.parseInt(s);
                values.add(value);
            }catch (NumberFormatException e){
                System.out.println("The value " + s + " was ignored!");
            }
        }
    }

    public MyVector() {
    }

    public int getLength(){
        return values.size();
    }

    @Override
    public String toString() {
        String vectorString = "[";
        int i = 0;
        for (Integer value: values) {
            vectorString = vectorString + value.toString();
            if (++i != getLength()) {
                vectorString = vectorString + ", ";
            }
        }
        vectorString = vectorString + "]";
        return vectorString;
    }

    public void addVector(MyVector vector){
        for(int i = 0; i < this.getLength(); i++){
            this.values.set(i,this.values.get(i)+vector.values.get(i));
        }
    }
}
