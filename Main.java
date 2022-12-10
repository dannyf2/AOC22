
class Main {
  public static void main(String[] args) {
    DayXSolutionAbs currentDay = new DayThree();

    if(currentDay.runTests()){
      currentDay.solvePartOne();
      currentDay.solvePartTwo();
    } else {
      System.out.println("Failed when running tests");
    }
    
  }
}