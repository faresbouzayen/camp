package tunisie.camp.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tunisie.camp.domain.Transport;
import tunisie.camp.dto.TransportDTO;
import tunisie.camp.service.TransportService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@RestController
public class TransportController {
    private final TransportService transport_service;
    private final ModelMapper not_mapper;

    private TransportDTO toDto(Transport transport){
        return not_mapper.map(transport, TransportDTO.class);
    }
    private Transport toEntity(TransportDTO transportDTO){
        return not_mapper.map(transportDTO, Transport.class);
    }

    @GetMapping
    public List<TransportDTO> getTransports(){
        var transport_list = StreamSupport
                .stream(transport_service.findAllTransports().spliterator(), false)
                .collect(Collectors.toList());
        return transport_list
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public TransportDTO postTransport(@Validated @RequestBody TransportDTO transport_dto){
        var entity = toEntity(transport_dto);
        var transport = transport_service.addTransport(entity);
        return toDto(transport);
    }

    @PutMapping("/{id}")
    public void putTransport(@PathVariable("id") UUID id, @Validated @RequestBody TransportDTO transport_dto){
        var transport_domain = toEntity(transport_dto);
        transport_service.updateTransport(id,transport_domain);
    }

    @DeleteMapping("/{id}")
    public void deleteTransportById(@PathVariable("id") UUID id){
        transport_service.removeTransportById(id);
    }
}
