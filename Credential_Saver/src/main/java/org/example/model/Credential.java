package org.example.model;

public final class Credential {
    private String key;
    private String password;

    public Credential(String key, String password) {
        this.key = key;
        this.password = password;
    }
    public Credential(String key){
        this.key=key;
    }

    public String getKey() {
        return key;
    }

    public String getPassword() {
        return password;
    }
}
