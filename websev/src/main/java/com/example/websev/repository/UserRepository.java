package com.example.websev.repository;

import com.example.websev.model.SignUp;
import com.example.websev.model.User;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Transactional(Transactional.TxType.SUPPORTS)
    public ArrayList<User> queryAllUser() {
        // String SQL
        String sql = "SELECT * FROM user";

        // Querys
        Query query = entityManager.createNativeQuery(sql);

        // Get result List
        ArrayList<Object[]> resultList = (ArrayList<Object[]>) query.getResultList();

        // new return value
        ArrayList<User> users = new ArrayList<>();

        // Put result List from DB into Object
        resultList.forEach(result -> {
            User user = new User();
            user.setId(((String) result[0]));
            user.setName((String) result[1]);
            user.setSurname((String) result[2]);
            user.setAge(((Integer) result[3]).longValue());
            users.add(user);
        });

        return users;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public int insertNewUser(User user) {
        String sql = "INSERT INTO user " + "VALUES(:id, :name, :surname, :age)";

        Query query = entityManager.createNativeQuery(sql);

        query.setParameter("id", user.getId());
        query.setParameter("name", user.getName());
        query.setParameter("surname", user.getSurname());
        query.setParameter("age", user.getAge());

        return query.executeUpdate();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public int updateUserById(User user) {
        String sql = "UPDATE user_table SET";
        if (null != user.getName()) {
            sql += " NAME = :name";
            if (null != user.getSurname() || null != user.getAge()) {
                sql += ",";
            }
        }
        if (null != user.getSurname()) {
            sql += " SURNAME = :surname";
            if (null != user.getAge()) {
                sql += ",";
            }
        }
        if (null != user.getAge()) {
            sql += " AGE = :age";
        }

        sql += " WHERE ID = :id";

        Query query = entityManager.createNativeQuery(sql);

        query.setParameter("id", user.getId());

        if (null != user.getName()) {
            query.setParameter("name", user.getName());
        }
        if (null != user.getSurname()) {
            query.setParameter("surname", user.getSurname());
        }
        if (null != user.getAge()) {
            query.setParameter("age", user.getAge());
        }

        return query.executeUpdate();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public int deleteUserById(Long id) {
        String sql = "DELETE FROM user WHERE ID = :id";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);

        return query.executeUpdate();
    }



}
