import java.util.*;
class DayFour extends DayXSolutionAbs{

  String passingResult = "2";
  public DayFour(){
    super(4);
  }

  public boolean runTests(){
    
    return solvePartOne(testInput).equals(passingResult);
  }
  
  public String solvePartOne(List<String> input){
    int completeSubsetCount = 0;

    for(String line : input){
      if(hasSubset(line)){
        completeSubsetCount++;
      }
        
    }
    return Integer.toString(completeSubsetCount);
  }

  public String solvePartTwo(){
  int overlapCount = 0;

    for(String line : input){
      if(hasOverlap(line)){
        overlapCount++;
      } 
        
    }
    return Integer.toString(overlapCount);
  }

  public int[] extractValues(String[] input){
    int[] returnVal = new int[2];

    returnVal[0]= Integer.parseInt(input[0]);
    returnVal[1]= Integer.parseInt(input[1]);

    return returnVal;
  }

  
  public boolean hasOverlap(String line){
    String ranges[];
    ranges = line.split(",");

    int[] elf1, elf2;

    elf1 = extractValues(ranges[0].split("-"));
    elf2 = extractValues(ranges[1].split("-"));

    if(elf1[0] < elf2[0]){
      return elf1[1] >= elf2[0];
    }
    else if(elf1[0] > elf2[0]){
      return elf2[1] >= elf1[0];
    }

    //since first or sec #s were equal. will always be overlap
    return true;
  }
  
  public boolean hasSubset(String line){
    String ranges[];
    ranges = line.split(",");

    int[] elf1, elf2;

    elf1 = extractValues(ranges[0].split("-"));
    elf2 = extractValues(ranges[1].split("-"));

    //fails noSubset: 28-28,28-81
    if(elf1[0] < elf2[0]){
      return elf1[1] >= elf2[1];
    }
    else if(elf1[0] > elf2[0]){
      return elf2[1] >= elf1[1];
    }

    //since first #s were equal. will always be subset
    return true;
  }
  
}