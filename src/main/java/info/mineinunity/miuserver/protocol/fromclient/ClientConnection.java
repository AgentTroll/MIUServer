package info.mineinunity.miuserver.protocol.fromclient;

import info.mineinunity.miuserver.protocol.auth.Client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

class ClientConnection {
    private int port = 9001;
    private Socket socket = null;
    private String ip = "";

    private ObjectOutputStream writer = null;
    private ObjectInputStream reader = null;

    public ClientConnection(String address) throws Throwable {
        ip = address;
        socket = new Socket(address, port);
    }

    public boolean connect() throws Throwable {
        boolean successful = false;
        writer = new ObjectOutputStream(socket.getOutputStream());
        reader = new ObjectInputStream(socket.getInputStream());

        sendPacket(new Client("RandomName"));

        long start = System.nanoTime();
        while (true) {
            if (System.nanoTime() - start == (100 / 1000000000.0)) {
                // Timeout when the server does not respond
                // Send to connection timed out screen
                break;
            }

            Object o = reader.readObject();
            if (o != null) {
                // Check protocol
            }
        }

        return successful;
    }

    public ObjectInputStream listenPacketSend() {
        return reader;
    }

    void sendPacket(Object packet) throws Throwable {
        writer.writeObject(packet);
        writer.flush();
        writer.reset();
    }

    public void disconnect() throws Throwable {
        // Send them to the disconnect screen
        writer.close();  //
        reader.close();  // Prevent memory leaks
        socket.close();  //

        ip = null;
        port = 0; // Qualify this object for GC
    }
}