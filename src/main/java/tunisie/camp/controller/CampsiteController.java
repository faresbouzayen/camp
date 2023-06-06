package tunisie.camp.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tunisie.camp.domain.Campsite;
import tunisie.camp.dto.CampsiteDTO;
import tunisie.camp.service.CampsiteService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v/campsites")
public class CampsiteController {
    private final CampsiteService campsite_service;
    private final ModelMapper not_mapper;

    private CampsiteDTO toDto(Campsite campsite){
        return not_mapper.map(campsite, CampsiteDTO.class);
    }
    private Campsite toEntity(CampsiteDTO campsiteDTO){
        return not_mapper.map(campsiteDTO, Campsite.class);
    }

    @GetMapping
    public List<CampsiteDTO> getCampsites(){
        var campsite_list = StreamSupport
                .stream(campsite_service.findAllCampsites().spliterator(), false)
                .collect(Collectors.toList());
        return campsite_list
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CampsiteDTO postCampsite(@Validated @RequestBody CampsiteDTO campsite_dto){
        var entity = toEntity(campsite_dto);
        var campsite = campsite_service.addCampsite(entity);
        return toDto(campsite);
    }

    @PutMapping("/{campsite_id}")
    public void putCampsite(@PathVariable("campsite_id") UUID campsite_id, @Validated @RequestBody CampsiteDTO campsite_dto){
        var campsite_domain = toEntity(campsite_dto);
        campsite_service.updateCampsite(campsite_id,campsite_domain);
    }

    @DeleteMapping("/{campsite_id}")
    public void deleteCampsiteById(@PathVariable("campsite_id") UUID campsite_id){
        campsite_service.removeCampsite(campsite_id);
    }
}
