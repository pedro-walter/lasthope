package com.gft.lasthope.client;

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

    Personagem() {

    }

    public void evoluir(Personagem p) {
        p.setExperiencia(getExperiencia() - getLevel() * 100);
        p.setLevel(getLevel() + 1);
        p.setVelocidade(p.getVelocidade()-0.04);
        p.statPoints = statPoints + 3;
        System.out.println("Voce evoluiu para o level " + p.getLevel());
    }

    public void morrer() {
        double xpLost = getExperiencia() * 0.1;
        long xpLostLong = Math.round(xpLost);
        setExperiencia(getExperiencia() - xpLostLong);
    }

    public void ganharBatalha(Personagem p, long xpMonstro) {
        System.out.println("Voce ganhou a batalha!!!");
        p.setExperiencia(p.getExperiencia() + xpMonstro);
        p.setHp(p.getHpMax());
        if (p.getExperiencia() >= p.getLevel() * 100) {
            evoluir(p);
        }
    }

    public Personagem criaPersonagem() {
        Personagem p = new Personagem();
  //      p.setNome(JOptionPane.showInputDialog("Nome do personagem: "));
        p.setClasse(escolheClasse(p));
        return p;
    }

    public String escolheClasse(Personagem p) {
        String classe="Guerreiro";
      //  classe = JOptionPane.showInputDialog("Guerreiro, Arqueiro, Mago");
        switch (classe) {
            case "Guerreiro":
                atualizaPersonagem(this.getForca() + 4, this.getDextreza() + 2, this.getInteligencia() + 1, this.getCarisma() + 1, this.getHpMax() + 30, this.getMpMax() + 10, 0.9);
                break;
            case "Arqueiro":
                atualizaPersonagem(this.getForca() + 1, this.getDextreza() + 4, this.getInteligencia() + 1, this.getCarisma() + 2, this.getHpMax() + 20, this.getMpMax() + 15, 0.8);
                break;
            case "Mago":
                atualizaPersonagem(this.getForca() + 1, this.getDextreza() + 1, this.getInteligencia() + 4, this.getCarisma() + 2, this.getHpMax() + 10, this.getMpMax() + 30, 1);
                break;
            default:
                classe = "Guerreiro";
                atualizaPersonagem(this.getForca() + 4, this.getDextreza() + 2, this.getInteligencia() + 1, this.getCarisma() + 1, this.getHpMax() + 30, this.getMpMax() + 10, 0.9);
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
                atualizaPersonagem(p.getForca() + 1, p.getDextreza() + 1, p.getInteligencia() + 1, p.getCarisma() + 1, p.getHpMax(), p.getMpMax(), p.getVelocidade());
                break;
        }
        return raca;
    }

    public void atualizaPersonagem(int forca, int dext, int inte, int caris, int hpMax, int mpMax, double velocidade) {
        this.setForca(forca);
        this.setDextreza(dext);
        this.setInteligencia(inte);
        this.setCarisma(caris);
        this.setHpMax(hpMax);
        this.setHp(hpMax);
        this.setMpMax(mpMax);
        this.setMp(mpMax);
        this.setVelocidade(velocidade);
    }

}
