public class Driver {
    public static void main(String[] args) {
        /*
        QueenBoard test = new QueenBoard(4);
        System.out.println(test + "\n");
        System.out.println(test.addQueen(1, 0));
        System.out.println(test + "\n");
        System.out.println(test.addQueen(1, 1) + "\n");
        System.out.println(test.addQueen(3, 1));
        System.out.println(test + "\n");
        System.out.println(test.addQueen(0, 3));
        System.out.println(test + "\n");
        System.out.println(test.removeQueen(0, 3) + "\n");
        System.out.println(test + "\n");
        System.out.println(test.removeQueen(3, 1));
        System.out.println(test + "\n");
        System.out.println(test.removeQueen(1, 0));
        System.out.println(test);

        test = new QueenBoard(7);
        System.out.println(test.addQueen(0, 0));
        System.out.println(test + "\n");
        System.out.println(test.addQueen(2, 1));
        System.out.println(test + "\n");
        System.out.println(test.addQueen(4, 2));
        System.out.println(test + "\n");
        System.out.println(test.addQueen(6, 3));
        System.out.println(test + "\n");
        System.out.println(test.addQueen(1, 4));
        System.out.println(test + "\n");
        System.out.println(test.addQueen(3, 5));
        System.out.println(test + "\n");
        System.out.println(test.removeQueen(1, 0) + "\n");
        System.out.println(test.removeQueen(0, 0));
        System.out.println(test + "\n");
        System.out.println(test.removeQueen(2, 1));
        System.out.println(test + "\n");
        System.out.println(test.removeQueen(4, 2));
        System.out.println(test + "\n");
        System.out.println(test.removeQueen(6, 3));
        System.out.println(test + "\n");
        System.out.println(test.removeQueen(1, 4));
        System.out.println(test + "\n");
        System.out.println(test.removeQueen(3, 5));
        System.out.println(test + "\n");
        */

        QueenBoard test = new QueenBoard(4);
        test.solve();
        try {
            test.solve();
        } catch (IllegalStateException e) {
            System.out.println("Exception Caught!\n");
        }
        try {
            test.countSolutions();
        } catch (IllegalStateException e) {
            System.out.println("Exception Caught!\n");
        }


        for (int i = 0; i < 10; i++) {
            test = new QueenBoard(i);
            System.out.println(test.solve() + "\n" + test + "\n");
        }

        for (int i = 0; i < 15; i++) {
            test = new QueenBoard(i);
            System.out.println(i + ": " + test.countSolutions());
        }
        System.out.println(test);
    }
}
