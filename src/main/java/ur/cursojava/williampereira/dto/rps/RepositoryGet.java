package ur.cursojava.williampereira.dto.rps;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RepositoryGet {

    private Long Id;
    private String title;
    private String url;
    private int likes;
}