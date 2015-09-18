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
import util.Conexao;

/**
 *
 * @author Igor
 */

public class SenhaChamadaDAOImp implements DAOSenhaChamada  {
   
    private Connection conn;
    
    public SenhaChamadaDAOImp() throws Exception {
        try {
            this.conn = Conexao.getConnection();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    @Override
    public List retornaUltimos() throws Exception {
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
        try{
            conn = this.conn;
            //ps = conn.prepareStatement("select * from sgs.tab_sen_chamadas");
            ps = conn.prepareStatement("select * from tab_sen_chamadas");
            rs = ps.executeQuery();
            List<SenhaChamada> list = new ArrayList<SenhaChamada>();
            while(rs.next()) {
                Integer id = rs.getInt(1);
                String  nome = rs.getString(2);
                
                list.add(new SenhaChamada(id, nome));                
            }
            return list;
        }
        catch(Exception e) {
            throw new Exception("");
        }
    }
    
    public String retornaUltimoChamado() throws Exception {
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
        try{
            conn = this.conn;
            //ps = conn.prepareStatement("SELECT NM_SEN_CHA FROM sgs.tab_sen_chamadas ORDER BY id_sen_cha desc limit 1");
            ps = conn.prepareStatement("SELECT NM_SEN_CHA FROM tab_sen_chamadas ORDER BY id_sen_cha desc limit 1");
            rs = ps.executeQuery();
            //List<SenhaChamada> list = new ArrayList<SenhaChamada>();
            String  nome = null;
            while(rs.next()) {
                //Integer id = rs.getInt(1);
                nome = rs.getString(1);
                
              //  list.add(new SenhaChamada(id, nome));                
            }
            return nome;
        }
        catch(Exception e) {
            throw new Exception("");
        }
    }
   
    public String retornaPrioridadePreferencia() throws Exception {
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
        try{
            conn = this.conn;
//            ps = conn.prepareStatement("select min(id_sen_ger) as id,nm_sen_ger\n" +
//"from sgs.tab_sen_geradas\n" +
//"where substring(NM_SEN_GER,1,1) = \"P\"\n" +
//"and nm_sen_ger not in (\n" +
//"select nm_sen_cha\n" +
//"from sgs.tab_sen_chamadas\n" +
//") ");
            ps = conn.prepareStatement("select min(nm_sen_ger) as id\n" +
"from tab_sen_geradas\n" +
"where substring(NM_SEN_GER,1,1) = \'P\'\n" +
"and nm_sen_ger not in (\n" +
"select nm_sen_cha\n" +
"from tab_sen_chamadas\n" +
") ");
            rs = ps.executeQuery();
            String nome = null;
            if(rs.next()) {
                //Integer id = rs.getInt(1);
                nome = rs.getString(1);     
                return nome;
            }else {
                nome = null;
                return nome;
            }
        }
        catch(Exception e) {
            throw new Exception("");
        } 
}
    
    public String retornaPrioridadeNormal() throws Exception {
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
        try{
            conn = this.conn;
//            ps = conn.prepareStatement("select min(id_sen_ger) as id,nm_sen_ger\n" +
//"from sgs.tab_sen_geradas\n" +
//"where substring(NM_SEN_GER,1,1) = \"N\"\n" +
//"and nm_sen_ger not in (\n" +
//"select nm_sen_cha\n" +
//"from sgs.tab_sen_chamadas\n" +
//") ");
            ps = conn.prepareStatement("select min(nm_sen_ger) as id\n" +
"from tab_sen_geradas\n" +
"where substring(NM_SEN_GER,1,1) = \'N\'\n" +
"and nm_sen_ger not in (\n" +
"select nm_sen_cha\n" +
"from tab_sen_chamadas\n" +
") ");
            rs = ps.executeQuery();
            String nome = null;
            if(rs.next()) {
                //Integer id = rs.getInt(1);
                nome = rs.getString(1);     
                return nome;
            }else {
                nome = null;
                return nome;
            }
        }
        catch(Exception e) {
            throw new Exception("");
        } 
}
    public void salvar(SenhaChamada mySenhaChamada) throws Exception{
        PreparedStatement ps = null;
        Connection conn = null;
        
        if (mySenhaChamada == null) throw new Exception(""); 
        try{
//            String SQL = "INSERT INTO sgs.tab_sen_chamadas (`ID_SEN_CHA`, `NM_SEN_CHA`) \n" +
//"	VALUES (?, ?)";
            String SQL = "INSERT INTO tab_sen_chamadas (ID_SEN_CHA, NM_SEN_CHA) \n" +
"	VALUES (?, ?)";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, mySenhaChamada.getId());
            ps.setString(2, mySenhaChamada.getNomeChamado());
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
            //ps = conn.prepareStatement("select max(id_sen_cha) as maximo from sgs.tab_sen_chamadas");
            ps = conn.prepareStatement("select max(id_sen_cha) as maximo from tab_sen_chamadas");
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
            //ps = conn.prepareStatement("TRUNCATE TABLE sgs.tab_sen_chamadas");
            ps = conn.prepareStatement("TRUNCATE TABLE tab_sen_chamadas");
            ps.executeUpdate();
        }
        catch(Exception e) {
            throw new Exception("");
        }
    }
}

