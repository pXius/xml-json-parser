package se.pricer.rectest.parcers;

public class Main {

    public static void main(String[] args) {
        if (args.length == 1) {
            ParseHandler.parseFile(args[0]);
        } else if (args.length == 2){
            ParseHandler.parseFile(args[0], args[1]);
        } else {
            System.out.println("Invalid Arguments");
        }
    }
}
