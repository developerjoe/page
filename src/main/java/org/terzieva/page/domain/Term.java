package org.terzieva.page.domain;

import javax.persistence.Column;
import javax.persistence.NoResultException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findTermsByTermKeyEquals" })
public class Term {

    @NotNull
    @Column(unique = true)
    private String termKey;

    @NotNull
    @Size(max = 3000)
    private String text;
    
    public static String textFromKey(String key)
    {
		try
		{
			return Term.findTermsByTermKeyEquals(key).getSingleResult().getText();
		}
		catch(NoResultException e)
		{
			return "";
		}
    }
}
