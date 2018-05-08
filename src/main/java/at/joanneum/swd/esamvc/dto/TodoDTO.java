package at.joanneum.swd.esamvc.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TodoDTO {

    public int id;
    public String name;
    public String description;
    public Boolean done;

}
