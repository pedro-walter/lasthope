package com.gft.lasthope.client;

import com.gft.lasthope.shared.Creature;
import com.gft.lasthope.shared.Dices;
import com.gft.lasthope.shared.Enemy;
import com.gft.lasthope.shared.Character;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JOSR
 */
public class Battle {

    public static String ataqueFisico(Creature a, Creature d) {
        int dano;
        int numRolado = Dices.rolarD20(1);
        String log="";
        System.out.println(numRolado);

        if (numRolado >= (21 - a.getWeapon().getCriticalRate())) {
            if ("Physical".equals(a.getWeapon().getTipo())) {
                dano = (a.getWeapon().calculaDano(a.getWeapon().getDadoArma(), a.getStrength())) * a.getWeapon().getCriticalMultiplier();
            } else {
                dano = (a.getWeapon().calculaDano(a.getWeapon().getDadoArma(), a.getDexterity())) * a.getWeapon().getCriticalMultiplier();
            }
            dano = dano - d.getResist();
            if (a instanceof Character) {
                System.out.println("You dealt: " + dano);
            } else {
                System.out.println("The enemy dealt: " + dano);
            }
            d.setHp(d.getHp() - dano);

        } else if (numRolado >= d.getDefense()) {
            if ("Physical".equals(a.getWeapon().getTipo())) {
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
            System.out.println("Loser, you missed");
        }

        System.out.println(d.getName() + " is with " + d.getHp() + " HP.");
        a.setControladorTempo(a.getControladorTempo() + a.getSpeed());

        return log;
    }

    public static Creature calculaVelocidade(Character p, Enemy i) {
        if (p.getControladorTempo() <= i.getControladorTempo()) {
            return p;
        } else {
            return i;
        }
    }

    public static void aBatalhaQueVaiGirando(Character p, Enemy i) {
        while ((p.getHp() >= 1) && (i.getHp() >= 1)) {
            Creature c = calculaVelocidade(p, i);
            if (c instanceof Character) {
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
