import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
/**
*This class gets the 2 biggest elemnts of a random array.
*/
public class Main0 {
    public static void main(String[] args) {
        
        int randomNum;
        ArrayList<Integer> myArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            randomNum = ThreadLocalRandom.current().nextInt(2,98);
            myArrayList.add(randomNum);
        }
        int biggest = 0;
        int now;
        int secondBiggest =0;
        for (int i = 0; i < 10; i++) {
            now = myArrayList.get(i);
            if (now > biggest){
                biggest = now;
            }
        }
        System.out.println(biggest);
        int[] array = new int[myArrayList.size()];

        for (int i = 0; i < 10; i++) {
            secondBiggest = biggest;
            now = myArrayList.get(i);
            array[i]= secondBiggest-now;
        }
        for (int i = 0; i < 10; i++) {
            now = array[i];
            if (now < secondBiggest && now != 0){
                secondBiggest = now;
            }
        }
        secondBiggest = biggest-secondBiggest;
        System.out.println(secondBiggest);


    }
}
