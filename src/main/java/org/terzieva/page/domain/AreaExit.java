package org.terzieva.page.domain;

import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.terzieva.page.traversal.Direction;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class AreaExit {

    @OneToOne
    private Area fromArea;

    @OneToOne
    private Area toArea;

    @NotNull
    @Enumerated
    private Direction direction;
}
