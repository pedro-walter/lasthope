package com.gft.lasthope.shared;

import com.gft.lasthope.client.Last_Hope;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JOSR
 */
public class Character extends Creature {

	private int statPoints = 0;

	public Character (String race, String classe) {

		this.setRace(race);
		this.escolheRaca(race);
		this.setProfession(classe);
		this.escolheClasse(classe);

	}

	public void evoluir(Character p) {
		p.setExp(getExp() - getLevel() * 100);
		p.setLevel(getLevel() + 1);
		p.setSpeed(p.getSpeed() - this.getModDex()/100);
		p.statPoints = statPoints + 3;
		System.out.println("Your level has been increased to " + p.getLevel());
	}

	public void morrer() {
		double xpLost = getExp() * 0.1;
		long xpLostLong = Math.round(xpLost);
		setExp(getExp() - xpLostLong);
	}

	public void ganharBatalha(Character p, long xpMonstro, int gold) {
		System.out.println("You win the battle!!!");
		p.setExp(p.getExp() + xpMonstro);
		p.setGold(p.getGold() + gold);
		p.setHp(p.getHpMax());
		if (p.getExp() >= p.getLevel() * 100) {
			evoluir(p);
		}
	}

	public void escolheClasse(String classe) {
		if (classe.equals("Archer")) {
			atualizaPersonagem(this.getStrength() + 2, this.getDexterity() + 6,
					this.getIntellect() + 0, this.getCharisma() + 0,
					this.getHpMax() + 20, this.getMpMax() + 15,
					this.getSpeed() - 0.2);

		} else if (classe.equals("Mage")) {
			atualizaPersonagem(this.getStrength() + 0, this.getDexterity() + 0,
					this.getIntellect() + 6, this.getCharisma() + 4,
					this.getHpMax() + 10, this.getMpMax() + 30, this.getSpeed());

		} else if (classe.equals("Rogue")) {
			atualizaPersonagem(this.getStrength() + 0, this.getDexterity() + 4,
					this.getIntellect() + 2, this.getCharisma() + 2,
					this.getHpMax() + 15, this.getMpMax() + 15,
					this.getSpeed() - 0.25);

		} else {
			classe = "Warrior";
			atualizaPersonagem(this.getStrength() + 4, this.getDexterity() + 2,
					this.getIntellect() + 1, this.getCharisma() + 1,
					this.getHpMax() + 30, this.getMpMax() + 10,
					this.getSpeed() - 0.1);
		}
		//return classe;
	}

	public void escolheRaca(String race) {
		if (race.equals("Elf")) {
			atualizaPersonagem(8, 12, 12, 10, 10, 10, 0.95);
		} else if (race.equals("Dwarf")) {
			atualizaPersonagem(12, 8, 10, 8, 15, 5, 1);
		} else if (race.equals("Halfling")) {
			atualizaPersonagem(8, 12, 10, 10, 5, 5, 0.9);
		} else if (race.equals("Half-Orc")) {
			atualizaPersonagem(14, 12, 8, 8, 15, 5, 1.1);
		} else {
			race = "Human";
			atualizaPersonagem(10, 10, 10, 10, 10, 5, 1);
		}
		//return race;
	}

	public void atualizaPersonagem(int forca, int dext, int inte, int caris,
			int hpMax, int mpMax, double velocidade) {
		this.setStrength(forca);
		this.setDexterity(dext);
		this.setIntellect(inte);
		this.setCharisma(caris);
		this.setHpMax(hpMax);
		this.setHp(hpMax);
		this.setMpMax(mpMax);
		this.setMp(mpMax);
		this.setSpeed(velocidade);
	}

	public int updateDefense() {
		int totalDefense = getBaseDefense()
				+ Equip.returnDefense(getArmor(), getShield(), getBoot(),
						getHelmet());
		return totalDefense;
	}

	public void calculaHp(){
		if (this.getClass().equals("Archer")){
			this.setHpMax(this.getHpMax()+Dices.rollDice(8, 1)+this.getModCon());
		}else if (this.getClass().equals("Mage")){
			this.setHpMax(this.getHpMax()+Dices.rollDice(4, 1)+this.getModCon());
		}else if (this.getClass().equals("Rogue")){
			this.setHpMax(this.getHpMax()+Dices.rollDice(6, 1)+this.getModCon());
		}else {
			this.setHpMax(this.getHpMax()+Dices.rollDice(6, 2)+this.getModCon());
		}

	}



}
