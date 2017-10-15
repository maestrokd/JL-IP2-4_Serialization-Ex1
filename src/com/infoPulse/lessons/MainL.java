package com.infoPulse.lessons;

import java.io.*;
import java.util.ArrayList;

public class MainL {

    public static void main(String[] args) {
        String line;
        ArrayList<Payment> payments = new ArrayList<>();

        try (FileInputStream inputStreamLocal = new FileInputStream(
                ".\\payments_input.txt");
             InputStreamReader inputStreamReaderLocal = new InputStreamReader(
                     inputStreamLocal, "CP1251");
             BufferedReader bufferReaderLocal = new BufferedReader(
                     inputStreamReaderLocal);) {


            // int data = inputStream.read();
            line = bufferReaderLocal.readLine();
            while ((line = bufferReaderLocal.readLine()) != null) {
//                System.out.println(str);
                String[] partOfLine = line.split("\\|");
                payments.add(new Payment(partOfLine[0], partOfLine[1], partOfLine[2]));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(payments.size());

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("payment.ser"));)
        {
            out.writeObject(payments);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
