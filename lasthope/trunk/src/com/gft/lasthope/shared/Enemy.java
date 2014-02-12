package com.gft.lasthope.shared;

public class Enemy extends Creature {

	public Enemy criaInimigo(String raca, String classe, int level, int exp, int gold){
		Enemy inimigo = new Enemy();
		escolheRaca(raca);
		return inimigo;
	}

	public void escolheRaca(String race) {
		if (race.equals("Goblin Rogue")) {
			atualizaInimigo(0, 2, 0, 0, Dices.rollDice(4, 1)+4, 2, 0, 0.95, 1, 7, Dices.rollDice(8, 2));
		} else if (race.equals("Goblin Shaman")) {
			atualizaInimigo(1, 1, 1, 1, Dices.rollDice(4, 2)+8, 5, 1, 1, 2, 13, Dices.rollDice(6, 4));
		} else {
			race = "Goblin Soldier";
			atualizaInimigo(1, 1, 0, 0, Dices.rollDice(10, 1)+6, 3, 0, 1, 1, 5, Dices.rollDice(6, 2));
		}
	}

	public void atualizaInimigo(int forca, int dextreza, int inteligencia, int carisma, int hp, int mp, int resistencia, double velocidade, int level, int exp, int gold){
		setStrength(forca);
		setDexterity(dextreza);
		setIntellect(inteligencia);
		setCharisma(carisma);
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

/*	private String nome;
    private String raca; //ainda nao
    private String classe; //ainda nao
    private int forca=4;
    private int dextreza=1;
    private int inteligencia=1; //ainda nao
    private int carisma=1; //ainda nao
    private int hp=10;
    private int mp=10;
    private int hpMax=10;
    private int mpMax=10;
    private int defesa=10;
    private int defesaMagica=10; //ainda nao
    private long experiencia=10;
    private int level=1;
    private Arma arma;
    private int armadura;
    private double velocidade=1; //ainda nao
    private int resistencia=0; //ainda nao
    private int dinheiro=0;
    private List bolsa;
    private List talentos; //ainda nao
    private List magias; //ainda nao
    private double controladorTempo=velocidade; */

}
