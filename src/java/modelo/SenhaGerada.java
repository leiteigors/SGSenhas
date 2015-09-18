/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Igor
 */
public class SenhaGerada {
    private int id;
    private String nomeSenha;
    private int chamouSenha;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nomeSenha
     */
    public String getNomeSenha() {
        return nomeSenha;
    }

    /**
     * @param nomeSenha the nomeSenha to set
     */
    public void setNomeSenha(String nomeSenha) {
        this.nomeSenha = nomeSenha;
    }

    /**
     * @return the chamouSenha
     */
    public int getChamouSenha() {
        return chamouSenha;
    }

    /**
     * @param chamouSenha the chamouSenha to set
     */
    public void setChamouSenha(int chamouSenha) {
        this.chamouSenha = chamouSenha;
    }
    
    
}
