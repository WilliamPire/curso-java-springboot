package ur.cursojava.williampereira.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ur.cursojava.williampereira.domain.Technology;
import ur.cursojava.williampereira.dto.technology.TechnologyGet;
import ur.cursojava.williampereira.dto.technology.TechnologyRepositoryGet;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TechnologyMapper {

    public static final TechnologyMapper INSTANCE = Mappers.getMapper(TechnologyMapper.class);
    public abstract Technology toTechnology(TechnologyGet technologyGet);
    public abstract Technology toTechnology(TechnologyRepositoryGet technologyRepositoryGet);
    public abstract List<TechnologyGet> toTechnologiesGet(List<Technology> technologies);
    public abstract TechnologyRepositoryGet toTechnologyRepositoriesGet(Technology technology);
}