package com.gft.lasthope.shared;

import java.util.List;

public class Inimigo extends Criatura {

	public Inimigo criaInimigo(int idInimigo){
		Inimigo inimigo = new Inimigo();
		switch(idInimigo){
		//Nome, Forc, Dex, Int, Char, Hp, Mp, Xp, Lvl, Res, Spd
		case 1: atualizaInimigo("Goblin", 1, 1, 1, 1, 10, 5, 10, 1, 0, 1);
			break;
		case 2:atualizaInimigo("Kobold", 1, 2, 1, 1, 15, 5, 15, 1, 0, 1);
			break;
		case 3:atualizaInimigo("Orc", 3, 1, 1, 1, 20, 5, 23, 1, 1, 1);
			break;
		default:atualizaInimigo("Goblin", 1, 1, 1, 1, 10, 5, 10, 1, 0, 1);
			break;
		}
		return inimigo;
	}

	public void atualizaInimigo(String nome, int forca, int dextreza, int inteligencia, int carisma, int hp, int mp, int exp, int level, int resistencia, double velocidade){
		setName(nome);
		setStrength(forca);
		setDexterity(dextreza);
		setIntellect(inteligencia);
		setCharisma(carisma);
		setHp(hp);
		setHpMax(hp);
		setMp(mp);
		setMpMax(mp);
		setExp(exp);
		setLevel(level);
		setResist(resistencia);
		setSpeed(velocidade);
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
