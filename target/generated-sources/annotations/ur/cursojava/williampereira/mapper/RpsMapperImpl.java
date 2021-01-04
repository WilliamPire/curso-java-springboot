package ur.cursojava.williampereira.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ur.cursojava.williampereira.domain.Rps;
import ur.cursojava.williampereira.dto.rps.RepositoryGet;
import ur.cursojava.williampereira.dto.rps.RepositoryPost;
import ur.cursojava.williampereira.dto.rps.RepositoryPut;
import ur.cursojava.williampereira.dto.rps.RepositoryTechnologyGet;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-04T19:26:21-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.9.1 (Amazon.com Inc.)"
)
@Component
public class RpsMapperImpl extends RpsMapper {

    @Override
    public Rps toRepository(RepositoryPost repositoryPost) {
        if ( repositoryPost == null ) {
            return null;
        }

        Rps rps = new Rps();

        rps.setTitle( repositoryPost.getTitle() );
        rps.setUrl( repositoryPost.getUrl() );
        rps.setLikes( repositoryPost.getLikes() );

        return rps;
    }

    @Override
    public List<RepositoryGet> toRepositoriesGet(List<Rps> repositories) {
        if ( repositories == null ) {
            return null;
        }

        List<RepositoryGet> list = new ArrayList<RepositoryGet>( repositories.size() );
        for ( Rps rps : repositories ) {
            list.add( rpsToRepositoryGet( rps ) );
        }

        return list;
    }

    @Override
    public RepositoryTechnologyGet toRepositoryTechnologiesGet(Rps repository) {
        if ( repository == null ) {
            return null;
        }

        RepositoryTechnologyGet repositoryTechnologyGet = new RepositoryTechnologyGet();

        repositoryTechnologyGet.setId( repository.getId() );
        repositoryTechnologyGet.setTitle( repository.getTitle() );
        repositoryTechnologyGet.setUrl( repository.getUrl() );
        repositoryTechnologyGet.setLikes( repository.getLikes() );

        return repositoryTechnologyGet;
    }

    @Override
    public Rps toRepository(RepositoryPut repositoryPut) {
        if ( repositoryPut == null ) {
            return null;
        }

        Rps rps = new Rps();

        rps.setTitle( repositoryPut.getTitle() );
        rps.setUrl( repositoryPut.getUrl() );

        return rps;
    }

    protected RepositoryGet rpsToRepositoryGet(Rps rps) {
        if ( rps == null ) {
            return null;
        }

        RepositoryGet repositoryGet = new RepositoryGet();

        repositoryGet.setId( rps.getId() );
        repositoryGet.setTitle( rps.getTitle() );
        repositoryGet.setUrl( rps.getUrl() );
        repositoryGet.setLikes( rps.getLikes() );

        return repositoryGet;
    }
}
