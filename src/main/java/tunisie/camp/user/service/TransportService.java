package tunisie.camp.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tunisie.camp.user.service.domain.Transport;
import tunisie.camp.user.service.repository.TransportRepository;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class TransportService {
    private final TransportRepository transport_repository;
    @Autowired
    public TransportService(TransportRepository transport_repository){
        this.transport_repository = transport_repository;
    }
    public Transport addTransport(Transport id){
        return transport_repository.save(id);
    }
    public Transport updateTransport(UUID id, Transport transport){
        findOrThrow(id);
        return transport_repository.save(transport);
    }

    public Transport findOrThrow(final UUID id){
        return transport_repository
                .findById(id)
                .orElseThrow(
                        ()-> new NoSuchElementException("No transport was found with this id = " + id)
                );
    }
    public Iterable<Transport> findAllTransports(){
        return transport_repository.findAll();
    }
    public Transport findTransportById(UUID id){
        return findOrThrow(id);
    }
    public void removeTransportById(UUID id){
        transport_repository.deleteById(id);
    }

}
