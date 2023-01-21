package com.pr.gameserver.infrastructre.repositories;

import com.pr.gameserver.domain.entities.User;
import com.pr.gameserver.domain.ports.users.CustomizedUserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class CustomizedUserRepositoryImpl implements CustomizedUserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional()
    public User findByEmail(String email) {
        User n = entityManager.createQuery(
                        "SELECT e FROM User e WHERE e.email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult();

        System.err.println(n.getEmail());
        return n;
    }
}
