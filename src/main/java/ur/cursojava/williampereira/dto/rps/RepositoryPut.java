package ur.cursojava.williampereira.dto.rps;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;

@Getter
@Setter
public class RepositoryPut {

    @NotEmpty(message = "The repository title cannot be empty or null")
    private String title;

    @URL(message = "URL invalid")
    private String url;

    private ArrayList<String> techs;
}