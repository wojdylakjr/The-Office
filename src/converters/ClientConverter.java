package converters;

import modelsFx.ClientFx;
import modelsDAO.Client;

public class ClientConverter {

    //zapisujemy bez id
    public static Client convertToClient(ClientFx clientFx) {
        return new Client(clientFx.getFirstName(), clientFx.getLastName());
    }

    //update robimy z id
    public static Client convertToClientWithId(ClientFx clientFx) {
        return new Client(clientFx.getId(), clientFx.getFirstName(), clientFx.getLastName());

    }

    public static ClientFx convertToClientFx(Client client) {
        ClientFx clientFx = new ClientFx();
        clientFx.setId(client.getId());
        clientFx.setFirstName(client.getFirstName());
        clientFx.setLastName(client.getLastName());
        return clientFx;
    }


}
