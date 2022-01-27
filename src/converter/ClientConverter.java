package converter;

import fxModels.ClientFx;
import models.Client;

public class ClientConverter {
    public static Client convertToClient(ClientFx clientFx){
        Client client = new Client();
//        client.setId(clientFx.getId()); /////////////////////////////// NIE WIEM CZY TO MOZE ZOSTAC
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
