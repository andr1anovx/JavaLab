package com.example.jakarta.services;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import com.example.jakarta.entities.User;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public void createUser(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    public User readUser(Long id) {
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

    public void updateUser(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        if (em.getFlushMode() != FlushModeType.COMMIT) {
            em.setFlushMode(FlushModeType.COMMIT);
        }

        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }


    public void deleteUser(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<User> findAllUsers(int maxResults) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
        query.setMaxResults(maxResults);
        List<User> users = query.getResultList();
        em.close();
        return users;
    }

    public User findById(Long id) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createNamedQuery("User.findById", User.class);

        Parameter<Long> idParam = query.getParameter("id", Long.class);

        if (!query.isBound(idParam)) {
            query.setParameter(idParam, id);
        }

        User user = query.getSingleResult();
        em.close();
        return user;
    }

    public List<String> findUsersWithSubstringInName(String substring) {
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT u.name, LOCATE(:substring, u.name) " +
                "FROM User u";

        List<Object[]> results = em.createQuery(jpql, Object[].class)
                .setParameter("substring", substring)
                .getResultList();

        List<String> usersWithSubstring = new ArrayList<>();
        for (Object[] result : results) {
            String name = (String) result[0];
            int position = (Integer) result[1];
            if (position > 0) {
                usersWithSubstring.add(name + " (substring found at position: " + position + ")");
            }
        }

        em.close();
        return usersWithSubstring;
    }

    public List<String> findUserFullNamesAndEmailLength() {
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT CONCAT(u.name, ' <', u.email, '>'), LENGTH(u.email) " +
                "FROM User u";

        List<Object[]> results = em.createQuery(jpql, Object[].class).getResultList();

        List<String> userInfoList = new ArrayList<>();
        for (Object[] result : results) {
            String fullNameWithEmail = (String) result[0];
            int emailLength = (Integer) result[1];
            userInfoList.add(fullNameWithEmail + " (email length: " + emailLength + ")");
        }

        em.close();
        return userInfoList;
    }

}
