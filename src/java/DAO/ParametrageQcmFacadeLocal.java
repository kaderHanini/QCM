/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.ParametrageQcm;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kader
 */
@Local
public interface ParametrageQcmFacadeLocal {

    void create(ParametrageQcm parametrageQcm);

    void edit(ParametrageQcm parametrageQcm);

    void remove(ParametrageQcm parametrageQcm);

    ParametrageQcm find(Object id);

    List<ParametrageQcm> findAll();

    List<ParametrageQcm> findRange(int[] range);

    int count();
    
}
