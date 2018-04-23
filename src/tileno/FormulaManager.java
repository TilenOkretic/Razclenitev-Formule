package tileno;

import java.util.Map;
import static tileno.Util.*;

public class FormulaManager {


    private Map<String,Integer> FORMULA_MAP;

    /**
     * Preprosto ustvari 'Map' atomov za dano formulo
     * @param formula
     */
    public FormulaManager(String formula){
        this.FORMULA_MAP = create_formula_map(formula);
    }

    /**
     * @param atom zeljeni atom
     * @return vrednost atoma
     */
    public String getAtomData(String atom){
        return atom + " " + FORMULA_MAP.get(atom);
    }

    /**
     * @return Map atomov formule
     */
    public Map<String,Integer> getFormulaMap(){
        return this.FORMULA_MAP;
    }
}
