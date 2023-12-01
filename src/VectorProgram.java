import java.io.IOException;
import java.util.Scanner;

public class VectorProgram {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FileHandler fileHandler;
        try{
            fileHandler = new FileHandler();
        }catch(IOException e){
            throw new RuntimeException(e);
        }

        System.out.println("How many vectors do you want to enter?");

        while(!scanner.hasNextInt()){
            System.out.println("Your input is not integer. Try again!");
            scanner.next();
        }

        int numberOfVectors = scanner.nextInt();

        VectorHandler vectorHandler = new VectorHandler();

        vectorHandler.setVectors(numberOfVectors);

        MyVector result = new MyVector();
        do{
            try{
                result = vectorHandler.addVectors();
                break;
            }catch(DifferentVectorsLengthsException e){
                System.out.println(e.getMessage());
                System.out.println(e.getLengths().get(0));
                vectorHandler.setVectors(numberOfVectors);
            }
        }while(true);

        fileHandler.writeToFile(result.toString());
        fileHandler.close();
    }
}