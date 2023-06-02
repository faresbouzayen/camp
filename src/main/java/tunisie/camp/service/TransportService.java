package tunisie.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tunisie.camp.domain.Transport;
import tunisie.camp.repository.TransportRepository;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class TransportService {
    private final TransportRepository transport_repository;
    @Autowired
    public TransportService(TransportRepository transport_repository){
        this.transport_repository = transport_repository;
    }
    public Transport addTransport(Transport transport_id){
        return transport_repository.save(transport_id);
    }
    public Transport updateTransport(UUID transport_id, Transport transport){
        findOrThrow(transport_id);
        return transport_repository.save(transport);
    }

    public Transport findOrThrow(final UUID transport_id){
        return transport_repository
                .findById(transport_id)
                .orElseThrow(
                        ()-> new NoSuchElementException("No transport was found with this id = " + transport_id)
                );
    }
    public Iterable<Transport> findAllTransports(){
        return transport_repository.findAll();
    }
    public Transport findTransportById(UUID transport_id){
        return findOrThrow(transport_id);
    }
    public void removeTransportById(UUID transport_id){
        transport_repository.deleteById(transport_id);
    }

}
