package results;

import model.ActionResult;
import lombok.Data;

@Data
public class NotEnoughCurrencyResult implements ActionResult {

    private final double requiredAmount;
    private final long currentAmount;

    public long getAmountNeeded(){
        return (long) (requiredAmount - currentAmount);
    }

}
