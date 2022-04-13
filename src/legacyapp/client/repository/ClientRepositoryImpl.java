package legacyapp.client.repository;

import legacyapp.client.model.Client;

import static legacyapp.client.enumeration.ClientName.SIMPLE_CLIENT;

public class ClientRepositoryImpl implements ClientRepository {
    public ClientRepositoryImpl() {}

    @Override
    public Client getClientById(final int clientId) {
        /* getting client from a data source... */

        return new Client(SIMPLE_CLIENT, clientId);
    }
}