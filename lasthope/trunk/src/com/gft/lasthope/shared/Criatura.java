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
public class Criatura {

    private String name;
    private String race; //ainda nao
    private String profession; //ainda nao
    private int strength=4;
    private int dexterity=1;
    private int intellect=1; //ainda nao
    private int charisma=1; //ainda nao
    private double speed=1; //ainda nao
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
    private Arma weapon;
    //private int armadura;
    private int resist=0; //ainda nao
    //private List bolsa;
    private List feats; //ainda nao
    private List spells; //ainda nao
    private double controladorTempo=speed;

//    /**
//     * @return the name
//     */
//    public String getNome() {
//        return name;
//    }
//
//    /**
//     * @param name the name to set
//     */
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    /**
//     * @return the forca
//     */
//    public int getForca() {
//        return strength;
//    }
//
//    /**
//     * @param forca the forca to set
//     */
//    public void setForca(int forca) {
//        this.strength = forca;
//    }
//
//    /**
//     * @return the dextreza
//     */
//    public int getDextreza() {
//        return dexterity;
//    }
//
//    /**
//     * @param dextreza the dextreza to set
//     */
//    public void setDextreza(int dextreza) {
//        this.dexterity = dextreza;
//    }
//
//    /**
//     * @return the inteligencia
//     */
//    public int getInteligencia() {
//        return intellect;
//    }
//
//    /**
//     * @param inteligencia the inteligencia to set
//     */
//    public void setInteligencia(int inteligencia) {
//        this.intellect = inteligencia;
//    }
//
//    /**
//     * @return the carisma
//     */
//    public int getCarisma() {
//        return charisma;
//    }
//
//    /**
//     * @param carisma the carisma to set
//     */
//    public void setCarisma(int carisma) {
//        this.charisma = carisma;
//    }
//
//    /**
//     * @return the hp
//     */
//    public int getHp() {
//        return hp;
//    }
//
//    /**
//     * @param hp the hp to set
//     */
//    public void setHp(int hp) {
//        this.hp = hp;
//    }
//
//    /**
//     * @return the mp
//     */
//    public int getMp() {
//        return mp;
//    }
//
//    /**
//     * @param mp the mp to set
//     */
//    public void setMp(int mp) {
//        this.mp = mp;
//    }
//
//    /**
//     * @return the hpMax
//     */
//    public int getHpMax() {
//        return hpMax;
//    }
//
//    /**
//     * @param hpMax the hpMax to set
//     */
//    public void setHpMax(int hpMax) {
//        this.hpMax = hpMax;
//    }
//
//    /**
//     * @return the mpMax
//     */
//    public int getMpMax() {
//        return mpMax;
//    }
//
//    /**
//     * @param mpMax the mpMax to set
//     */
//    public void setMpMax(int mpMax) {
//        this.mpMax = mpMax;
//    }
//
//    /**
//     * @return the defesa
//     */
//    public int getDefesa() {
//        return defense;
//    }
//
//    /**
//     * @param defesa the defesa to set
//     */
//    public void setDefesa(int defesa) {
//        this.defense = defesa;
//    }
//
//    /**
//     * @return the defesaMagica
//     */
//    public int getDefesaMagica() {
//        return magicDefense;
//    }
//
//    /**
//     * @param defesaMagica the defesaMagica to set
//     */
//    public void setDefesaMagica(int defesaMagica) {
//        this.magicDefense = defesaMagica;
//    }
//
//    /**
//     * @return the experiencia
//     */
//    public long getExperiencia() {
//        return exp;
//    }
//
//    /**
//     * @param experiencia the experiencia to set
//     */
//    public void setExperiencia(long experiencia) {
//        this.exp = experiencia;
//    }
//
//    /**
//     * @return the level
//     */
//    public int getLevel() {
//        return level;
//    }
//
//    /**
//     * @param level the level to set
//     */
//    public void setLevel(int level) {
//        this.level = level;
//    }
//
//    /**
//     * @return the velocidade
//     */
//    public double getVelocidade() {
//        return speed;
//    }
//
//    /**
//     * @param velocidade the velocidade to set
//     */
//    public void setVelocidade(double velocidade) {
//        this.speed = velocidade;
//    }
//
//    /**
//     * @return the resistencia
//     */
//    public int getResistencia() {
//        return resist;
//    }
//
//    /**
//     * @param resistencia the resistencia to set
//     */
//    public void setResistencia(int resistencia) {
//        this.resist = resistencia;
//    }
//
//    /**
//     * @return the dinheiro
//     */
//    public int getDinheiro() {
//        return gold;
//    }
//
//    /**
//     * @param dinheiro the dinheiro to set
//     */
//    public void setDinheiro(int dinheiro) {
//        this.gold = dinheiro;
//    }
//
//    /**
//     * @return the bolsa
//     */
//    public List getBolsa() {
//        return bolsa;
//    }
//
//    /**
//     * @return the talentos
//     */
//    public List getTalentos() {
//        return feats;
//    }
//
//    /**
//     * @return the magias
//     */
//    public List getMagias() {
//        return spells;
//    }
//
//    /**
//     * @return the arma
//     */
//    public Arma getArma() {
//        return arma;
//    }
//
//    /**
//     * @param arma the arma to set
//     */
//    public void setArma(Arma arma) {
//        this.arma = arma;
//    }
//
//    /**
//     * @return the armadura
//     */
//    public int getArmadura() {
//        return armadura;
//    }
//
//    /**
//     * @param armadura the armadura to set
//     */
//    public void setArmadura(int armadura) {
//        this.armadura = armadura;
//    }
//
//    /**
//     * @param bolsa the bolsa to set
//     */
//    public void setBolsa(List bolsa) {
//        this.bolsa = bolsa;
//    }
//
//    /**
//     * @param talentos the talentos to set
//     */
//    public void setTalentos(List talentos) {
//        this.feats = talentos;
//    }
//
//    /**
//     * @param magias the magias to set
//     */
//    public void setMagias(List magias) {
//        this.spells = magias;
//    }
//
//    /**
//     * @return the controladorTempo
//     */
    public double getControladorTempo() {
        return controladorTempo;
    }

    /**
     * @param controladorTempo the controladorTempo to set
     */
    public void setControladorTempo(double controladorTempo) {
        this.controladorTempo = controladorTempo;
    }
//
//    /**
//     * @return the raca
//     */
//    public String getRaca() {
//        return race;
//    }
//
//    /**
//     * @param raca the raca to set
//     */
//    public void setRaca(String raca) {
//        this.race = raca;
//    }
//
//    /**
//     * @return the classe
//     */
//    public String getClasse() {
//        return profession;
//    }
//
//    /**
//     * @param classe the classe to set
//     */
//    public void setClasse(String classe) {
//        this.profession = classe;
//    }

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

	public Arma getWeapon() {
		return weapon;
	}

	public void setWeapon(Arma weapon) {
		this.weapon = weapon;
	}

	public void setName(String name) {
		this.name = name;
	}

}
