/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.SenhaGerada;

/**
 *
 * @author Igor
 */
public interface DAOSenhaGerada {

    void salvar(SenhaGerada senhaGerada) throws Exception;
    int retornaMaiorId() throws Exception;
    
    void truncate() throws Exception;
    int retornaMaiorPreferencial() throws Exception;
    int retornaMaiorNormal() throws Exception; 
    
}
