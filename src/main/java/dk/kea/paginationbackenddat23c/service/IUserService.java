package dk.kea.paginationbackenddat23c.service;

import dk.kea.paginationbackenddat23c.entity.User;
import java.util.List;

public interface IUserService extends ICrudService<User,Long>{
    List<User> findByName(String name);
}
