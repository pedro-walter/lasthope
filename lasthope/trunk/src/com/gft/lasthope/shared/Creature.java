package com.gft.lasthope.shared;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;

/**
 *
 * @author JOSR
 */
public class Creature {

    private String name;
    private String race;
    private String profession;
    private int strength=4;
    private int dexterity=1;
    private int intellect=1; //ainda nao
    private int charisma=1; //ainda nao
    private double speed=1;
    private int hp=10;
    private int mp=10;
    private int hpMax=10;
    private int mpMax=10;
    private int defense=10;
    private int magicDefense=10; //ainda nao
    private int baseDefense;
    private long exp=10;
    private int gold=0;
    private int level=1;
    private Weapon weapon;
    private Helmet helmet;
    private Armor armor;
    private Boot boot;
    private Shield shield;
	private int resist=0;
    //private List bolsa;
    private List feats; //ainda nao
    private List spells; //ainda nao
    private double controladorTempo=speed;

    public double getControladorTempo() {
        return controladorTempo;
    }

    /**
     * @param controladorTempo the controladorTempo to set
     */
    public void setControladorTempo(double controladorTempo) {
        this.controladorTempo = controladorTempo;
    }

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getIntellect() {
		return intellect;
	}

	public void setIntellect(int intellect) {
		this.intellect = intellect;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getMagicDefense() {
		return magicDefense;
	}

	public void setMagicDefense(int magicDefense) {
		this.magicDefense = magicDefense;
	}

	public int getBaseDefense() {
		return baseDefense;
	}

	public void setBaseDefense(int baseDefense) {
		this.baseDefense = baseDefense;
	}

	public long getExp() {
		return exp;
	}

	public void setExp(long exp) {
		this.exp = exp;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getResist() {
		return resist;
	}

	public void setResist(int resist) {
		this.resist = resist;
	}

	public List getFeats() {
		return feats;
	}

	public void setFeats(List feats) {
		this.feats = feats;
	}

	public List getSpells() {
		return spells;
	}

	public void setSpells(List spells) {
		this.spells = spells;
	}

	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getHpMax() {
		return hpMax;
	}

	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}

	public int getMpMax() {
		return mpMax;
	}

	public void setMpMax(int mpMax) {
		this.mpMax = mpMax;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public void setName(String name) {
		this.name = name;
	}

    public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public Helmet getHelmet() {
		return helmet;
	}

	public void setHelmet(Helmet helmet) {
		this.helmet = helmet;
	}

	public Boot getBoot() {
		return boot;
	}

	public void setBoot(Boot boot) {
		this.boot = boot;
	}

	public Shield getShield() {
		return shield;
	}

	public void setShield(Shield shield) {
		this.shield = shield;
	}

}
