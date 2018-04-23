package tileno;

import java.util.*;

public class Util {


    /**
     * Najprej se naredi prazen 'Map' v katerega bomo shranjevali razclenjene atome
     * Formuli razdelimo v tabelo enodelnih vrednosti sepravi npr. "CO2" nastane [C,O,2]
     * Ustvari se 'List', preko normlize algoritma "normalizira" vrednosti tabele
     * Nato skozi algoritem se vredstoi 'Lista' vnesejo v 'Map'
     *
     * @param formula formula katero bomo obdelovali
     * @return Map
     */
    public static Map<String,Integer> create_formula_map(String formula){
        Map<String,Integer> valid = new HashMap<>();

        String[] tmp = formula.split("");
        List<String> temp = normalize(tmp);

        for (int i = 0; i < temp.size(); i++) {

            String _cur = temp.get(i);

            if(!isNumber(_cur)){

                String fn = "";

                for (int k = i + 1;k < temp.size();k++){

                    String _next = temp.get(k);

                    if(isNumber(_next)){

                        fn += _next;

                    }else {

                        break;

                    }

                }

                if (valid.containsKey(_cur)) {

                    valid.put(_cur, Integer.parseInt(fn) + valid.get(_cur));

                } else {

                    valid.put(_cur, Integer.parseInt(fn));

                }

            }

        }

        return valid;
    }

    /**
     * Lista 'res' bo vsebovala rezultate normaliziranja formule
     * Formulo spremenimo v List obliko
     * Preverimo in dopolnimo mankajoca stevila sepravli ce v formlu za simbolom atoma ni stevilke to pomeni da je vrednost
     * ena in na to mesto vstavimo stevilo 1
     * Odpravimo oklepaje in sicer tako da program pomnozi vse elemente znotraj oklepaja z skalarjem
     * Zdruzimo se male in velike tiskane crke skupaj da ustavimo popoln simbol elementa z dvemi crkami npr. 'Ce'
     * @param f tabela razclenjenih delov formule
     * @return List
     */
    private static List<String> normalize(String[] f){

        List<String> res = new ArrayList<>();

        List<String> formula = new ArrayList<>(Arrays.asList(f));

        for (int i = 0; i < formula.size(); i++) {

            String cur = formula.get(i);

            if(!cur.equals("(") && !isNumber(cur) && i+1 == formula.size())formula.add("1");

            if(i + 1 >= formula.size())break;

            String next = formula.get(i + 1);

            if(!cur.equals("(")  && !isNumber(cur) && !isNumber(next) && isUpperCase(next)){

                formula.add(i+1,"1");

            }

        }


        for (int i = 0; i < formula.size(); i++) {

            String cur = formula.get(i);

            if(cur.equals(")")){

                int mul_n = Integer.parseInt(formula.get(i + 1));

                formula.remove(i+1);

                int s = res.size() - 1;

                for (int k = s;k > 0;k--){

                    String _cur = res.get(k);

                    if(_cur.equals("(")){
                        res.remove(k);
                        formula.remove(i);
                        i--;
                        break;
                    }else {
                        if(isNumber(_cur)){
                            res.set(k,Integer.parseInt(_cur) * mul_n + "");
                        }
                    }
                }
            }else{
                res.add(cur);
            }
        }

        for (int i = 0; i < res.size(); i++) {

            String _cur = res.get(i);

            if (!isNumber(_cur) && isUpperCase(_cur)) {

                String _next = res.get(i+1);

                if(!isNumber(_next)){

                    if (!isUpperCase(_next)){

                        res.set(i,res.get(i) + res.get(i+1));

                        res.remove(i+1);

                    }

                }

            }

        }

        return res;
    }


    /**
     * Preprosto preverjanje ce je dani niz stevilo
     *
     * @param s spremenljivka
     * @return boolean
     */
    private static boolean isNumber(String s){
        try{
            int t01 = Integer.parseInt(s);
            return true;
        }catch(NumberFormatException e){
            return false;
        }

    }

    /**
     * Preverjanje ce je dani niz velika zacetnica
     * @param s niz
     * @return boolean
     */
    private static boolean isUpperCase(String s){
        return s.equals(s.toUpperCase());
    }
}
