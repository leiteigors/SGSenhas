/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.SenhaChamada;
import modelo.SenhaGerada;
import util.Conexao;

/**
 *
 * @author Igor
 */
public class SenhaGeradaDAOImp implements DAOSenhaGerada {

        private Connection conn;
    
    public SenhaGeradaDAOImp() throws Exception {
        try {
            this.conn = Conexao.getConnection();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    @Override
    public void salvar(SenhaGerada senhaGerada) throws Exception {
        
        PreparedStatement ps = null;
        Connection conn = null;
        
        if (senhaGerada == null) throw new Exception("");
        try{
//            String SQL = "INSERT INTO sgs.tab_sen_geradas (`ID_SEN_GER`, `NM_SEN_GER`, `CHAMADA_SEN_GER`) \n" +
//"	VALUES (?, ?, ?)";
            String SQL = "INSERT INTO tab_sen_geradas (ID_SEN_GER, NM_SEN_GER, CHAMADA_SEN_GER) \n" +
"	VALUES (?, ?, ?)";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, senhaGerada.getId());
            ps.setString(2, senhaGerada.getNomeSenha());
            ps.setInt(3, senhaGerada.getChamouSenha());
            ps.executeUpdate();
        }
        catch(Exception e) {
            throw new Exception("");
        }
    }

    public int retornaMaiorId() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
        try{
            conn = this.conn;
            //ps = conn.prepareStatement("select max(id_sen_ger) as maximo from sgs.tab_sen_geradas");
            ps = conn.prepareStatement("select max(id_sen_ger) as maximo from tab_sen_geradas");
            rs = ps.executeQuery();
            Integer id = 0;
            while(rs.next()) {
                id = (rs.getInt(1) + 1);           
            }
            return id;
        }
        catch(Exception e) {
            throw new Exception("");
        }
    
    }
    
    public void truncate() throws Exception {

        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = this.conn;
            //ps = conn.prepareStatement("TRUNCATE TABLE sgs.tab_sen_geradas");
            ps = conn.prepareStatement("TRUNCATE TABLE tab_sen_geradas");
            ps.executeUpdate();
        }
        catch(Exception e) {
            throw new Exception("");
        }
    }
    
    public int retornaMaiorPreferencial() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Integer id = 0;
            
        try{
            conn = this.conn;
            //ps = conn.prepareStatement("select max(substring(nm_sen_ger,2,4)) as ListaPreferencial from sgs.tab_sen_geradas where substring(nm_sen_ger,1,1) = 'P'");
            ps = conn.prepareStatement("select max(substring(nm_sen_ger,2,4)) as ListaPreferencial from tab_sen_geradas where substring(nm_sen_ger,1,1) = 'P'");
            rs = ps.executeQuery();
            //ArrayList<Integer> listaPreferencial = new ArrayList<Integer>();
            while (rs.next()) {
                if (rs.getString(1) != null) {
                    id = Integer.parseInt(rs.getString(1).trim());    
                } else {
                    return 0;
                }
            }
        }catch(Exception e) {
                    throw new Exception("");
                    }
        return id;
    }
    
        public int retornaMaiorNormal() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Integer id = 0;
            
        try{
            conn = this.conn;
            //ps = conn.prepareStatement("select max(substring(nm_sen_ger,2,4)) as ListaPreferencial from sgs.tab_sen_geradas where substring(nm_sen_ger,1,1) = 'N'");
            ps = conn.prepareStatement("select max(substring(nm_sen_ger,2,4)) as ListaPreferencial from tab_sen_geradas where substring(nm_sen_ger,1,1) = 'N'");
            rs = ps.executeQuery();
            //ArrayList<Integer> listaPreferencial = new ArrayList<Integer>();
            while (rs.next()) {
                if (rs.getString(1) != null) {
                    id = Integer.parseInt(rs.getString(1).trim());    
                } else {
                    return 0;
                }
            }
        }catch(Exception e) {
                    throw new Exception("");
                    }
        return id;
    }

}