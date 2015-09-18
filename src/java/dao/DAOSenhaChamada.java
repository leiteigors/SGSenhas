/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.SenhaChamada;

/**
 *
 * @author Igor
 */
public interface DAOSenhaChamada {

    void salvar(SenhaChamada senhaChamada) throws Exception;
    int retornaMaiorId() throws Exception;
    
    void truncate() throws Exception;
    String retornaUltimoChamado() throws Exception; 
    List retornaUltimos() throws Exception;
    String retornaPrioridadePreferencia() throws Exception;
    String retornaPrioridadeNormal() throws Exception;
}
