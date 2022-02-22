package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
    Socket socket;
    ChatServer server;
    Scanner in;
    PrintStream out;
    String name;

    Client(Socket socket, ChatServer server) {
        this.socket = socket;
        this.server = server;
        //��������� ��� ����, ��� ������ runnable
        new Thread(this).start();
    }

    public void receive(String message, String name) {
        if (this.name.equals(name)) {
            out.print(name + ": ");
        } else out.print(this.name + ": ");
        out.println(message);
    }


    @Override
    public void run() {

        try {

            // �������� ������ ����� � ������
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            // ������� ������� �������� ����� � ������
            in = new Scanner(is);
            out = new PrintStream(os);

            // ������ �� ���� � ����� � ����
            out.println("Welcome to chat!");
            out.println("enter you name");
            name = in.nextLine();
            String input = in.nextLine();
            while (!input.equals("bye")) {
                server.sendAll(input, this);
                input = in.nextLine();

            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
