package comm.vlad.system.services.impl;

import comm.vlad.system.domain.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAll();
    void save(Client client);

}
