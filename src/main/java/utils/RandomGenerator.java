package utils;

import java.util.Random;


public class RandomGenerator {
	
	public int findSmallestRandom(int range) {
		  int smallest=500;
		  int temp=0;
		  Random ran = new Random();
		  for(int i=0;i<range;i++) {
			  temp = ran.nextInt(range);
			  //System.out.println("TEMP ---> "+temp);
			  if(temp<smallest) {
				  smallest=temp;
			  }
			  System.out.println("SMALLEST is -->"+smallest);
		  }
		  return smallest;
	  }

}
