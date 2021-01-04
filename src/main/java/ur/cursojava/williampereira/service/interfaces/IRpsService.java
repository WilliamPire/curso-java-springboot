package ur.cursojava.williampereira.service.interfaces;

import ur.cursojava.williampereira.domain.Rps;
import ur.cursojava.williampereira.dto.rps.RepositoryPost;
import ur.cursojava.williampereira.dto.rps.RepositoryPut;

import java.util.List;

public interface IRpsService {
    List<Rps> GetAll();

    Rps GetById(long id);

    Rps Save(RepositoryPost repositoryPost);

    void Delete(long id);

    void Replace(long id, RepositoryPut repositoryPut);

    void Like(long id);
}