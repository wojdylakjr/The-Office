package converter;

import fxModels.ClientFx;
import models.Client;

public class ClientConverter {
    public static Client convertClientFxToClient(ClientFx clientFx){
        Client client = new Client();
        client.setFirstName(clientFx.getFirstName());
        client.setLastName(clientFx.getLastName());
        return client;

    }
}
