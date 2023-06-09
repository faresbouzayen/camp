package tunisie.camp.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tunisie.camp.domain.Address;
import tunisie.camp.dto.AddressDTO;
import tunisie.camp.service.AddressService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@RestController
public class AddressController {
    private final AddressService address_service;
    private final ModelMapper not_mapper;

    private AddressDTO toDto(Address address){
        return not_mapper.map(address, AddressDTO.class);
    }
    private Address toEntity(AddressDTO addressDTO){
        return not_mapper.map(addressDTO, Address.class);
    }

    @GetMapping("/addresses")
    public List<AddressDTO> getAddresss(){
        var address_list = StreamSupport
                .stream(address_service.findAllAddresss().spliterator(), false)
                .collect(Collectors.toList());
        return address_list
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/adresses")
    public AddressDTO postAddress(@Validated @RequestBody AddressDTO address_dto){
        var entity = toEntity(address_dto);
        var address = address_service.addAddress(entity);
        return toDto(address);
    }

    @PutMapping("/{id}")
    public void putAddress(@PathVariable("id") UUID id, @Validated @RequestBody AddressDTO address_dto){
        var address_domain = toEntity(address_dto);
        address_service.updateAddress(id,address_domain);
    }

    @DeleteMapping("/{id}")
    public void deleteAddressById(@PathVariable("id") UUID id){
        address_service.removeAddress(id);
    }
}
