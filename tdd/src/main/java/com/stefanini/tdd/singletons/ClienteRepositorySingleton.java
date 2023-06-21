package com.stefanini.tdd.singletons;

import com.stefanini.tdd.repository.ClienteRepository;

public final class ClienteRepositorySingleton {
    private ClienteRepositorySingleton(){}
    private static ClienteRepository instance;
    
    public static synchronized ClienteRepository getRepositoryInstance() {
        if(instance == null) {
            instance = new ClienteRepository();
        }
        return instance;
    }
}
