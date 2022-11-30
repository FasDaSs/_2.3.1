package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {

    }

    @Override
    public List<User> listUsers() {
        return null;
    }

    @Override
    public void updateUser(long id, User user) {

    }
}
