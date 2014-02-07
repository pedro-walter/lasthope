package com.gft.lasthope.client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JOSR
 */
public class Batalha {

    public static String ataqueFisico(Criatura a, Criatura d) {
        int dano;
        int numRolado = Dados.rolarD20(1);
        String log="";
        System.out.println(numRolado);
        
        if (numRolado >= (21 - a.getArma().getCriticalRate())) {
            if ("Fisica".equals(a.getArma().getTipo())) {
                dano = (a.getArma().calculaDano(a.getArma().getDadoArma(), a.getForca())) * a.getArma().getCriticalMultiplier();
            } else {
                dano = (a.getArma().calculaDano(a.getArma().getDadoArma(), a.getDextreza())) * a.getArma().getCriticalMultiplier();
            }
            dano = dano - d.getResistencia();
            if (a instanceof Personagem) {
                System.out.println("Voce causou: " + dano);
            } else {
                System.out.println("O inimigo causou: " + dano);
            }
            d.setHp(d.getHp() - dano);
            
        } else if (numRolado >= d.getDefesa()) {
            if ("Fisica".equals(a.getArma().getTipo())) {
                dano = a.getArma().calculaDano(a.getArma().getDadoArma(), a.getForca());
            } else {
                dano = a.getArma().calculaDano(a.getArma().getDadoArma(), a.getDextreza());
            }
            dano = dano - d.getResistencia();
            Menus.atualizaBattleInfo(dano,a);
            
            //if (a instanceof Personagem) {
                //System.out.println("Voce causou: " + dano);
                
            //} else {
                //System.out.println("O inimigo causou: " + dano);
                //Menus.atualizaBattleInfo(dano,a);
            //}
            d.setHp(d.getHp() - dano);
            
        } else {
            System.out.println("Loser, errou");
        }
        
        System.out.println(d.getNome() + " esta com " + d.getHp() + " de vida.");
        a.setControladorTempo(a.getControladorTempo() + a.getVelocidade());
        
        return log;
    }

    public static Criatura calculaVelocidade(Personagem p, Inimigo i) {
        if (p.getControladorTempo() <= i.getControladorTempo()) {
            return p;
        } else {
            return i;
        }
    }

    public static void aBatalhaQueVaiGirando(Personagem p, Inimigo i) {
        while ((p.getHp() >= 1) && (i.getHp() >= 1)) {
            Criatura c = calculaVelocidade(p, i);
            if (c instanceof Personagem) {
                ataqueFisico(p, i);
                
            } else {
                ataqueFisico(i, p);
            }
        }
        if(p.getHp()>0){
            p.ganharBatalha(p, i.getExperiencia());
        }
        else{

        }
    }
}
