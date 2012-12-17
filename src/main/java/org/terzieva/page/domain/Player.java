package org.terzieva.page.domain;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findPlayersByEmailEquals", "findPlayersByCurrentArea", "findPlayersByConnectionIdEquals" })
public class Player {

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String firstName;

    @ManyToOne
    private Area currentArea;

    private Boolean isOnline;

    private String connectionId;

    public Player() {
        email = "";
        firstName = "";
    }

    public static org.terzieva.page.domain.Player findByEmail(String email) {
        try {
            return Player.findPlayersByEmailEquals(email).getSingleResult();
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (NoResultException e) {
            return null;
        }
    }

    public static TypedQuery<org.terzieva.page.domain.Player> findNearbyOnlinePlayers(org.terzieva.page.domain.Player player) {
        if (player == null) throw new IllegalArgumentException("The player argument is required");
        EntityManager em = Player.entityManager();
        TypedQuery<Player> q = em.createQuery("SELECT o FROM Player AS o WHERE o.currentArea = :currentArea and isOnline = 1 and o.id != :id", Player.class);
        q.setParameter("currentArea", player.getCurrentArea());
        q.setParameter("id", player.getId());
        return q;
    }
}
