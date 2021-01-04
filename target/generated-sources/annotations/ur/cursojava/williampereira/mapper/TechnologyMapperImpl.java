package ur.cursojava.williampereira.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ur.cursojava.williampereira.domain.Technology;
import ur.cursojava.williampereira.dto.technology.TechnologyGet;
import ur.cursojava.williampereira.dto.technology.TechnologyRepositoryGet;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-04T19:26:21-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.9.1 (Amazon.com Inc.)"
)
@Component
public class TechnologyMapperImpl extends TechnologyMapper {

    @Override
    public Technology toTechnology(TechnologyGet technologyGet) {
        if ( technologyGet == null ) {
            return null;
        }

        Technology technology = new Technology();

        technology.setId( technologyGet.getId() );
        technology.setName( technologyGet.getName() );

        return technology;
    }

    @Override
    public Technology toTechnology(TechnologyRepositoryGet technologyRepositoryGet) {
        if ( technologyRepositoryGet == null ) {
            return null;
        }

        Technology technology = new Technology();

        technology.setId( technologyRepositoryGet.getId() );
        technology.setName( technologyRepositoryGet.getName() );

        return technology;
    }

    @Override
    public List<TechnologyGet> toTechnologiesGet(List<Technology> technologies) {
        if ( technologies == null ) {
            return null;
        }

        List<TechnologyGet> list = new ArrayList<TechnologyGet>( technologies.size() );
        for ( Technology technology : technologies ) {
            list.add( technologyToTechnologyGet( technology ) );
        }

        return list;
    }

    @Override
    public TechnologyRepositoryGet toTechnologyRepositoriesGet(Technology technology) {
        if ( technology == null ) {
            return null;
        }

        TechnologyRepositoryGet technologyRepositoryGet = new TechnologyRepositoryGet();

        technologyRepositoryGet.setId( technology.getId() );
        technologyRepositoryGet.setName( technology.getName() );

        return technologyRepositoryGet;
    }

    protected TechnologyGet technologyToTechnologyGet(Technology technology) {
        if ( technology == null ) {
            return null;
        }

        TechnologyGet technologyGet = new TechnologyGet();

        technologyGet.setId( technology.getId() );
        technologyGet.setName( technology.getName() );

        return technologyGet;
    }
}
