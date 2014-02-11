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

	public static void ataqueFisico(Creature a, Creature d) {
		int dano;
		int numRolado = Dices.rolarD20(1);
		boolean crit=false;
		String log = "";
		System.out.println(numRolado);

		if (numRolado >= (21 - a.getWeapon().getCriticalRate())) {
			if ("Physical".equals(a.getWeapon().getTipo())) {
				dano = (a.getWeapon().calculaDano(a.getWeapon().getDadoArma(),
						a.getStrength()))
						* a.getWeapon().getCriticalMultiplier();
				crit=true;
			} else {
				dano = (a.getWeapon().calculaDano(a.getWeapon().getDadoArma(),
						a.getDexterity()))
						* a.getWeapon().getCriticalMultiplier();
				crit=true;
			}
			dano = dano - d.getResist();
			BatalhaPanel.atualizaBattleInfo(dano, d, crit);

			d.setHp(d.getHp() - dano);

		} else if (numRolado >= d.getDefense()) {
			if ("Physical".equals(a.getWeapon().getTipo())) {
				dano = a.getWeapon().calculaDano(a.getWeapon().getDadoArma(),
						a.getStrength());
			} else {
				dano = a.getWeapon().calculaDano(a.getWeapon().getDadoArma(),
						a.getDexterity());
			}
			dano = dano - d.getResist();
			BatalhaPanel.atualizaBattleInfo(dano, d, crit);

			d.setHp(d.getHp() - dano);

		} else {
			if (a instanceof Character) {
				BatalhaPanel.setLog("You miss!");
			} else {
				BatalhaPanel.setLog("The enemy missed!");
			}
		}

		a.setControladorTempo(a.getControladorTempo() + a.getSpeed());

	}

	public static Creature calculaVelocidade(Character p, Enemy i) {
		if (p.getControladorTempo() <= i.getControladorTempo()) {
			return p;
		} else {
			return i;
		}
	}

	public static void aBatalhaQueVaiGirando(Character p, Enemy i) {

		Creature c = calculaVelocidade(p, i);

		if (c instanceof Character) {
			ataqueFisico(p, i);

			while (i.getControladorTempo() < p.getControladorTempo()) {
				if (i.getHp() <= 0 || p.getHp() <= 0) {
					break;
				}
				ataqueFisico(i, p);
			}

		} else {
			ataqueFisico(i, p);

			while (p.getControladorTempo() < i.getControladorTempo()) {
				if (i.getHp() <= 0 || p.getHp() <= 0) {
					break;
				}
				ataqueFisico(p, i);
			}
		}

		if (isWinner(p, i) instanceof Character) {
			p.ganharBatalha(p, i.getExp(), i.getGold());
			BatalhaPanel.setLog("You get " + Long.toString(i.getExp())
					+ " EXP and " + Integer.toString(i.getGold()) + " gold pieces");
			BatalhaPanel.atacar.setEnabled(false);
		} else if (isWinner(p, i) instanceof Enemy) {
			p.morrer();
			BatalhaPanel.setLog("You died.");
			BatalhaPanel.atacar.setEnabled(false);
		}

	}

	public static Creature isWinner(Character p, Enemy i) {

		if (i.getHp() <= 0) {
			return p;
		} else if (p.getHp() <= 0) {
			return i;
		} else {
			return null;
		}

	}
}
