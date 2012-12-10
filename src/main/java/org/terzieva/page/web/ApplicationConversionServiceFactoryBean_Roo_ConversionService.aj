// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.terzieva.page.web;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.terzieva.page.domain.Player;
import org.terzieva.page.domain.Term;
import org.terzieva.page.web.ApplicationConversionServiceFactoryBean;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    declare @type: ApplicationConversionServiceFactoryBean: @Configurable;
    
    public Converter<Player, String> ApplicationConversionServiceFactoryBean.getPlayerToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<org.terzieva.page.domain.Player, java.lang.String>() {
            public String convert(Player player) {
                return new StringBuilder().append(player.getFirstName()).toString();
            }
        };
    }
    
    public Converter<Long, Player> ApplicationConversionServiceFactoryBean.getIdToPlayerConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, org.terzieva.page.domain.Player>() {
            public org.terzieva.page.domain.Player convert(java.lang.Long id) {
                return Player.findPlayer(id);
            }
        };
    }
    
    public Converter<String, Player> ApplicationConversionServiceFactoryBean.getStringToPlayerConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, org.terzieva.page.domain.Player>() {
            public org.terzieva.page.domain.Player convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Player.class);
            }
        };
    }
    
    public Converter<Term, String> ApplicationConversionServiceFactoryBean.getTermToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<org.terzieva.page.domain.Term, java.lang.String>() {
            public String convert(Term term) {
                return new StringBuilder().append(term.getTermKey()).append(' ').append(term.getText()).toString();
            }
        };
    }
    
    public Converter<Long, Term> ApplicationConversionServiceFactoryBean.getIdToTermConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, org.terzieva.page.domain.Term>() {
            public org.terzieva.page.domain.Term convert(java.lang.Long id) {
                return Term.findTerm(id);
            }
        };
    }
    
    public Converter<String, Term> ApplicationConversionServiceFactoryBean.getStringToTermConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, org.terzieva.page.domain.Term>() {
            public org.terzieva.page.domain.Term convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Term.class);
            }
        };
    }
    
    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getPlayerToStringConverter());
        registry.addConverter(getIdToPlayerConverter());
        registry.addConverter(getStringToPlayerConverter());
        registry.addConverter(getTermToStringConverter());
        registry.addConverter(getIdToTermConverter());
        registry.addConverter(getStringToTermConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
}
