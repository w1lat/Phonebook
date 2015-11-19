package talya.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import talya.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoHibernateImpl implements UserDao {

    private static final Logger LOG = Logger.getLogger(UserDaoHibernateImpl.class);

    @Autowired
    private EntityManagerFactory factory;

    public UserDaoHibernateImpl() {
    }

    public User addUser(User user) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try{
            transaction.begin();
            manager.persist(user);
            transaction.commit();
            return user;
        }catch (Exception e){
            LOG.error(e);
            transaction.rollback();
        }finally {
            manager.close();
        }
        return null;
    }

    public User findByLogin(String login) {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<User> typedQuery = manager.createQuery("FROM User u WHERE u.login = :login", User.class)
                .setParameter("login", login).setMaxResults(1);
        List<User> result= typedQuery.getResultList();
        if(result.isEmpty()){
            return null;
        }
        return result.get(0);

    }

}
