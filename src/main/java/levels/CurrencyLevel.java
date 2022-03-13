package levels;

import model.ActionResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import results.LevelUpResult;
import results.NotEnoughCurrencyResult;

@AllArgsConstructor
@Getter
@Setter
public class CurrencyLevel {

    private long maxLevel;
    private long currentLevel;
    private double exponent;

    public double getLevelUpCost(long levels){
        return Math.pow(currentLevel + levels, exponent);
    }

    /**
     *
     * Will attempt to level up as much as possible
     * with the given funds.
     *
     * @param balance the currency balance of the player.
     * @return the level result of the action.
     */
    public ActionResult levelUpMax(final long balance){

        final long startLevel = currentLevel;
        long currentMoney = balance;
        long levelsAdded = 0L;
        double cost = getLevelUpCost(1);
        double totalCost = 0L;

        if(currentMoney < cost) {
            return new NotEnoughCurrencyResult(cost, currentMoney);
        }

        while(currentMoney > cost){
            if(currentLevel + levelsAdded >= maxLevel) break;
            totalCost+=cost;
            levelsAdded++;
            currentMoney-=cost;
            cost=getLevelUpCost(currentLevel + levelsAdded);
        }

        addLevel(levelsAdded);

        return new LevelUpResult(startLevel, currentLevel, balance, (long) (balance - totalCost), totalCost);
    }

    public boolean addLevel(long levels){
        if(getCurrentLevel() == maxLevel) return false;
        if(getCurrentLevel() + levels > maxLevel) levels = maxLevel - currentLevel;

        setCurrentLevel(getCurrentLevel() + levels);
        return true;
    }

    public void removeLevel(long levels){
        if(getCurrentLevel() - levels < 0) levels = getCurrentLevel();
        setCurrentLevel(getCurrentLevel() - levels);
    }


}
