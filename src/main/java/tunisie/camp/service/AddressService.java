package tunisie.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tunisie.camp.domain.Address;
import tunisie.camp.repository.AddressRepository;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class AddressService {
    private AddressRepository address_repository;
    @Autowired
    public AddressService(AddressRepository address_repository){
        this.address_repository = address_repository;
    }

    public Address findOrThrow(final long address_id){
        return address_repository
                .findById(address_id)
                .orElseThrow(
                        ()->new NoSuchElementException("No such id was found with this number + " + address_id)
                );
    }
    public Iterable<Address> findAllAddresss(){
        return address_repository.findAll();
    }
    public Address findAddressById(long address_id){
        return findOrThrow(address_id);
    }
    public void removeAddress(long address_id){
        address_repository.deleteById(address_id);
    }
    public Address addAddress(Address address){
        return address_repository.save(address);
    }
    public void updateAddress(long address_id, Address address){
        findAddressById(address_id);
        address_repository.save(address);
    }
}
