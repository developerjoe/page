package org.terzieva.page.domain;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.NoResultException;
import javax.validation.constraints.NotNull;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findPlayersByEmailEquals" })
public class Player {

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String firstName;

    @ManyToOne
    private Area currentArea;

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
}
