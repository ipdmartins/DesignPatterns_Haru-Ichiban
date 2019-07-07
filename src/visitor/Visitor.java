/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import model.*;

/**
 *
 * @author ipdmartins
 */
public interface Visitor {
    
    void visitRedPlayer(RedPlayer redPlayer);
    
    void visitYellowPlayer(YellowPlayer yellowPlayer);
    
}
