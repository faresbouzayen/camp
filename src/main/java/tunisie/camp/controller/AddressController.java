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
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v/addresses")
public class AddressController {
    private final AddressService address_service;
    private final ModelMapper not_mapper;

    private AddressDTO toDto(Address address){
        return not_mapper.map(address, AddressDTO.class);
    }
    private Address toEntity(AddressDTO addressDTO){
        return not_mapper.map(addressDTO, Address.class);
    }

    @GetMapping
    public List<AddressDTO> getAddresss(){
        var address_list = StreamSupport
                .stream(address_service.findAllAddresss().spliterator(), false)
                .collect(Collectors.toList());
        return address_list
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public AddressDTO postAddress(@Validated @RequestBody AddressDTO address_dto){
        var entity = toEntity(address_dto);
        var address = address_service.addAddress(entity);
        return toDto(address);
    }

    @PutMapping("/{address_id}")
    public void putAddress(@PathVariable("address_id") long address_id, @Validated @RequestBody AddressDTO address_dto){
        if (address_id != address_dto.getAddress_id()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"address id not found");
        var address_domain = toEntity(address_dto);
        address_service.updateAddress(address_id,address_domain);
    }

    @DeleteMapping("/{address_id}")
    public void deleteAddressById(@PathVariable("address_id") long address_id){
        address_service.removeAddress(address_id);
    }
}
