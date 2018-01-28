package jee.project.entities.repositories;

import jee.project.entities.Boardgame;
import org.springframework.data.repository.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@org.springframework.stereotype.Repository
public class BoardgameRepository implements Repository<Boardgame, Long> {
    @PersistenceContext
    private EntityManager em;


    public Boardgame findOne(Long id) {
        return em.find(Boardgame.class, id);
    }

    public Boardgame save(Boardgame Boardgame) {
        if (findOne(Boardgame.getId()) == null) {
            em.persist(Boardgame);
            return Boardgame;
        } else {
            return em.merge(Boardgame);
        }
    }

    public Boardgame findByTitle(String title) {
        if (title == null) return null;
        TypedQuery<Boardgame> query = em.createQuery("select b from Boardgame b where b.title = :title", Boardgame.class);
        query.setParameter("title", title);

        return query.getSingleResult();
    }

    public List<Boardgame> findAllByMinAgeRestriction(int min) {
        TypedQuery<Boardgame> query = em.createQuery("select b from Boardgame b where b.ageMin >= :min", Boardgame.class);
        query.setParameter("min", min);

        return query.getResultList();
    }

    public List<Boardgame> findAllByAgeRestriction(int min, int max) {
        if (min >= max) return null;
        TypedQuery<Boardgame> query = em.createQuery("select b from Boardgame b where b.ageMin >= :min and b.ageMax <= :max", Boardgame.class);
        query.setParameter("min", min);
        query.setParameter("max", max);

        return query.getResultList();
    }

    public List<Boardgame> findAllByMinPlayers(int min) {
        TypedQuery<Boardgame> query = em.createQuery("select b from Boardgame b where b.minPlayers >= :min", Boardgame.class);
        query.setParameter("min", min);

        return query.getResultList();
    }

    public List<Boardgame> findAllByMaxPlayers(int max) {
        TypedQuery<Boardgame> query = em.createQuery("select b from Boardgame b where b.maxPlayers <= :max", Boardgame.class);
        query.setParameter("max", max);

        return query.getResultList();
    }

    public List<Boardgame> findAllByPlayersRestriction(int min, int max) {
        if (min > max) return null;
        TypedQuery<Boardgame> query = em.createQuery("select b from Boardgame b where b.minPlayers >= :min and b.maxPlayers <= :max", Boardgame.class);
        query.setParameter("min", min);
        query.setParameter("max", max);

        return query.getResultList();
    }

    public List<Boardgame> findAllByMinDuration(int minDuration) {
        TypedQuery<Boardgame> query = em.createQuery("select b from Boardgame b where b.duration >= :duration", Boardgame.class);
        query.setParameter("duration", minDuration);

        return query.getResultList();
    }

    public List<Boardgame> findAllByMaxDuration(int maxDuration) {
        TypedQuery<Boardgame> query = em.createQuery("select b from Boardgame b where b.duration <= :duration", Boardgame.class);
        query.setParameter("duration", maxDuration);

        return query.getResultList();
    }

    public List<Boardgame> findAllByDuration(int duration) {
        TypedQuery<Boardgame> query = em.createQuery("select b from Boardgame b where b.duration = :duration", Boardgame.class);
        query.setParameter("duration", duration);

        return query.getResultList();
    }

    public List<Boardgame> findAllByAuthor(String author) {
        TypedQuery<Boardgame> query = em.createQuery("select b from Boardgame b where b.author = :author", Boardgame.class);
        query.setParameter("author", author);

        return query.getResultList();
    }

    public List<Boardgame> findAllByEditor(String editor) {
        TypedQuery<Boardgame> query = em.createQuery("select b from Boardgame b where b.author = :editor", Boardgame.class);
        query.setParameter("editor", editor);

        return query.getResultList();
    }

}
