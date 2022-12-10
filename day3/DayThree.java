import java.util.*;
class DayThree extends DayXSolutionAbs{

  String letterToNumMap = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  
  public DayThree(){
    super(3);
  }

  public boolean runTests(){
    boolean result = true;
    List<String> testInput = IR.getTestInput();
    String line1, line2;
    int answers[] = {16,38,42,22,20,19};
    int count=0;

    for(String line : testInput){
      line1 = line.substring(0, line.length()/2);
      line2 = line.substring(line.length()/2);
      
      String dups = findDuplicates(line1, line2);
      int dupValue = letterToValue(dups);

      if(dupValue != answers[count]){
        print(Integer.toString(dupValue) + "on line: " + Integer.toString(count) + "did not match expected answer");
        result = false;
      }
      count++;
      
    }
    
    return result;
  }
  
  public void solvePartOne(){
    List<String> input = IR.getInput();
    String line1, line2;
    int result=0;
    for(String line : input){
      line1 = line.substring(0, line.length()/2);
      line2 = line.substring(line.length()/2);
      String dups = findDuplicates(line1, line2);
      result += letterToValue(dups);
    }
    print("part1: " + Integer.toString(result));
  }

  public void solvePartTwo(){
    List<String> input = IR.getInput();
    int result=0;
    int lineNum=1;

    String pack1 = "",pack2 = "",pack3 = "";

    for(String line : input){
      if(lineNum%3 == 1){
        pack1 = line;
      } else if(lineNum%3 == 2){
        pack2 = line;
      } else {
        pack3 = line;
        String badge = findBadge(pack1, pack2, pack3);
       result += letterToValue(badge);
      }
      lineNum++;
    }
    print("part2: " + Integer.toString(result));
  }

  public String findBadge(String pack1, String pack2, String pack3){
    String badgeList;

    badgeList = findDuplicates(pack1, pack2);
    badgeList = findDuplicates(badgeList, pack3);

    return badgeList;
  }
  
  public String findDuplicates(String line1, String line2){
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < line1.length(); i++) {
      char item = line1.charAt(i);
      if(line2.indexOf(item) >= 0){
        if(sb.indexOf(Character.toString(item)) == -1){
          sb.append(item);
        }
      }
    }
    return sb.toString();
  }

  public int letterToValue(String letter){
    return letterToNumMap.indexOf(letter) +1;
  }
  
}