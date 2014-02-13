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
public class Weapon extends Item{

    private int criticalRate;
    private int criticalMultiplier;
    private int dadoArma;
    private int qtd;
	private String tipo;


    public Weapon(int id, int qtd, int dadoArma, int criticalMultiplier, int criticalRate, String nome, String tipo){
        this.setId(id);
        this.setDadoArma(dadoArma);
        this.setQtd(qtd);
        this.setCriticalMultiplier(criticalMultiplier);
        this.setCriticalRate(criticalRate);
        this.setNome(nome);
        this.setTipo(tipo);
    }

    public int calculaDano(int attPersonagem, int face, int qtd) {
        int dano;
        dano = Dices.rollDice(face, qtd) + attPersonagem;
        return dano;
    }

    /**
     * @return the criticalRate
     */
    public int getCriticalRate() {
        return criticalRate;
    }

    /**
     * @param criticalRate the criticalRate to set
     */
    public void setCriticalRate(int criticalRate) {
        this.criticalRate = criticalRate;
    }

    /**
     * @return the criticalMultiplier
     */
    public int getCriticalMultiplier() {
        return criticalMultiplier;
    }

    /**
     * @param criticalMultiplier the criticalMultiplier to set
     */
    public void setCriticalMultiplier(int criticalMultiplier) {
        this.criticalMultiplier = criticalMultiplier;
    }

    /**
     * @return the dadoArma
     */
    public int getDadoArma() {
        return dadoArma;
    }

    /**
     * @param dadoArma the dadoArma to set
     */
    public void setDadoArma(int dadoArma) {
        this.dadoArma = dadoArma;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

}
