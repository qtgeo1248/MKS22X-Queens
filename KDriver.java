public class KDriver {
    public static void runTest(int i){
  QueenBoard b;
  int[]tests =   {1,2,3,4,5,8};
  int[]answers = {1,0,0,2,10,92};
  if(i >= 0 && i < tests.length ){
    int size = tests[i];
    int correct = answers[i];
    b = new QueenBoard(size);
    int ans  = b.countSolutions();

    if(correct==ans){
      System.out.println("PASS board size: "+tests[i]+" "+ans);
    }else{
      System.out.println("FAIL board size: "+tests[i]+" "+ans+" vs "+correct);
    }
  }
}
}
