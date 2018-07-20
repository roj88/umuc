import java.util.Random;
import java.util.Arrays;

public class RandomThreeD{

  public static void main(String args[]){  

	Random rand = new Random();          
  	int[][][] random3DArray = new int[50][1000][3];

	for(int i = 0; i < 50; i++){
		for(int j = 0; j < 1000; j++){
			for(int k = 0; k < 3; k++){
				random3DArray[i][j][k] = rand.nextInt(255);
  	}
  }
}
}
}