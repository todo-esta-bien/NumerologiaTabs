package mx.com.bit01.numerologiaappux.models;

/**
 * Created by roeeyn on 17/05/17.
 */

public class PitagoricNum extends Numerology{

    private int mPersonality,mEssence, mExpression, mStrength, mCosmicMission,mEquilibrium,mSpiritualInitialization;

    public int calculatePersonality(String nombres, String apellidos){

        String nombreComp = subsSpecialChar(nombres+""+apellidos).toLowerCase().trim().replaceAll("\\s","");
        return sumAll(sumConsonantsPita(nombreComp)+"",true);

    }

    public int calculateEssence(String nombres, String apellidos){

        String nombreComp = subsSpecialChar(nombres+""+apellidos).toLowerCase().trim().replaceAll("\\s","");
        return sumAll((sumVocalsPita(nombreComp))+"",true);

    }

    public int calculateExpression(String nombres, String apellidos){

        String nombreComp = subsSpecialChar(nombres+""+apellidos).toLowerCase().trim().replaceAll("\\s","");
        return sumAll((sumVocalsPita(nombreComp)+sumConsonantsPita(nombreComp))+"",true);

    }

    /*public int calculateStrength(int dia, int mes){

        String fecha=mes+""+anio;
        return sumarTodos(fecha, false);

    }*/

}
