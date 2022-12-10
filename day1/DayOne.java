import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList; 
import java.util.List;
import java.util.Collections;

class DayOne {
  public DayOne() {
    int highestCalorieCount =0;
    int currentCalorieCount =0;
    List<Integer> elfList = new ArrayList<Integer>();
    try {
    File myObj = new File("day1/input.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        if(data.equals("")){
          elfList.add(currentCalorieCount);
          currentCalorieCount=0;
        } else {
          currentCalorieCount+= Integer.parseInt(data);
        }
      }
      elfList.add(currentCalorieCount);
      Collections.sort(elfList);
      Collections.reverse(elfList);

      int output =0;
      output = elfList.get(0) + elfList.get(1) + elfList.get(2);

      for(int i : elfList)
        System.out.println(i);

      System.out.println("highest CC = " + Integer.toString(output));
    } catch (FileNotFoundException e) {
      System.out.println("couldnt locate input.txt");
    }
  }
}