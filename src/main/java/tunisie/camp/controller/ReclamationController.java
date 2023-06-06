package tunisie.camp.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tunisie.camp.domain.Reclamation;
import tunisie.camp.dto.ReclamationDTO;
import tunisie.camp.service.ReclamationService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v/reclamations")
public class ReclamationController {
    private final ReclamationService reclamation_service;
    private final ModelMapper not_mapper;

    private ReclamationDTO toDto(Reclamation reclamation){
        return not_mapper.map(reclamation, ReclamationDTO.class);
    }
    private Reclamation toEntity(ReclamationDTO reclamationDTO){
        return not_mapper.map(reclamationDTO, Reclamation.class);
    }

    @GetMapping
    public List<ReclamationDTO> getReclamations(){
        var reclamation_list = StreamSupport
                .stream(reclamation_service.findAllReclamations().spliterator(), false)
                .collect(Collectors.toList());
        return reclamation_list
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ReclamationDTO postReclamation(@Validated @RequestBody ReclamationDTO reclamation_dto){
        var entity = toEntity(reclamation_dto);
        var reclamation = reclamation_service.addReclamation(entity);
        return toDto(reclamation);
    }

    @PutMapping("/{reclamation_id}")
    public void putReclamation(@PathVariable("reclamation_id") long reclamation_id, @Validated @RequestBody ReclamationDTO reclamation_dto){
        if (reclamation_id != reclamation_dto.getReclamation_id()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"reclamation id not found");
        var reclamation_domain = toEntity(reclamation_dto);
        reclamation_service.updateReclamation(reclamation_id,reclamation_domain);
    }

    @DeleteMapping("/{reclamation_id}")
    public void deleteReclamationById(@PathVariable("reclamation_id") long reclamation_id){
        reclamation_service.removeReclamation(reclamation_id);
    }
}
