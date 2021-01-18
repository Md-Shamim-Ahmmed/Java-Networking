import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Scanner;

public class Cilent {
    public static void main(String[] args) throws Exception {
        System.out.println("Cilent started...");
        Socket socket = new Socket("127.0.0.1",22222);
        System.out.println("Client connected...");

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        Scanner stdin = new Scanner(System.in);

        String message = stdin.nextLine();

        oos.writeObject(message);

        try {
            Object fromServer = ois.readObject();
            System.out.println("From Server " + (String) fromServer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
