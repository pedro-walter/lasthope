package com.gft.lasthope.client;

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

    private String nome;
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
    private double controladorTempo=velocidade;

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
     * @return the forca
     */
    public int getForca() {
        return forca;
    }

    /**
     * @param forca the forca to set
     */
    public void setForca(int forca) {
        this.forca = forca;
    }

    /**
     * @return the dextreza
     */
    public int getDextreza() {
        return dextreza;
    }

    /**
     * @param dextreza the dextreza to set
     */
    public void setDextreza(int dextreza) {
        this.dextreza = dextreza;
    }

    /**
     * @return the inteligencia
     */
    public int getInteligencia() {
        return inteligencia;
    }

    /**
     * @param inteligencia the inteligencia to set
     */
    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    /**
     * @return the carisma
     */
    public int getCarisma() {
        return carisma;
    }

    /**
     * @param carisma the carisma to set
     */
    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    /**
     * @return the hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * @param hp the hp to set
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * @return the mp
     */
    public int getMp() {
        return mp;
    }

    /**
     * @param mp the mp to set
     */
    public void setMp(int mp) {
        this.mp = mp;
    }

    /**
     * @return the hpMax
     */
    public int getHpMax() {
        return hpMax;
    }

    /**
     * @param hpMax the hpMax to set
     */
    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    /**
     * @return the mpMax
     */
    public int getMpMax() {
        return mpMax;
    }

    /**
     * @param mpMax the mpMax to set
     */
    public void setMpMax(int mpMax) {
        this.mpMax = mpMax;
    }

    /**
     * @return the defesa
     */
    public int getDefesa() {
        return defesa;
    }

    /**
     * @param defesa the defesa to set
     */
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    /**
     * @return the defesaMagica
     */
    public int getDefesaMagica() {
        return defesaMagica;
    }

    /**
     * @param defesaMagica the defesaMagica to set
     */
    public void setDefesaMagica(int defesaMagica) {
        this.defesaMagica = defesaMagica;
    }

    /**
     * @return the experiencia
     */
    public long getExperiencia() {
        return experiencia;
    }

    /**
     * @param experiencia the experiencia to set
     */
    public void setExperiencia(long experiencia) {
        this.experiencia = experiencia;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the velocidade
     */
    public double getVelocidade() {
        return velocidade;
    }

    /**
     * @param velocidade the velocidade to set
     */
    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    /**
     * @return the resistencia
     */
    public int getResistencia() {
        return resistencia;
    }

    /**
     * @param resistencia the resistencia to set
     */
    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    /**
     * @return the dinheiro
     */
    public int getDinheiro() {
        return dinheiro;
    }

    /**
     * @param dinheiro the dinheiro to set
     */
    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    /**
     * @return the bolsa
     */
    public List getBolsa() {
        return bolsa;
    }

    /**
     * @return the talentos
     */
    public List getTalentos() {
        return talentos;
    }

    /**
     * @return the magias
     */
    public List getMagias() {
        return magias;
    }

    /**
     * @return the arma
     */
    public Arma getArma() {
        return arma;
    }

    /**
     * @param arma the arma to set
     */
    public void setArma(Arma arma) {
        this.arma = arma;
    }

    /**
     * @return the armadura
     */
    public int getArmadura() {
        return armadura;
    }

    /**
     * @param armadura the armadura to set
     */
    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    /**
     * @param bolsa the bolsa to set
     */
    public void setBolsa(List bolsa) {
        this.bolsa = bolsa;
    }

    /**
     * @param talentos the talentos to set
     */
    public void setTalentos(List talentos) {
        this.talentos = talentos;
    }

    /**
     * @param magias the magias to set
     */
    public void setMagias(List magias) {
        this.magias = magias;
    }

    /**
     * @return the controladorTempo
     */
    public double getControladorTempo() {
        return controladorTempo;
    }

    /**
     * @param controladorTempo the controladorTempo to set
     */
    public void setControladorTempo(double controladorTempo) {
        this.controladorTempo = controladorTempo;
    }

    /**
     * @return the raca
     */
    public String getRaca() {
        return raca;
    }

    /**
     * @param raca the raca to set
     */
    public void setRaca(String raca) {
        this.raca = raca;
    }

    /**
     * @return the classe
     */
    public String getClasse() {
        return classe;
    }

    /**
     * @param classe the classe to set
     */
    public void setClasse(String classe) {
        this.classe = classe;
    }

}
