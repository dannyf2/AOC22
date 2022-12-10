import java.util.Scanner;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class InputReader {
  int dayNumber =0;
  String input,testInput;

  public InputReader(int dayNumber){
    this.dayNumber = dayNumber;
    this.input = "day" + Integer.toString(dayNumber) + "/input.txt";
    this.testInput = "day" + Integer.toString(dayNumber) + "/test.txt";
  }

  public List<String> getFileContents(String file){

    List<String> fileContents = new ArrayList<String>();
    try {
      File myObj = new File(file);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        fileContents.add(data);
      }
    } catch (FileNotFoundException e) {
      System.out.println("couldnt locate " + file);
    }

    return fileContents;
    
  }

  public List<String> getTestInput(){
    return getFileContents(testInput);
  }

  public List<String> getInput(){
    return getFileContents(input);
  }

  public void printError(String error){
    System.out.println(error);
  }
  
}