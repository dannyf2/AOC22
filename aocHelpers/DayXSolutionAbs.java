import java.util.*;

abstract class DayXSolutionAbs {

  public InputReader IR;
  public List<String> testInput;
  public List<String> input;
  
  public DayXSolutionAbs(int day){
    this.IR = new InputReader(day);
    testInput = IR.getTestInput();
    input = IR.getInput();
  }

  abstract boolean runTests();
  
  abstract String solvePartOne(List<String> input);

  String solvePartOne(){
    return solvePartOne(input);
  }


  abstract String solvePartTwo();

  public void print(String output){
    System.out.println(output);
  }
  
}