package dk.kea.paginationbackenddat23c.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequestModel  {
    private String username;
    private String password;
}
