package services;

import converters.ClientConverter;
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
    private ObjectProperty<ClientFx> clientFxObjectPropertyUpdate = new SimpleObjectProperty<>(new ClientFx());
    private ObservableList<ClientFx> clientFxObservableList = FXCollections.observableArrayList();

    //automatyczne getery i setery

    public ClientRepository getClientRepository() {
        return clientRepository;
    }

    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientFx getClientFxObjectProperty() {
        return clientFxObjectProperty.get();
    }

    public ObjectProperty<ClientFx> clientFxObjectPropertyProperty() {
        return clientFxObjectProperty;
    }

    public void setClientFxObjectProperty(ClientFx clientFxObjectProperty) {
        this.clientFxObjectProperty.set(clientFxObjectProperty);
    }

    public ClientFx getClientFxObjectPropertyUpdate() {
        return clientFxObjectPropertyUpdate.get();
    }

    public ObjectProperty<ClientFx> clientFxObjectPropertyUpdateProperty() {
        return clientFxObjectPropertyUpdate;
    }

    public void setClientFxObjectPropertyUpdate(ClientFx clientFxObjectPropertyUpdate) {
        this.clientFxObjectPropertyUpdate.set(clientFxObjectPropertyUpdate);
    }

    public ObservableList<ClientFx> getClientFxObservableList() {
        return clientFxObservableList;
    }

    public void setClientFxObservableList(ObservableList<ClientFx> clientFxObservableList) {
        this.clientFxObservableList = clientFxObservableList;
    }

    //CRUD
    public void saveClientInDatabase() throws SQLException {
        Client client = ClientConverter.convertToClient(this.getClientFxObjectProperty());
        clientRepository.save(client);
    }

    public void listClients() throws SQLException {
        List<Client> clients = clientRepository.getListOfObjects();
        this.clientFxObservableList.clear();
        for (Client client : clients) {
            this.clientFxObservableList.add(ClientConverter.convertToClientFx(client));
        }
    }

    public void updateClientInDatabase() throws SQLException {
        System.out.println(this.getClientFxObjectPropertyUpdate());
        Client client = ClientConverter.convertToClientWithId(this.getClientFxObjectPropertyUpdate());
        System.out.println(client);
        clientRepository.update(client);
    }

    public void deleteClientInDatabase() throws SQLException {
        clientRepository.delete(this.getClientFxObjectPropertyUpdate().getId());
    }
}
