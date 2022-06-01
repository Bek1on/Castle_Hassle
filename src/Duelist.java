public class Duelist extends Knight{

    public Duelist(String name)
    {
        super(name);
        setAttack(40);
        setEvasive(.25);
        setLuck(0.0);
        setCritChance(0);
        setSecondarySpecial("ENEMY'S EDUCATION");
    }

    public void useSpecial(Enemy killMe, String whichSpecialIsUsed)
    {
        if(whichSpecialIsUsed.equals("secondary")) {
            int totalDmg = (int) (((Math.random() * 11) + getAttack()) * (100.0 / (100.0 + killMe.getDefense())));
            double attackIncreaseChance = Math.random();
            System.out.println(getName() + " used their special, ENEMY'S EDUCATION! Let's see what you can do " + killMe.getName() + "!");
            if (attackIncreaseChance >= .95) {
                attackEnemy(killMe, totalDmg);
                setAttack(getAttack() + 5);
                System.out.println(getName() + " dealt " + totalDmg + " damage and increased their attack damage by 5, WHAT AN EDUCATING BATTLE!");
                if(killMe.getHp() > 0) {
                    System.out.println(killMe.getName() + " now has " + killMe.getHp() + " HP!\n------------------------------");
                }
                else
                {
                    System.out.println("------------------------------");
                }
            } else {
                attackEnemy(killMe, totalDmg);
                System.out.println(getName() + " dealt " + totalDmg + " damage, but didn't learn anything, HOW DISAPPOINTING!");
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
