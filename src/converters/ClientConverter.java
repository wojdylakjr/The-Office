package converters;

import modelsFx.ClientFx;
import modelsDAO.Client;

public class ClientConverter {

    //zapisujemy bez id
    public static Client convertToClient(ClientFx clientFx) {
        Client client = new Client();
        client.setFirstName(clientFx.getFirstName());
        client.setLastName(clientFx.getLastName());
        return client;
    }

    //update robimy z id
    public static Client convertToClientWithId(ClientFx clientFx) {
        Client client = new Client();
        client.setId(clientFx.getId());
        client.setFirstName(clientFx.getFirstName());
        client.setLastName(clientFx.getLastName());
        return client;
    }

    public static ClientFx convertToClientFx(Client client) {
        ClientFx clientFx = new ClientFx();
        clientFx.setId(client.getId());
        clientFx.setFirstName(client.getFirstName());
        clientFx.setLastName(client.getLastName());
        return clientFx;
    }


}
