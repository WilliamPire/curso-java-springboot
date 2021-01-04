package ur.cursojava.williampereira.dto.rps;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RepositoryTechnologyGet {

    private Long Id;
    private String title;
    private String url;
    private int likes;
    private List<String> techs;
}