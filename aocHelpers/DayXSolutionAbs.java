import java.util.*;

abstract class DayXSolutionAbs {

  public InputReader IR;
  
  public DayXSolutionAbs(int day){
    this.IR = new InputReader(day);
  }

  abstract boolean runTests();
  
  abstract void solvePartOne();

  abstract void solvePartTwo();

  public void print(String output){
    System.out.println(output);
  }
  
}