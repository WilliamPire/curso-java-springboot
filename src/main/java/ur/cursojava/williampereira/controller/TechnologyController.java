package ur.cursojava.williampereira.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ur.cursojava.williampereira.domain.Rps;
import ur.cursojava.williampereira.domain.Technology;
import ur.cursojava.williampereira.dto.rps.RepositoryGet;
import ur.cursojava.williampereira.dto.technology.TechnologyGet;
import ur.cursojava.williampereira.dto.technology.TechnologyRepositoryGet;
import ur.cursojava.williampereira.mapper.RpsMapper;
import ur.cursojava.williampereira.mapper.TechnologyMapper;
import ur.cursojava.williampereira.service.interfaces.ITechnologyService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/technologies")
@Log4j2
@RequiredArgsConstructor
public class TechnologyController {

    private final ITechnologyService _technologyService;

    @GetMapping
    public ResponseEntity<List<TechnologyGet>> Get() {
        return ResponseEntity.ok(TechnologyMapper.INSTANCE.toTechnologiesGet(_technologyService.GetAll()));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TechnologyRepositoryGet> GetById(@PathVariable long id) {

        Technology technology = _technologyService.GetById(id);
        TechnologyRepositoryGet returnGet = TechnologyMapper.INSTANCE.toTechnologyRepositoriesGet(technology);
        returnGet.setReps(technology.getRepositories().stream().map(Rps::getTitle).collect(Collectors.toList()));

        return ResponseEntity.ok(returnGet);
    }

    @GetMapping(path = "/{id}/repositories")
    public ResponseEntity<List<RepositoryGet>> GetByTechnologyId(@PathVariable long id) {
        Technology technology = _technologyService.GetById(id);
        List<RepositoryGet> returnGet = RpsMapper.INSTANCE.toRepositoriesGet(
                new ArrayList<>(technology.getRepositories()));

        return ResponseEntity.ok(returnGet);
    }
}