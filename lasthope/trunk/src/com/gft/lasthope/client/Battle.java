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
		String log = "";
		System.out.println(numRolado);

		if (numRolado >= (21 - a.getWeapon().getCriticalRate())) {
			if ("Physical".equals(a.getWeapon().getTipo())) {
				dano = (a.getWeapon().calculaDano(a.getWeapon().getDadoArma(),
						a.getStrength()))
						* a.getWeapon().getCriticalMultiplier();
			} else {
				dano = (a.getWeapon().calculaDano(a.getWeapon().getDadoArma(),
						a.getDexterity()))
						* a.getWeapon().getCriticalMultiplier();
			}
			dano = dano - d.getResist();

			BatalhaPanel.atualizaBattleInfo(dano, d);

			// if (a instanceof Character) {
			// System.out.println("You dealt: " + dano);
			// } else {
			// System.out.println("The enemy dealt: " + dano);
			// }
			// d.setHp(d.getHp() - dano);

		} else if (numRolado >= d.getDefense()) {
			if ("Physical".equals(a.getWeapon().getTipo())) {
				dano = a.getWeapon().calculaDano(a.getWeapon().getDadoArma(),
						a.getStrength());
			} else {
				dano = a.getWeapon().calculaDano(a.getWeapon().getDadoArma(),
						a.getDexterity());
			}
			dano = dano - d.getResist();
			BatalhaPanel.atualizaBattleInfo(dano, d);

			// if (a instanceof Character) {
			// System.out.println("Voce causou: " + dano);
			//
			// } else {
			// System.out.println("O inimigo causou: " + dano);
			// BatalhaPanel.atualizaBattleInfo(dano,d);
			// }
			d.setHp(d.getHp() - dano);

		} else {
			// System.out.println("Loser, you missed");
		}

		// System.out.println(d.getName() + " is with " + d.getHp() + " HP.");
		a.setControladorTempo(a.getControladorTempo() + a.getSpeed());

		// return log;
	}

	public static Creature calculaVelocidade(Character p, Enemy i) {
		if (p.getControladorTempo() <= i.getControladorTempo()) {
			return p;
		} else {
			return i;
		}
	}

	public static void aBatalhaQueVaiGirando(Character p, Enemy i) {

		do {
			Creature c = calculaVelocidade(p, i);
			if (c instanceof Character) {
				ataqueFisico(p, i);

			} else {
				ataqueFisico(i, p);
			}
		} while (i.getControladorTempo() < p.getControladorTempo());

		if (isWinner(p, i) instanceof Character) {
			p.ganharBatalha(p, i.getExp());
			BatalhaPanel.setLog("Voce ganhou " + Long.toString(i.getExp())
					+ " de EXP");
		} else if (isWinner(p, i) instanceof Enemy) {
			p.morrer();
			BatalhaPanel.setLog("Voce Morreu");
		}
	}

	public static Creature isWinner(Character p, Enemy i) {

		if (p.getHp() > 0 && i.getHp() < 0) {
			return p;
		} else if (p.getHp() < 0 && i.getHp() > 0) {
			return i;
		} else {
			return null;
		}

	}
}
