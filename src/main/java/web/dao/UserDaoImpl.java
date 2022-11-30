package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao{
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void updateUser(User user) {
        entityManager.createQuery("update User u set u.name=?1 where u.id=?2")
                .setParameter(1, user.getName())
                .setParameter(2, user.getId())
                .executeUpdate();
    }

    @Override
    public void removeUser(long id) {
        entityManager.createQuery("delete from User u where u.id=?1")
                .setParameter(1, id)
                .executeUpdate();
    }
}
