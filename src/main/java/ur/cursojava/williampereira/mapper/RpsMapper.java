package ur.cursojava.williampereira.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ur.cursojava.williampereira.domain.Rps;
import ur.cursojava.williampereira.dto.rps.RepositoryGet;
import ur.cursojava.williampereira.dto.rps.RepositoryPost;
import ur.cursojava.williampereira.dto.rps.RepositoryPut;
import ur.cursojava.williampereira.dto.rps.RepositoryTechnologyGet;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class RpsMapper {
    public static final RpsMapper INSTANCE = Mappers.getMapper(RpsMapper.class);
    public abstract Rps toRepository(RepositoryPost repositoryPost);
    public abstract List<RepositoryGet> toRepositoriesGet(List<Rps> repositories);
    public abstract RepositoryTechnologyGet toRepositoryTechnologiesGet(Rps repository);
    public abstract Rps toRepository(RepositoryPut repositoryPut);
}