package client;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class Client {
    public static void main(String[] args) throws Exception {
        // Socket socket = new Socket("192.168.43.21" ,6666);
        Socket socket = new Socket("localhost" ,1030);

        InputStream data =socket.getInputStream();
        int taille = 1024;
        byte[] array = new byte[taille];
        
        while (true) {
            DataInputStream stream = new DataInputStream(data);
            //Lecteur
            AdvancedPlayer player = new AdvancedPlayer(stream);

            if (stream.available() != 0) {
                System.out.println(stream.available() + "bytes");
                player.play();
            }else{
                System.out.println("Morceau termine");
                player.close();
                break;
            }
        }

    }
}
