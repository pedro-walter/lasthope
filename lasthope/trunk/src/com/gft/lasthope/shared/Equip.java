package com.gft.lasthope.shared;

public class Equip extends Item{

	private int armorDefense;
	private String tipo;
	public int getArmorDefense() {
		return armorDefense;
	}

	public void setArmorDefense(int armorDefense) {
		this.armorDefense = armorDefense;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Equip(int id, String nome, String tipo, int defense){
        this.setId(id);
        this.setArmorDefense(defense);
        this.setNome(nome);
        this.setTipo(tipo);
    }

	public static int returnDefense(Armor a, Shield s, Boot b, Helmet h){
		int totalDefense=a.getArmorDefense()+s.getArmorDefense()+b.getArmorDefense()+h.getArmorDefense();
		return totalDefense;
	}

}
