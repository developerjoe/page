// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.terzieva.page.domain;

import org.terzieva.page.domain.Area;
import org.terzieva.page.domain.AreaExit;
import org.terzieva.page.traversal.Direction;

privileged aspect AreaExit_Roo_JavaBean {
    
    public Area AreaExit.getFromArea() {
        return this.fromArea;
    }
    
    public void AreaExit.setFromArea(Area fromArea) {
        this.fromArea = fromArea;
    }
    
    public Area AreaExit.getToArea() {
        return this.toArea;
    }
    
    public void AreaExit.setToArea(Area toArea) {
        this.toArea = toArea;
    }
    
    public Direction AreaExit.getDirection() {
        return this.direction;
    }
    
    public void AreaExit.setDirection(Direction direction) {
        this.direction = direction;
    }
    
}
