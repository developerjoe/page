// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.terzieva.page.domain;

import org.terzieva.page.domain.Area;
import org.terzieva.page.domain.Player;

privileged aspect Player_Roo_JavaBean {
    
    public String Player.getEmail() {
        return this.email;
    }
    
    public void Player.setEmail(String email) {
        this.email = email;
    }
    
    public String Player.getFirstName() {
        return this.firstName;
    }
    
    public void Player.setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public Area Player.getCurrentArea() {
        return this.currentArea;
    }
    
    public void Player.setCurrentArea(Area currentArea) {
        this.currentArea = currentArea;
    }
    
    public Boolean Player.getIsOnline() {
        return this.isOnline;
    }
    
    public void Player.setIsOnline(Boolean isOnline) {
        this.isOnline = isOnline;
    }
    
    public String Player.getConnectionId() {
        return this.connectionId;
    }
    
    public void Player.setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }
    
}
