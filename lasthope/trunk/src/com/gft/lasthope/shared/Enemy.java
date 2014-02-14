package com.gft.lasthope.shared;

import com.gft.lasthope.client.Last_Hope;

public class Enemy extends Creature {

	public Enemy() {

		atualizaInimigo("Goblin", 10, 12, 10, 10, 10, 10, 5, 0, 1, 1, 10, Dices.rollDice(4, 2));
		this.setControladorTempo(this.getSpeed());
		this.setModificators();

	}

	public Enemy criaInimigo(int idInimigo) {
		Enemy inimigo = Last_Hope.getEnemy();
		switch (idInimigo) {

		// Nome, Forc, Dex, Int, Char, Hp, Mp, Xp, Lvl, Res, Spd
		case 1:
			atualizaInimigo("Goblin", 10, 12, 10, 10, 10, 10, 5, 0, 1, 1, 10, Dices.rollDice(4, 2));
			break;
		case 2:
			atualizaInimigo("Orc", 14, 10, 10, 10, 10, 15, 5, 0, 1, 1, 20, Dices.rollDice(4, 3));
			break;
		case 3:
			atualizaInimigo("Ogro", 16, 12, 10, 10, 10, 20, 5, 1, 1, 1, 35, Dices.rollDice(4, 4));
			break;
		default:
			atualizaInimigo("Troll", 20, 14, 10, 10, 10, 10, 5, 1, 1, 1, 50, Dices.rollDice(4, 5));
			break;
		}
		//nome,forca,dextreza,inteligencia,carisma,hp,mp,resistencia,velocidade,level,exp,gold

		this.setControladorTempo(this.getSpeed());
		this.setModificators();
		return inimigo;

	}


	public void atualizaInimigo(String nome, int forca, int dextreza, int inteligencia, int carisma, int constituicao, int hp, int mp, int resistencia, double velocidade, int level, int exp, int gold){

		setStrength(forca);
		setDexterity(dextreza);
		setIntellect(inteligencia);
		setCharisma(carisma);
		setConstitution(constituicao);
		setHp(hp);
		setHpMax(hp);
		setMp(mp);
		setMpMax(mp);
		setResist(resistencia);
		setSpeed(velocidade);
		setLevel(level);
		setExp(exp);
		setGold(gold);
	}

	public void die(){
		Last_Hope.setEnemy(null);
	}

	/*
	 * private String nome; private String raca; //ainda nao private String
	 * classe; //ainda nao private int forca=4; private int dextreza=1; private
	 * int inteligencia=1; //ainda nao private int carisma=1; //ainda nao
	 * private int hp=10; private int mp=10; private int hpMax=10; private int
	 * mpMax=10; private int defesa=10; private int defesaMagica=10; //ainda nao
	 * private long experiencia=10; private int level=1; private Arma arma;
	 * private int armadura; private double velocidade=1; //ainda nao private
	 * int resistencia=0; //ainda nao private int dinheiro=0; private List
	 * bolsa; private List talentos; //ainda nao private List magias; //ainda
	 * nao private double controladorTempo=velocidade;
	 */

}
