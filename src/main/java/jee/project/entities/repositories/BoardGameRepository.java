package jee.project.entities.repositories;

import jee.project.entities.items.BoardGame;
import org.springframework.data.repository.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@org.springframework.stereotype.Repository
public class BoardGameRepository implements Repository<BoardGame, Long> {
    @PersistenceContext
    private EntityManager em;


    public BoardGame findOne(int id) {
        return em.find(BoardGame.class, id);
    }

    public BoardGame save(BoardGame boardGame) {
        if (findOne(boardGame.getId()) == null) {
            em.persist(boardGame);
            return boardGame;
        } else {
            return em.merge(boardGame);
        }
    }

    public BoardGame findByTitle(String title) {
        if (title == null) return null;
        TypedQuery<BoardGame> query = em.createQuery("select b from BoardGame b where b.title = :title", BoardGame.class);
        query.setParameter("title", title);

        return query.getSingleResult();
    }

    public List<BoardGame> findAllByMinAgeRestriction(int min) {
        TypedQuery<BoardGame> query = em.createQuery("select b from BoardGame b where b.ageMin >= :min", BoardGame.class);
        query.setParameter("min", min);

        return query.getResultList();
    }

    public List<BoardGame> findAllByAgeRestriction(int min, int max) {
        if (min >= max) return null;
        TypedQuery<BoardGame> query = em.createQuery("select b from BoardGame b where b.ageMin >= :min and b.ageMax <= :max", BoardGame.class);
        query.setParameter("min", min);
        query.setParameter("max", max);

        return query.getResultList();
    }

    public List<BoardGame> findAllByMinPlayers(int min) {
        TypedQuery<BoardGame> query = em.createQuery("select b from BoardGame b where b.minPlayers >= :min", BoardGame.class);
        query.setParameter("min", min);

        return query.getResultList();
    }

    public List<BoardGame> findAllByMaxPlayers(int max) {
        TypedQuery<BoardGame> query = em.createQuery("select b from BoardGame b where b.maxPlayers <= :max", BoardGame.class);
        query.setParameter("max", max);

        return query.getResultList();
    }

    public List<BoardGame> findAllByPlayersRestriction(int min, int max) {
        if (min > max) return null;
        TypedQuery<BoardGame> query = em.createQuery("select b from BoardGame b where b.minPlayers >= :min and b.maxPlayers <= :max", BoardGame.class);
        query.setParameter("min", min);
        query.setParameter("max", max);

        return query.getResultList();
    }

    public List<BoardGame> findAllByMinDuration(int minDuration) {
        TypedQuery<BoardGame> query = em.createQuery("select b from BoardGame b where b.duration >= :duration", BoardGame.class);
        query.setParameter("duration", minDuration);

        return query.getResultList();
    }

    public List<BoardGame> findAllByMaxDuration(int maxDuration) {
        TypedQuery<BoardGame> query = em.createQuery("select b from BoardGame b where b.duration <= :duration", BoardGame.class);
        query.setParameter("duration", maxDuration);

        return query.getResultList();
    }

    public List<BoardGame> findAllByDuration(int duration) {
        TypedQuery<BoardGame> query = em.createQuery("select b from BoardGame b where b.duration = :duration", BoardGame.class);
        query.setParameter("duration", duration);

        return query.getResultList();
    }

// TODO : implement joined tables
//    public List<BoardGame> findAllByBoardGameGenre(BoardGameGenre genre) {
//        TypedQuery<BoardGame> query = em.createQuery("select b from BoardGame b join ", BoardGame.class);
//        query.setParameter("genre", genre);
//
//        return query.getResultList();
//    }

    public List<BoardGame> findAllByAuthor(String author) {
        TypedQuery<BoardGame> query = em.createQuery("select b from BoardGame b where b.author = :author", BoardGame.class);
        query.setParameter("author", author);

        return query.getResultList();
    }

    public List<BoardGame> findAllByEditor(String editor) {
        TypedQuery<BoardGame> query = em.createQuery("select b from BoardGame b where b.author = :editor", BoardGame.class);
        query.setParameter("editor", editor);

        return query.getResultList();
    }

}
