package tunisie.camp.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tunisie.camp.user.domain.Address;
import tunisie.camp.user.repository.AddressRepository;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class AddressService {
    private AddressRepository address_repository;
    @Autowired
    public AddressService(AddressRepository address_repository){
        this.address_repository = address_repository;
    }

    public Address findOrThrow(final UUID id){
        return address_repository
                .findById(id)
                .orElseThrow(
                        ()->new NoSuchElementException("No such id was found with this number + " + id)
                );
    }
    public Iterable<Address> findAllAddresss(){
        return address_repository.findAll();
    }
        public Address findAddressById(UUID id){
        return findOrThrow(id);
    }
    public void removeAddress(UUID id){
        address_repository.deleteById(id);
    }
    public Address addAddress(Address address){
        return address_repository.save(address);
    }
    public void updateAddress(UUID id, Address address){
        findAddressById(id);
        address_repository.save(address);
    }
}
