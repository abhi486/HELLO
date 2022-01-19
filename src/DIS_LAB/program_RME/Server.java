package DIS_LAB.program_RME;

//Two Phase Commit Protocol SERVER
import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    boolean closed = false, inputFromAll = false;
    List<ClientThread> thread;
    List<String> data;

    Server() {
        thread = new ArrayList<>();
        data = new ArrayList<>();
    }

    public static void main(String[] args)
    {
        Socket clientSocket;
        ServerSocket serverSocket = null;
        int port_number = 1111;
        Server server = new Server();
        try
        {
            serverSocket = new ServerSocket(port_number);
        } catch (IOException e) {
            System.out.println(e);
        }
        while (!server.closed)
        {
            try {
                clientSocket = serverSocket.accept();
                ClientThread clientThread = new ClientThread(server, clientSocket);
                (server.thread).add(clientThread);
                System.out.println("\nNow Total clients are : " + (server.thread).size());
                (server.data).add("NOT_SENT");
                clientThread.start();
            } catch (IOException e) { }
        }
        try {

            serverSocket.close();
        } catch (Exception e1) { }
    }
}

class ClientThread extends Thread
{
    DataInputStream is = null;
    String line;
    String destClient = "";
    String name;
    PrintStream os = null;
    Socket clientSocket = null;
    String clientIdentity;
    Server server;

    public ClientThread(Server server, Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.server = server;
    }

    @SuppressWarnings("deprecation")
    public void run() {
        try {
            is = new DataInputStream(clientSocket.getInputStream());
            os = new PrintStream(clientSocket.getOutputStream());
            os.println("Enter your name.");
            name = is.readLine();
            clientIdentity = name;
            os.println("Welcome " + name + " to this 2 Phase Application.\nYou will receive a vote Request now...");
            os.println("VOTE_REQUEST\nPlease enter COMMIT or ABORT to proceed : ");
            for (int i = 0; i < (server.thread).size(); i++) {
                if ((server.thread).get(i) != this) {
                    ((server.thread).get(i)).os.println("---A new user " + name + " entered the  Appilcation---");
                }
            }
            while (true) {
                line = is.readLine();
                if (line.equalsIgnoreCase("ABORT")) {
                    System.out.println("\nFrom '" + clientIdentity
                            + "' : ABORT\n\nSince aborted we will not wait for inputs from other clients.");
                    System.out.println("\nAborted....");

                    for (int i = 0; i < (server.thread).size(); i++) {
                        ((server.thread).get(i)).os.println("GLOBAL_ABORT");
                        ((server.thread).get(i)).os.close();
                        ((server.thread).get(i)).is.close();
                    }
                    break;
                }
                if (line.equalsIgnoreCase("COMMIT")) {
                    System.out.println("\nFrom '" + clientIdentity + "' : COMMIT");
                    if ((server.thread).contains(this)) {
                        (server.data).set((server.thread).indexOf(this), "COMMIT");
                        for (int j = 0; j < (server.data).size(); j++) {
                            if (!(((server.data).get(j)).equalsIgnoreCase("NOT_SENT"))) {
                                server.inputFromAll = true;
                            }
                            else{
                                server.inputFromAll = false;
                                System.out.println("\nWaiting for inputs from other clients.");
                                break;
                            }
                        }
                        if (server.inputFromAll)
                        {
                            System.out.println("\n\nCommited....");
                            for (int i = 0; i < (server.thread).size(); i++)
                            {
                                ((server.thread).get(i)).os.println("GLOBAL_COMMIT");
                                ((server.thread).get(i)).os.close();
                                ((server.thread).get(i)).is.close();
                            }
                            break;
                        }
                    } // if thread.contains
                } // commit
            } // while
            server.closed = true;
            clientSocket.close();
        } catch (IOException e) { }

    }
}

