package tunisie.camp.camp.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tunisie.camp.camp.domain.Reclamation;
import tunisie.camp.camp.dto.ReclamationDTO;
import tunisie.camp.camp.services.ReclamationService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@PreAuthorize("isAuthenticated()")
@AllArgsConstructor
@RestController
public class ReclamationController {
    private final ReclamationService reclamation_service;
    private final ModelMapper not_mapper;

    private ReclamationDTO toDto(Reclamation reclamation){
        return not_mapper.map(reclamation, ReclamationDTO.class);
    }
    private Reclamation toEntity(ReclamationDTO reclamationDTO){
        return not_mapper.map(reclamationDTO, Reclamation.class);
    }

    @GetMapping("/reclamations")
    public List<ReclamationDTO> getReclamations(){
        var reclamation_list = StreamSupport
                .stream(reclamation_service.findAllReclamations().spliterator(), false)
                .collect(Collectors.toList());
        return reclamation_list
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/reclamations")
    public ReclamationDTO postReclamation(@Validated @RequestBody ReclamationDTO reclamation_dto){
        var entity = toEntity(reclamation_dto);
        var reclamation = reclamation_service.addReclamation(entity);
        return toDto(reclamation);
    }

    @PutMapping("/reclamations/{id}")
    public void putReclamation(@PathVariable("id") UUID id, @Validated @RequestBody ReclamationDTO reclamation_dto){
        var reclamation_domain = toEntity(reclamation_dto);
        reclamation_service.updateReclamation(id,reclamation_domain);
    }

    @DeleteMapping("/reclamations/{id}")
    public void deleteReclamationById(@PathVariable("id") UUID id){
        reclamation_service.removeReclamation(id);
    }
}
