package com.example.websev.repository;

import com.example.websev.model.SignUp;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
public class SignUpRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(Transactional.TxType.REQUIRED)
    public int insertNewSignUp(SignUp signup) {
        String sql = "INSERT INTO signup " + "VALUES(:idSignUp, :password)";

        Query query = entityManager.createNativeQuery(sql);

        query.setParameter("idSignUp", signup.getIdSignUp());
        query.setParameter("password", signup.getPassword());

        return query.executeUpdate();
    }
}
