package ur.cursojava.williampereira.dto.rps;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;

@Data
public class RepositoryPost {

    @NotEmpty(message = "The repository title cannot be empty or null")
    private String title;

    @URL(message = "URL invalid")
    private String url;

    private int likes;

    private ArrayList<String> techs;
}