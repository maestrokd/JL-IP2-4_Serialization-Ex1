package com.infoPulse.lessons;

import java.io.*;
import java.util.ArrayList;

public class MainL {

    public static void main(String[] args) {
//        String line;
        ArrayList<Payment> payments = new ArrayList<>();


        // Read data of Payments from file "payments_input.txt"
        try (FileInputStream inputStreamLocal = new FileInputStream(".\\payments_input.txt");
             InputStreamReader inputStreamReaderLocal = new InputStreamReader(inputStreamLocal, "CP1251");
             BufferedReader bufferReaderLocal = new BufferedReader(inputStreamReaderLocal))
        {
            String line = bufferReaderLocal.readLine();
            while ((line = bufferReaderLocal.readLine()) != null) {
                System.out.println(line);
                String[] partOfLine = line.split("\\|");
                payments.add(new Payment(partOfLine[0], partOfLine[1], partOfLine[2]));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound (payments_input.txt)");
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Serialization data of Payments to file "payment.ser"
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("payment.ser")))
        {
            out.writeObject(payments);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound (payment.ser)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
