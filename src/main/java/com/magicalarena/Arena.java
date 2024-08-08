package com.magicalarena;

public class Arena {
    public void fight(Player player1, Player player2) {
        while (player1.isAlive() && player2.isAlive()) {
            Player attacker = (player1.getHealth() < player2.getHealth()) ? player1 : player2;
            Player defender = (attacker == player1) ? player2 : player1;

            performAttack(attacker, defender);

            if (!defender.isAlive()) {
                System.out.println(defender + " has died.");
                break;
            }

            // Swap roles for the next turn
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }
    }

    private void performAttack(Player attacker, Player defender) {
        int attackRoll = attacker.rollDie();
        int defenseRoll = defender.rollDie();

        int damage = attacker.getAttack() * attackRoll;
        int defended = defender.getStrength() * defenseRoll;

        int actualDamage = damage - defended;
        if (actualDamage > 0) {
            defender.setHealth(defender.getHealth() - actualDamage);
        }

        System.out.printf("%s attacks %s: Attack Roll = %d, Defense Roll = %d, Damage = %d, Defended = %d, %s Health = %d%n",
                attacker, defender, attackRoll, defenseRoll, damage, defended, defender, defender.getHealth());
    }
}
