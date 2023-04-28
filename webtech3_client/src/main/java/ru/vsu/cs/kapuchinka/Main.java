package ru.vsu.cs.kapuchinka;

import ru.vsu.cs.kapuchinka.web.DeliveryRestClient;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DeliveryRestClient client = new DeliveryRestClient();
        try {
            client.postBunch(1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}