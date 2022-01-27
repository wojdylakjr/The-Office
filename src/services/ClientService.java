package services;

import converter.ClientConverter;
import fxModels.ClientFx;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import models.Client;
import repositories.ClientRepository;

import java.sql.SQLException;

public class ClientService {
        private ClientRepository clientRepository  = new ClientRepository();
    private ObjectProperty<ClientFx> clientFxObjectProperty  = new SimpleObjectProperty<>(new ClientFx());

//    private ClientRepository clientRepository;
//    private ObjectProperty<ClientFx> clientFxObjectProperty;
//
//    public ClientService() {
//        this.clientRepository  = new ClientRepository();
//        this.clientFxObjectProperty  = new SimpleObjectProperty<>(new ClientFx());
//    }

    public ClientFx getClientFxObjectProperty() {
        return clientFxObjectProperty.get();
    }

    public ObjectProperty<ClientFx> clientFxObjectPropertyProperty() {
        return clientFxObjectProperty;
    }

    public void setClientFxObjectProperty(ClientFx clientFxObjectProperty) {
        this.clientFxObjectProperty.set(clientFxObjectProperty);
    }

    public void saveClientInDatabase() {
        Client client = ClientConverter.convertClientFxToClient(this.getClientFxObjectProperty());
        try{
            clientRepository.save(client);
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
}
