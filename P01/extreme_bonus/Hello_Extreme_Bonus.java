public class Hello_Extreme_Bonus {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("USAGE: java Hello_Extreme_Bonus NAME");
        }

        System.exit(1);

        System.out.printf("Hello, ");
        for(int i = 0; i < (args.length - 1); i++) {
            System.out.printf("%s ", args[i]);
        }
        System.out.printf("%s!\n", args[args.length - 1]);
    }
}