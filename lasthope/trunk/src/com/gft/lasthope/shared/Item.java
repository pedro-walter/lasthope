package com.gft.lasthope.shared;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author JOSR
 */
public class Item {

    public Map listaArmas = new HashMap<>();
    private int id;
    private String nome;
    private double price;

    public void atualizaArmas() {

        Arma am = new Arma(1,1,2,1,"Adaga","Fisica");
        listaArmas.put(1, am);

        am = new Arma(2,2,2,2,"Espada","Fisica");
        listaArmas.put(2, am);

    }

        /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
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
    public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}