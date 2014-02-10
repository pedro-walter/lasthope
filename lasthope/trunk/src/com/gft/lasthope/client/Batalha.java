package com.gft.lasthope.client;

import com.gft.lasthope.shared.Criatura;
import com.gft.lasthope.shared.Dados;
import com.gft.lasthope.shared.Inimigo;
import com.gft.lasthope.shared.Personagem;

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
        
        if (numRolado >= (21 - a.getWeapon().getCriticalRate())) {
            if ("Fisica".equals(a.getWeapon().getTipo())) {
                dano = (a.getWeapon().calculaDano(a.getWeapon().getDadoArma(), a.getStrength())) * a.getWeapon().getCriticalMultiplier();
            } else {
                dano = (a.getWeapon().calculaDano(a.getWeapon().getDadoArma(), a.getDexterity())) * a.getWeapon().getCriticalMultiplier();
            }
            dano = dano - d.getResist();
            if (a instanceof Personagem) {
                System.out.println("Voce causou: " + dano);
            } else {
                System.out.println("O inimigo causou: " + dano);
            }
            d.setHp(d.getHp() - dano);
            
        } else if (numRolado >= d.getDefense()) {
            if ("Fisica".equals(a.getWeapon().getTipo())) {
                dano = a.getWeapon().calculaDano(a.getWeapon().getDadoArma(), a.getStrength());
            } else {
                dano = a.getWeapon().calculaDano(a.getWeapon().getDadoArma(), a.getDexterity());
            }
            dano = dano - d.getResist();
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
        
        System.out.println(d.getName() + " esta com " + d.getHp() + " de vida.");
        a.setControladorTempo(a.getControladorTempo() + a.getSpeed());
        
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
            p.ganharBatalha(p, i.getExp());
        }
        else{

        }
    }
}
