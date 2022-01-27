package services;

import converter.ClientConverter;
import fxModels.ClientFx;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Client;
import repositories.ClientRepository;

import java.sql.SQLException;
import java.util.List;

public class ClientService {
    private ClientRepository clientRepository = new ClientRepository();
    private ObjectProperty<ClientFx> clientFxObjectProperty = new SimpleObjectProperty<>(new ClientFx());
    private ObservableList<ClientFx> clientFxObservableList = FXCollections.observableArrayList();

    public ClientFx getClientFxObjectProperty() {
        return clientFxObjectProperty.get();
    }

    public ObjectProperty<ClientFx> clientFxObjectPropertyProperty() {
        return clientFxObjectProperty;
    }

    public void setClientFxObjectProperty(ClientFx clientFxObjectProperty) {
        this.clientFxObjectProperty.set(clientFxObjectProperty);
    }

    public ObservableList<ClientFx> getClientFxObservableList() {
        return clientFxObservableList;
    }

    public void setClientFxObservableList(ObservableList<ClientFx> clientFxObservableList) {
        this.clientFxObservableList = clientFxObservableList;
    }

    public void saveClientInDatabase() throws SQLException {
        Client client = ClientConverter.convertToClient(this.getClientFxObjectProperty());
            clientRepository.save(client);
    }
    public void listClients() throws SQLException {
        List<Client> clients = clientRepository.getListOfObjects();
        this.clientFxObservableList.clear();
        for(Client client : clients){
            this.clientFxObservableList.add(ClientConverter.convertToClientFx(client));
        }
    }
}
