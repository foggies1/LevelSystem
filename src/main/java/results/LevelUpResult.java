package results;

import model.ActionResult;
import lombok.Data;

@Data
public class LevelUpResult implements ActionResult {

    private final long beginningLevel;
    private final long endLevel;
    private final long beginningBalance;
    private final long endBalance;
    private final double totalCost;

}
