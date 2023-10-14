package org.example;

import org.example.config.Database;
import org.example.dto.Client;

import java.util.List;

public class ClientServiceTest {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        ClientService clientService = new ClientService(database);
        long newClientId = clientService.create("Olexandr");
        System.out.println("New client ID: " + newClientId);

        String clientName = clientService.getById(10);
        System.out.println("Client Name: " + clientName);

        clientService.setName(5, "Dima");
        System.out.println("Updated client name");

        clientService.deleteById(2);
        System.out.println("Client deleted");

        List<Client> allClients = clientService.listAll();
        System.out.println("All clients:");
        for (Client client : allClients) {
            System.out.println("ID: " + client.getId() + ", Name: " + client.getName());
        }
    }
}
