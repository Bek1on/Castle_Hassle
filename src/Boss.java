public class Boss extends Enemy{
    private final String[] BOSS_HEADERS = {"Uber","Omega","Mega","Metal","King","Queen","Ultra","Tyrannical"};
    private final String[] POSSIBLE_SPECIALS = {"Heal","Crunch","Protein Shake"};
    private String bossSpecial;
    public Boss()
    {
        int randomHeader = (int)(Math.random()*8);
        int randomSpecial = (int)(Math.random()*3);
        setGoldCarried(getGoldCarried() * 2);
        setHp((int)(Math.random()*111) + 50);
        setEvasive(getEvasive() + .1);
        setDefense(getDefense() + (int)(Math.random()*31));
        setAttackDmg(getAttackDmg() + (int)(Math.random()*26));
        setName(BOSS_HEADERS[randomHeader] + " " + getName());
        bossSpecial = POSSIBLE_SPECIALS[randomSpecial];
    }

    @Override
    public void useSpecial(PlayersClass player)
    {
        if(bossSpecial.equals("Heal"))
        {
            int healAmt = (int)(Math.random()*31) + 30;
            System.out.println(getName() + " used it's special move, Heal, and healed " + healAmt + " HP!\n------------------------------");
            setHp(getHp() + healAmt);
        }
        if(bossSpecial.equals("Crunch"))
        {
            int dmgAmt = (int)(Math.random()*31) + 45;
            System.out.println(getName() + " used it's special move, Crunch, to deal " + dmgAmt + " damage!\n------------------------------");
            attackPlayer(player,dmgAmt);
        }
        if(bossSpecial.equals("Protein Shake"))
        {
            int adIncrease = (int)(Math.random()*11) + 10;
            int defIncrease = (int)(Math.random()*11) + 10;
            System.out.println(getName() + " used it's special move, Protein Shake, to increase it's attack damage by " + adIncrease + " and increase it's defense by " + defIncrease + "!\n------------------------------");
            setAttackDmg(getAttackDmg() + adIncrease);
            setDefense(getDefense() + defIncrease);
        }
    }

    @Override
    public void duelWithPlayer(PlayersClass player) {
        double specialAbilityChance = Math.random();
        if(specialAbilityChance >= .9)
        {
            useSpecial(player);
        }
        else
        {
            super.duelWithPlayer(player);
        }
    }

}
