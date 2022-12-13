package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Работа по протоколу TCP
 * Клиент отправляет байт (число) серверу,
 * затем получает квадрат числа
 */
public class SqClient {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("localhost", 1020)){
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(1);
            InputStream inputStream = socket.getInputStream();
            int response;
            do {
                response = inputStream.read();
                System.out.println("Результат:" + response);
                outputStream.write(response + 1);

            } while (response < 20);

            outputStream.flush();
        }
    }
}
