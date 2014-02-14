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

	Enemy e = Last_Hope.getEnemy();
	Character c = Last_Hope.getCharacter();;

	public Battle() {

		createEnemy();

	}

	public void ataqueFisico(Creature a, Creature d) {
		int dano;
		int numRolado = Dices.rolarD20(1);
		boolean crit = false;
		String log;

		System.out.println(numRolado);

		if (numRolado >= (21 - a.getWeapon().getCriticalRate())) {
			if ("Physical".equals(a.getWeapon().getTipo())) {
				dano = (a.getWeapon().calculaDano(a.getStrength(), a
						.getWeapon().getDadoArma(), a.getWeapon().getQtd()))
						* a.getWeapon().getCriticalMultiplier();
				crit = true;

			} else {

				dano = (a.getWeapon().calculaDano(a.getDexterity(), a
						.getWeapon().getDadoArma(), a.getWeapon().getQtd()))
						* a.getWeapon().getCriticalMultiplier();
				crit = true;

			}
			dano = dano - d.getResist();
			log = atualizaBattleInfo(dano, d, crit);

			d.setHp(d.getHp() - dano);

			BattlePanel.setLog(log);

		} else if (numRolado >= d.getDefense()) {
			if ("Physical".equals(a.getWeapon().getTipo())) {

				dano = a.getWeapon().calculaDano(a.getStrength(),
						a.getWeapon().getDadoArma(), a.getWeapon().getQtd());

			} else {

				dano = a.getWeapon().calculaDano(a.getDexterity(),
						a.getWeapon().getDadoArma(), a.getWeapon().getQtd());
			}
			dano = dano - d.getResist();
			log = atualizaBattleInfo(dano, d, crit);

			d.setHp(d.getHp() - dano);

			BattlePanel.setLog(log);

		} else {
			if (a instanceof Character) {
				BattlePanel.setLog("You miss!");
			} else {
				BattlePanel.setLog("The enemy missed!");
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

	public void aBatalhaQueVaiGirando(Character p, Enemy i) {

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
			BattlePanel.setLog("You get " + Long.toString(i.getExp())
					+ " EXP and " + Integer.toString(i.getGold())
					+ " gold pieces");
			BattlePanel.atacar.setEnabled(false);

		} else if (isWinner(p, i) instanceof Enemy) {
			p.morrer();
			BattlePanel.setLog("You died.");
			BattlePanel.atacar.setEnabled(false);
		}

	}

	public static Creature isWinner(Character p, Enemy i) {

		if (i.getHp() <= 0) {
			i.die();
			return p;
		} else if (p.getHp() <= 0) {
			return i;
		} else {
			return null;
		}

	}

	public String atualizaBattleInfo(int d, Creature c, boolean crit) {
		int in;
		String log;

		if (c instanceof Character) {

			in = Integer.valueOf(BattlePanel.hpAtualPerso.getText()) - d;
			BattlePanel.hpAtualPerso.setText(Integer.toString(in));

			if (crit) {
				log = "Critical Strike! The enemy " + c.getName() + " dealt " + Integer.toString(d)
						+ " damage!";

			} else {
				log = "The enemy " + c.getName() + " dealt " + Integer.toString(d) + " damage!";
			}
			return log;

		} else {

			in = Integer.valueOf(BattlePanel.hpAtualInimigo.getText()) - d;
			BattlePanel.hpAtualInimigo.setText(Integer.toString(in));

			if (crit) {
				log = "Critical strike! You dealt " + Integer.toString(d)
						+ " damage!";

			} else {
				log = "You dealt " + Integer.toString(d) + " damage!";
			}

			return log;

		}

	}

	public String getStatusEnemy() {
		String status = e.getStatus();

		return status;
	}

	public String getStatusCharacter() {
		String status = c.getStatus();

		return status;
	}

	private void createEnemy() {

		if (!(Last_Hope.getEnemy() == null)) {

			if (e.getHp() > 0) {
				e = Last_Hope.getEnemy();

			} else {
				e.criaInimigo(3);
				Last_Hope.setEnemy(e);

			}

		} else {
			e = new Enemy();
			e.criaInimigo(3);
			Last_Hope.setEnemy(e);

		}

		BattlePanel.atacar.setEnabled(true);

	}
}
