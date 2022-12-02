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
        User updatedUser = entityManager.find(User.class, user.getId());
        updatedUser.setName(user.getName());
        updatedUser.setAge(user.getAge());
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(getById(id));
    }

    @Override
    public User getById(long id) {
        return entityManager.createQuery("select u from User u where u.id=?1", User.class)
                .setParameter(1, id)
                .getSingleResult();
    }
}
