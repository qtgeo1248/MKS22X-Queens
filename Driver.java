public class Driver {
    public static void main(String[] args) {
        QueenBoard test = new QueenBoard(4);
        System.out.println(test + "\n");
        System.out.println(test.addQueen(1, 0));
        System.out.println(test + "\n");
        System.out.println(test.addQueen(1, 1) + "\n");
        System.out.println(test.addQueen(3, 1));
        System.out.println(test + "\n");
        System.out.println(test.addQueen(0, 3));
        System.out.println(test + "\n");
    }
}
