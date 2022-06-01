public class Heretic extends Knight{

    public Heretic(String name)
    {
        super(name);
        setAttack(55);
        setEvasive(.3);
        setLuck(.2);
        setCritChance(0.02);
        setSecondarySpecial("CRAZED CRUSH");
    }

    public void useSpecial(Enemy killMe, String whichSpecialIsUsed)
    {
        if(whichSpecialIsUsed.equals("secondary")) {
            System.out.println(getName() + " used their special, CRAZED CRUSH! PREPARE TO DIE " + killMe.getName() + "!");
            int totalDmg = (int) (((Math.random() * 31) + getAttack()) * (100.0 / (100.0 + killMe.getDefense())));
            int dmgDealtToSelf = totalDmg / 2;
            double selfHarmChance = Math.random();
            if (selfHarmChance >= .75) {
                attackEnemy(killMe, totalDmg);
                setHP(getHP() - dmgDealtToSelf);
                System.out.println(getName() + " dealt " + totalDmg + " damage, but accidentally hurt themselves, losing " + dmgDealtToSelf + " HP!");
                if(getHP() > 0) {
                    System.out.println(getName() + " now has " + getHP() + " HP!");
                }
                if(killMe.getHp() > 0) {
                    System.out.println(killMe.getName() + " now has " + killMe.getHp() + " HP!\n------------------------------");
                }
                else
                {
                    System.out.println("------------------------------");
                }

            } else {
                int healAmt = (int) (Math.random() * dmgDealtToSelf) + 5;
                setHP(getHP() + healAmt);
                System.out.println(getName() + " dealt " + totalDmg + " damage and gained " + healAmt + " HP from drinking " + killMe.getName() + "'s blood!");
                System.out.println(getName() + " now has " + getHP() + " HP!");
                if(killMe.getHp() > 0) {
                    System.out.println(killMe.getName() + " now has " + killMe.getHp() + " HP!\n------------------------------");
                }
                else
                {
                    System.out.println("------------------------------");
                }
            }
        }
        if(whichSpecialIsUsed.equals("primary"))
        {
            super.useSpecial(killMe,whichSpecialIsUsed);
        }
    }
}
