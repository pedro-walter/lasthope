package com.gft.lasthope.shared;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;

/**
 *
 * @author JOSR
 */
public class Item {

	public HashMap<Integer, Weapon> listWeapons = new HashMap<Integer, Weapon>();
    public HashMap<Integer, Armor> listArmors = new HashMap<Integer, Armor>();
    public HashMap<Integer, Shield> listShields = new HashMap<Integer, Shield>();
    public HashMap<Integer, Helmet> listHelmets = new HashMap<Integer, Helmet>();
    public HashMap<Integer, Boot> listBoots = new HashMap<Integer, Boot>();

    private int id;
    private String nome;
    private double price;

    public void updateWeapons() {

        Weapon am = new Weapon(1,1,4,2,1,"Dagger","Physical");
        listWeapons.put(1, am);

        am = new Weapon(2,1,6,2,2,"Sword","Physical");
        listWeapons.put(2, am);

    }

    public void updateArmors() {

        Armor ar = new Armor(3,"Leather Armor","Light",2);
        listArmors.put(1, ar);

        ar = new Armor(4,"Steel Armor","Medium",3);
        listArmors.put(2, ar);

    }

    public void updateHelmets() {

        Helmet ar = new Helmet(5,"Leather Helmet","Light",1);
        listHelmets.put(1, ar);

        ar = new Helmet(6,"Steel Helmet","Medium",2);
        listHelmets.put(2, ar);

    }

    public void updateBoots() {

        Boot ar = new Boot(7,"Leather Boots","Light",1);
        listBoots.put(1, ar);

        ar = new Boot(8,"Steel Boots","Medium",2);
        listBoots.put(2, ar);

    }

    public void updateShields() {

        Shield ar = new Shield(9,"Wooden Shield","Light",2);
        listShields.put(1, ar);

        ar = new Shield(10,"Steel Shield","Medium",3);
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