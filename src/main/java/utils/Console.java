package utils;

import java.util.Scanner;

public class Console {
    public static void print(String val, Object... args){
        System.out.println(String.format(val, args));
    }

    public static void println(String val, Object... args){
        print(val + "\n", args);
    }

    public static String getStringInput(String prompt, Object... args){
        Scanner scanner = new Scanner(System.in);
        print(prompt, args);
        return scanner.nextLine();
    }

    public static Integer getIntegerInput(String prompt, Object... args){
        String stringIn = getStringInput(prompt, args); //____In = inputs going into console
        try {
            Integer integerIn = Integer.parseInt(stringIn);
            return integerIn;
        }catch (NumberFormatException exception){
            println("[%s] is not a valid input. Try again!");
            return getIntegerInput(prompt, args);
        }
    }

    public static Double getDoubleInput(String prompt, Object... args){
        String stringIn = getStringInput(prompt, args);
        try {
            Double doubleIn = Double.parseDouble(stringIn);
            return doubleIn;
        } catch (NumberFormatException exception) {
            println("[%s] is not a valid input. Try again!", stringIn);
            return getDoubleInput(prompt, args);
        }
    }

    public static Long getLongInput(String prompt, Object... args){
        String stringIn = getStringInput(prompt, args);
        try{
            Long longIn = Long.parseLong(stringIn);
            return longIn;
        }catch (NumberFormatException exception){
            println("[%s] is not a valid input. Try again!");
            return getLongInput(prompt, args);
        }
    }

}
