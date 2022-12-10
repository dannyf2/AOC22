import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DayTwo {

  public static int resolve(String input) {
    String result = (input.split(" "))[1];
    
    input = input.replace('X', 'A');
    input = input.replace('Y', 'B');
    input = input.replace('Z', 'C');

    input = input.replace('A', '0');
    input = input.replace('B', '1');
    input = input.replace('C', '2');
    String[] splitInput = input.split(" ");
    if (splitInput.length != 2) {
      return -1;
    }
    int oponent = Integer.parseInt(splitInput[0]);
    int myAction = 0;
    if(result.equals("X")){
      if(oponent == 0){
        myAction = 2;
      } else {
        myAction = oponent - 1;
      }
    }
    else if(result.equals("Y")){
      myAction = oponent;
    }
    else if(result.equals("Z")){
      myAction = (oponent +1)%3;
    } else {
      return -1;
    }

    if (oponent == myAction) {
      return myAction + 3 + 1;
    } else if ((oponent + 1) % 3 == myAction) {
      return 6 + myAction + 1;
    } else if ((myAction + 1) % 3 == oponent) {
      return myAction + 1;
    } else {
      System.out.println("couldnt reolve RPS game: " + input);
      return -1;
    }

  }

  public DayTwo() {
    int highestCalorieCount = 0;
    int score = 0;
    List<Integer> elfList = new ArrayList<Integer>();
    try {
      File myObj = new File("day2/input.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        int result = resolve(data);
        if (result == -1)
          return;
        //System.out.println("result: " + result);
        score += result;
      }
      System.out.println("game total = " + score);
    } catch (FileNotFoundException e) {
      System.out.println("couldnt locate input.txt");
    }
  }
}