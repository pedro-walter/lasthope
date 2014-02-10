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

    public Map listWeapons = new HashMap<>();
    public Map listArmors = new HashMap<>();
    public Map listShields = new HashMap<>();
    public Map listHelmets = new HashMap<>();
    public Map listBoots = new HashMap<>();
    private int id;
    private String nome;
    private double price;

    public void updateWeapons() {

        Weapon am = new Weapon(1,1,2,1,"Dagger","Physical");
        listWeapons.put(1, am);

        am = new Weapon(2,2,2,2,"Sword","Physical");
        listWeapons.put(2, am);

    }

    public void updateArmors() {

        Armor ar = new Armor(21,"Leather Armor","Light",2);
        listArmors.put(1, ar);

        ar = new Armor(22,"Steel Armor","Medium",3);
        listArmors.put(2, ar);

    }

    public void updateHelmets() {

        Helmet ar = new Helmet(21,"Leather Helmet","Light",1);
        listHelmets.put(1, ar);

        ar = new Helmet(22,"Steel Helmet","Medium",2);
        listHelmets.put(2, ar);

    }

    public void updateBoots() {

        Boot ar = new Boot(21,"Leather Boots","Light",1);
        listBoots.put(1, ar);

        ar = new Boot(22,"Steel Boots","Medium",2);
        listBoots.put(2, ar);

    }

    public void updateShields() {

        Shield ar = new Shield(21,"Wooden Shield","Light",2);
        listShields.put(1, ar);

        ar = new Shield(22,"Steel Shield","Medium",3);
        listShields.put(2, ar);

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