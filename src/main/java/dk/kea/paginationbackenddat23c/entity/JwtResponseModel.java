package dk.kea.paginationbackenddat23c.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JwtResponseModel  {
    private final String token;
}