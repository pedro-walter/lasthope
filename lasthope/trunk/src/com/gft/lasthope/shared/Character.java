package com.gft.lasthope.shared;

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

    public Character() {

    }

    public void evoluir(Character p) {
        p.setExp(getExp() - getLevel() * 100);
        p.setLevel(getLevel() + 1);
        p.setSpeed(p.getSpeed()-0.04);
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
        p.setGold(p.getGold()+gold);
        p.setHp(p.getHpMax());
        if (p.getExp() >= p.getLevel() * 100) {
            evoluir(p);
        }
    }

    public Character criaPersonagem(String race, String classe) {
        Character p = new Character();
        p.setRace(escolheRaca(p, race));
        p.setProfession(escolheClasse(classe));

        return p;
    }

    public String escolheClasse(String classe) {
        //default
    	//String classe="Warrior";
        switch (classe) {
            case "Warrior":
                atualizaPersonagem(this.getStrength() + 4, this.getDexterity() + 2, this.getIntellect() + 1, this.getCharisma() + 1, this.getHpMax() + 30, this.getMpMax() + 10, this.getSpeed() - 0.1);
                break;
            case "Archer":
                atualizaPersonagem(this.getStrength() + 1, this.getDexterity() + 4, this.getIntellect() + 1, this.getCharisma() + 2, this.getHpMax() + 20, this.getMpMax() + 15, this.getSpeed() - 0.2);
                break;
            case "Mage":
                atualizaPersonagem(this.getStrength() + 1, this.getDexterity() + 1, this.getIntellect() + 4, this.getCharisma() + 2, this.getHpMax() + 10, this.getMpMax() + 30, this.getSpeed());
                break;
            case "Rogue":
                atualizaPersonagem(this.getStrength() + 2, this.getDexterity() + 2, this.getIntellect() + 1, this.getCharisma() + 1, this.getHpMax() + 15, this.getMpMax() + 15, this.getSpeed() - 0.25);
                break;
            default:
                classe = "Warrior";
                atualizaPersonagem(this.getStrength() + 4, this.getDexterity() + 2, this.getIntellect() + 1, this.getCharisma() + 1, this.getHpMax() + 30, this.getMpMax() + 10, this.getSpeed() - 0.1);
                break;
        }
        return classe;
    }

    public String escolheRaca(Character p, String race) {
        //String raca="Human";
        switch (race) {
            case "Human":
                atualizaPersonagem(1, 1, 1, 1, 10, 5, 1);
                break;
            case "Elf":
                atualizaPersonagem(0, 2, 1, 0, 10, 5, 0.95);
                break;
            case "Dwarf":
                atualizaPersonagem(2, 0, 0, 0, 15, 5, 1);
                break;
            case "Halfling":
                atualizaPersonagem(0, 2, 0, 0, 5, 5, 0.9);
                break;
            default:
                race = "Human";
                atualizaPersonagem(1, 1, 1, 1, 10, 5, 1);
                break;
        }
        return race;
    }

    public void atualizaPersonagem(int forca, int dext, int inte, int caris, int hpMax, int mpMax, double velocidade) {
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

    public int updateDefense(){
    	int totalDefense=getBaseDefense()+Equip.returnDefense(getArmor(), getShield(), getBoot(), getHelmet());
    	return totalDefense;
    }

}
