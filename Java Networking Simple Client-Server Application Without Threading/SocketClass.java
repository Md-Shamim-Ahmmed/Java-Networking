import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Locale;

public class SocketClass {
    public static void main(String[] args) throws IOException {
        ServerSocket serversocket = new ServerSocket(22222);
        System.out.println("Server started...");
        while (true) {
            Socket socket = serversocket.accept();
            System.out.println("Client connected...");
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            try {
                Object cMsg = ois.readObject();
                System.out.println("From Cilent " + (String) cMsg);

                String serverMsg = (String) cMsg;
                serverMsg = serverMsg.toUpperCase();

                oos.writeObject(serverMsg);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}