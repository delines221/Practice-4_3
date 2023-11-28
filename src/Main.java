import java.io.*;

public class Main {
    public static void main(String[] args) {
        String massege = "mmmm";
        Printable printable = new Printable() {
            @Override
            public void print(String msg) {
                System.out.println(massege);
            }
        };
        pritnMessage(massege, printable);

        Printable errorPrint = msg -> System.err.println(msg);
        pritnMessage(massege, errorPrint);

        Printable filePrintable = msg -> {
            try {
                FileWriter writer = new FileWriter("text", true);
                writer.write(msg);
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        pritnMessage(massege, filePrintable);
    }

    public static void pritnMessage(String msg, Printable printable){
        printable.print(msg);
    }





}