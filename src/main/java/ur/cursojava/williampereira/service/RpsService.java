package ur.cursojava.williampereira.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ur.cursojava.williampereira.domain.Rps;
import ur.cursojava.williampereira.domain.Technology;
import ur.cursojava.williampereira.dto.rps.RepositoryPost;
import ur.cursojava.williampereira.dto.rps.RepositoryPut;
import ur.cursojava.williampereira.exception.BadRequestException;
import ur.cursojava.williampereira.mapper.RpsMapper;
import ur.cursojava.williampereira.repository.interfaces.IRpsRepository;
import ur.cursojava.williampereira.repository.interfaces.ITechnologyRepository;
import ur.cursojava.williampereira.service.interfaces.IRpsService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RpsService implements IRpsService {

    private final IRpsRepository _repTechnology;
    private final ITechnologyRepository _repTech;

    public List<Rps> GetAll() {
        return _repTechnology.findAll();
    }

    public Rps GetById(long id) {

        return _repTechnology.findById(id)
                .orElseThrow(() -> new BadRequestException("Repository Id not found"));
    }

    @Transactional
    public Rps Save(RepositoryPost repositoryPost) {

        Rps repository = RpsMapper.INSTANCE.toRepository(repositoryPost);
        FillTechs(repositoryPost.getTechs(), repository);

        return _repTechnology.save(repository);
    }

    public void Delete(long id) {
        _repTechnology.delete(GetById(id));
    }

    public void Replace(long id, RepositoryPut repositoryPut) {

        Rps saveRepository = GetById(id);
        Rps repository = RpsMapper.INSTANCE.toRepository(repositoryPut);
        repository.setId(saveRepository.getId());
        FillTechs(repositoryPut.getTechs(), repository);

        _repTechnology.save(repository);
    }

    public void Like(long id) {

        Rps saveRepository = GetById(id);
        saveRepository.setLikes(saveRepository.getLikes() + 1);

        _repTechnology.save(saveRepository);
    }

    private void FillTechs(ArrayList<String> techsNew, Rps repository) {
        techsNew.forEach(techName -> {
            Technology technology = _repTech.findByName(techName);
            if (technology == null)
                repository.getTechnologies().add(new Technology(null, techName, null));
            else
                repository.getTechnologies().add(technology);
        });
    }
}