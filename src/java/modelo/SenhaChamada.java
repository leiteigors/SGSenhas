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
public class SenhaChamada {
    private int id;
    private String nomeChamado;

    public SenhaChamada(int id, String nomeChamado) {
        this.id = id;
        this.nomeChamado = nomeChamado;
    }
    
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
     * @return the nomeChamado
     */
    public String getNomeChamado() {
        return nomeChamado;
    }

    /**
     * @param nomeChamado the nomeChamado to set
     */
    public void setNomeChamado(String nomeChamado) {
        this.nomeChamado = nomeChamado;
    }
    
    
}
