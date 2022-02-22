package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.ref.Cleaner;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ChatServer {

    ArrayList<Client> clients = new ArrayList<>();
    ServerSocket serverSocket;

    ChatServer() throws IOException {

        // создаем серверный сокет на порту 1234
        serverSocket = new ServerSocket(1234);
    }
        //кривовато всё это выглядит, и не отображает сути, но работает
    public void sendAll(String message, Client sender) {
        for (Client client: clients) {
            client.receive(message, sender.name);

        }
    }

    public void run() {
        while (true) {
            System.out.println("Waiting...");
            // ждем клиента из сети
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");
                // создаем клиента на своей стороне
                clients.add(new Client(socket, this )); //запуск клиента происходит в конструкторе класса Client
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }

        }
    }

    public static void main(String[] args)  {

        try {
            new ChatServer().run();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        //заводим счет на бирже

        // Thd thd =new Thd();
        // StockAccount stockAccount = new StockAccount();
        // //счет начинает работать
        // stockAccount.start();
        // //прибыль
        // long profit = 0;
        // //блок управления
        // Scanner in = new Scanner(System.in);
        // String command = "";
        // while (!command.equals("exit")) {
        //     command = in.next();
        //     switch(command){
        //         case "check":
        //             System.out.println(stockAccount.money);
        //             break;
        //         case "fix":
        //             //Фиксируем прибыль
        //             profit += (long)stockAccount.money - 1000;
        //             System.out.println("Profit is " + profit);
        //             //На счету остается минимальный остаток
        //             stockAccount.money = 1000;
        //     }
        // }


    }


}
