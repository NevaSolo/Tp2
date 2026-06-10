package com.example.triangle;

public class TriangleApplication {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java -jar triangle-app.jar a b c");
            System.exit(1);
        }

        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = Integer.parseInt(args[2]);
            System.out.println(TriangleType.classify(a, b, c));
        } catch (NumberFormatException e) {
            System.out.println("Les côtés doivent être des entiers.");
            System.exit(1);
        }
    }
}
