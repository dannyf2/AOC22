
class Main {
  public static void main(String[] args) {
    DayXSolutionAbs currentDay = new DayFour();

    if(currentDay.runTests()){
      print("part1: " + currentDay.solvePartOne());
      print("part2: " + currentDay.solvePartTwo());
    } else {
      System.out.println("Failed when running tests");
    }
    
  }

  public static void print(String output){
    System.out.println(output);
  }
}