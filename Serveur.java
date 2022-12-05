package serveur;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Serveur
 */
public class Serveur {
    public static void main(String[] args) throws Exception {
        ServerSocket serveurSocket = new ServerSocket(1030);
        System.out.println("En attente d'un client");

        Socket socket = serveurSocket.accept();
        OutputStream outputStream = socket.getOutputStream();
        File song = new File("D:\\Data Ilo\\ITU\\L2\\S3\\Reseau\\StreamingAudio\\Songs\\2Pac_Hit_Em_Up_Dirty.mp3");
        FileInputStream fileInputStream = new FileInputStream(song);

        while (true) {
            byte[] array = new byte[1024];
            fileInputStream.read(array);
            outputStream.write(array);
            outputStream.flush();
            //Mijery longueur byte envoye
            System.out.println(fileInputStream.available()+"bytes sent");
        }
    }
}