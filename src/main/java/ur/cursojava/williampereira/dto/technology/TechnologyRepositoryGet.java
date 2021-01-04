package ur.cursojava.williampereira.dto.technology;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TechnologyRepositoryGet {

    private Long Id;
    private String name;
    private List<String> reps;
}