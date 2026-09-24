package org.example.general;

import org.example.model.Credential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Reader {
    private Reader() {}

    public static Credential collect(String call) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String option=call;
            if(call.equals("Key")){
                String key = readRequired(reader,option+":");
                String password = readRequired(reader, "Password:");    
                return new Credential(key, password);
            }
            else if(call.equals("Document")){
               String key=readDocument(reader, "Document:");
               return new Credential(key);
            }
            return null;
        }
    }
    private static String readDocument(BufferedReader reader,String prompt) throws IOException{
        while(true){
            System.out.println(prompt);
            String value=reader.readLine();
            if(Validation.isPresent(value) && !Validation.namePresent(value.trim())){
                return value.trim();
            }
            System.out.println("Name already exists:");
        }
    }

    private static String readRequired(BufferedReader reader, String prompt) throws IOException {
        while (true) {
            System.out.println(prompt);
            String value = reader.readLine();

            if (Validation.isPresent(value)) {
                return value.trim();
            }
            System.out.println("Enter a valid value.");
        }
    }
}
