package legacyapp.client.repository;

import legacyapp.client.model.Client;

public interface ClientRepository {
    Client getClientById(final int clientId);
}