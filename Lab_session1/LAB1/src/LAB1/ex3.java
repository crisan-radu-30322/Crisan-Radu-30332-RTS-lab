package LAB1;
import java.util.Random;

public class ex3 {
    public static void main(String[] args){
        Random rand = new Random();
        int bound = 30;
        int arr[] = new int[10];
        System.out.print("Array of 10 random numbers: ");
        for(int i = 0; i<10; i++){
            arr[i] = rand.nextInt(bound);
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nArray sorted: ");
        for(int i = 0; i<10; i++){
            for(int j = i+1; j<10; j++){
                if (arr[i]>arr[j]){
                    int aux = arr[i];
                    arr[i] = arr[j];
                    arr[j] = aux;
                }
            }
        }
        for(int i = 0; i<10; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
