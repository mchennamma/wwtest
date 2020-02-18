package wwtests;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;
import utils.FileParser;
import utils.RandomGenerator;

public class NewTest {
  @Test
  public void fileTest() {
	  String file = System.getProperty("user.dir")+"/src/main/resources/input.txt";
	  FileParser fp = new FileParser();
	  RandomGenerator rg = new RandomGenerator();
	  fp.doesFileExist(file);
	  fp.parseFile(file);
	  rg.findSmallestRandom(500);
	  
  }
}
