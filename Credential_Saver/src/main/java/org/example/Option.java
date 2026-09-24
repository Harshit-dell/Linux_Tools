package org.example;

import org.example.document.DocumentStore;
import org.example.general.Reader;
import org.example.model.Credential;
import org.example.secret.SecretStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Option {
    public static void option() {
        System.out.println("Options:\n 1.doc 2.pass");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))  {
            String choice=reader.readLine();
            switch (choice){
                case "pass":
                    Secret();
                    return;
                case "doc":
                    document();
                    return;
                default:
                    System.err.print("invalid Selection");
            }
            
        } catch (IOException e) {
            System.err.println(e.getCause());
        }
    }
    public static void document() throws IOException{
        //will do later
        Credential credential= Reader.collect("Document");
        DocumentStore.save(credential);
    }

    public static void Secret() throws IOException{
        try{
            Credential credential = Reader.collect("Key");
            SecretStore.save(credential);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
