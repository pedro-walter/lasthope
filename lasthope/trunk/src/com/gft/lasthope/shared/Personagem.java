package com.gft.lasthope.shared;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JOptionPane;

/**
 *
 * @author JOSR
 */
public class Personagem extends Criatura {

    private int statPoints = 0;

    public Personagem() {

    }

    public void evoluir(Personagem p) {
        p.setExp(getExp() - getLevel() * 100);
        p.setLevel(getLevel() + 1);
        p.setSpeed(p.getSpeed()-0.04);
        p.statPoints = statPoints + 3;
        System.out.println("Voce evoluiu para o level " + p.getLevel());
    }

    public void morrer() {
        double xpLost = getExp() * 0.1;
        long xpLostLong = Math.round(xpLost);
        setExp(getExp() - xpLostLong);
    }

    public void ganharBatalha(Personagem p, long xpMonstro) {
        System.out.println("Voce ganhou a batalha!!!");
        p.setExp(p.getExp() + xpMonstro);
        p.setHp(p.getHpMax());
        if (p.getExp() >= p.getLevel() * 100) {
            evoluir(p);
        }
    }

    public Personagem criaPersonagem() {
        Personagem p = new Personagem();
  //      p.setNome(JOptionPane.showInputDialog("Nome do personagem: "));
        p.setProfession(escolheClasse(p));
        return p;
    }

    public String escolheClasse(Personagem p) {
        String classe="Guerreiro";
      //  classe = JOptionPane.showInputDialog("Guerreiro, Arqueiro, Mago");
        switch (classe) {
            case "Guerreiro":
                atualizaPersonagem(this.getStrength() + 4, this.getDexterity() + 2, this.getIntellect() + 1, this.getCharisma() + 1, this.getHpMax() + 30, this.getMpMax() + 10, 0.9);
                break;
            case "Arqueiro":
                atualizaPersonagem(this.getStrength() + 1, this.getDexterity() + 4, this.getIntellect() + 1, this.getCharisma() + 2, this.getHpMax() + 20, this.getMpMax() + 15, 0.8);
                break;
            case "Mago":
                atualizaPersonagem(this.getStrength() + 1, this.getDexterity() + 1, this.getIntellect() + 4, this.getCharisma() + 2, this.getHpMax() + 10, this.getMpMax() + 30, 1);
                break;
            default:
                classe = "Guerreiro";
                atualizaPersonagem(this.getStrength() + 4, this.getDexterity() + 2, this.getIntellect() + 1, this.getCharisma() + 1, this.getHpMax() + 30, this.getMpMax() + 10, 0.9);
                break;
        }
        return classe;
    }

    public String escolheRaca(Personagem p) {
        String raca="Humano";
    //    raca = JOptionPane.showInputDialog("Humano, Elfo, Anao");
        switch (raca) {
            case "Humano":
                atualizaPersonagem(1, 1, 1, 1, 10, 5, 1);
                break;
            case "Elfo":
                atualizaPersonagem(0, 2, 1, 0, 10, 5, 0.95);
                break;
            case "Anao":
                atualizaPersonagem(2, 0, 0, 0, 15, 5, 1);
                break;
            default:
                raca = "Humano";
                atualizaPersonagem(p.getStrength() + 1, p.getDexterity() + 1, p.getIntellect() + 1, p.getCharisma() + 1, p.getHpMax(), p.getMpMax(), p.getSpeed());
                break;
        }
        return raca;
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

}
