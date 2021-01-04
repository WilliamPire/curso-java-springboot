package ur.cursojava.williampereira.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ur.cursojava.williampereira.domain.Rps;
import ur.cursojava.williampereira.domain.Technology;
import ur.cursojava.williampereira.dto.rps.RepositoryGet;
import ur.cursojava.williampereira.dto.rps.RepositoryPost;
import ur.cursojava.williampereira.dto.rps.RepositoryPut;
import ur.cursojava.williampereira.dto.rps.RepositoryTechnologyGet;
import ur.cursojava.williampereira.mapper.RpsMapper;
import ur.cursojava.williampereira.service.interfaces.IRpsService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/repositories")
@Log4j2
@RequiredArgsConstructor
public class RepositoryController {
    private final IRpsService _rpsService;

    @PostMapping
    public ResponseEntity<Void> Post(@RequestBody @Valid RepositoryPost repositoryPost) {
        _rpsService.Save(repositoryPost);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<RepositoryGet>> Get() {
        return ResponseEntity.ok(RpsMapper.INSTANCE.toRepositoriesGet(_rpsService.GetAll()));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RepositoryTechnologyGet> GetById(@PathVariable long id) {

        Rps repository = _rpsService.GetById(id);
        RepositoryTechnologyGet returnGet = RpsMapper.INSTANCE.toRepositoryTechnologiesGet(repository);
        returnGet.setTechs(repository.getTechnologies().stream().map(Technology::getName).collect(Collectors.toList()));

        return ResponseEntity.ok(returnGet);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> Put(@PathVariable long id, @RequestBody @Valid RepositoryPut repositoryPut) {
        _rpsService.Replace(id, repositoryPut);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> Delete(@PathVariable long id) {
        _rpsService.Delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(path = "/{id}/like")
    public ResponseEntity<Void> Like(@PathVariable long id) {
        _rpsService.Like(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}