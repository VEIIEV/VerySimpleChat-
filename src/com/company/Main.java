package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
   // //заводим счет на бирже

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

            // создаем серверный сокет на порту 1234
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Waiting...");

            // ждем клиента
            Socket s = server.accept();
            System.out.println("Client connected!");

            // получаем потоки ввода и вывода
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

            // создаем удобные средства ввода и вывода
            Scanner in = new Scanner(is);
            PrintStream out = new PrintStream(os);

            // читаем из сети и пишем в сеть
            out.println("What's your name?");
            out.println("Hello, " + in.nextLine());
        }


}
