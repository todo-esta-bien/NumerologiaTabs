package mx.com.bit01.numerologiaappux.models;

/**
 * Created by roeeyn on 17/05/17.
 */

public class Numerology {

    public int sumAll(String numero, boolean pararSiMaestro){

        String sumaTmp=numero;

        int sumaTmpInt = 0;

        int[] digs = new int[sumaTmp.length()];

        boolean mayorADiez=false, esMaestro=false;

        if(Integer.parseInt(numero) > 10){
            mayorADiez = true;
        }else{

            sumaTmpInt = Integer.parseInt(numero);
            return sumaTmpInt;

        }

        if(isMaster(numero)){
            sumaTmpInt = Integer.parseInt(numero);
            return sumaTmpInt;
        }

        if(pararSiMaestro){

            while(mayorADiez && !esMaestro){

                sumaTmpInt = 0;

                for(int i=0;i<sumaTmp.length();i++){

                    digs[i]=Character.getNumericValue(sumaTmp.charAt(i));
                    sumaTmpInt=sumaTmpInt+digs[i];

                }

                sumaTmp = (sumaTmpInt)+"";

                esMaestro = isMaster(sumaTmp);

                if(sumaTmpInt<10){

                    mayorADiez = false;

                }

            }

            return sumaTmpInt;

        }else{

            while(mayorADiez){

                sumaTmpInt = 0;

                for(int i=0;i<sumaTmp.length();i++){

                    digs[i]=Character.getNumericValue(sumaTmp.charAt(i));
                    sumaTmpInt=sumaTmpInt+digs[i];

                }

                sumaTmp = (sumaTmpInt)+"";

                if(sumaTmpInt<10){

                    mayorADiez = false;

                }

            }

            return sumaTmpInt;

        }

    }

    public boolean isMaster(String numero){

        if(numero.equals("10") || numero.equals("11") || numero.equals("22") || numero.equals("33") || numero.equals("44") || numero.equals("55")){
            return true;
        }else {

            return false;

        }

    }

    public boolean isKarmic(String numero){

        if(numero.equals("13") || numero.equals("14") || numero.equals("16") || numero.equals("19") ||
                numero.equals("26") || numero.equals("40")){
            return true;
        }else {

            return false;

        }

    }

    public String subsSpecialChar(String str){

        String proc = java.text.Normalizer.normalize(str,java.text.Normalizer.Form.NFD);
        StringBuilder sb = new StringBuilder();
        for (char c : proc.toCharArray()) {
            if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.BASIC_LATIN) {
                sb.append(c);
            }
        }

        return sb.toString();

    }

    public int letterValuePita(char c){

        int valor = 0;

        switch(c){

            case 'a':
            case 'j':
            case 's':
                valor=1;
                break;

            case 'b':
            case 'k':
            case 't':
                valor=2;
                break;

            case 'c':
            case 'l':
            case 'u':
                valor=3;
                break;

            case 'd':
            case 'm':
            case 'v':
                valor=4;
                break;

            case 'e':
            case 'n':
            case 'w':
                valor=5;
                break;

            case 'f':
            case 'o':
            case 'x':
                valor=6;
                break;

            case 'g':
            case 'p':
            case 'y':
                valor=7;
                break;

            case 'h':
            case 'q':
            case 'z':
                valor=8;
                break;

            case 'i':
            case 'r':
                valor=9;
                break;
        }

        return valor;

    }

    public boolean isVocal(char c){
        if((Character.toLowerCase(c)=='a') || (Character.toLowerCase(c)=='e') || (Character.toLowerCase(c)=='i') || (Character.toLowerCase(c)=='o') || (Character.toLowerCase(c)=='u'))
            return true;
        else
            return false;
    }

    public int sumConsonantsPita(String str){

        int sumaC = 0;

        for(int i=0;i<str.length();i++){

            if(!isVocal(str.charAt(i))){

                sumaC = sumaC + letterValuePita(str.charAt(i));

            }

        }

        return sumaC;

    }

    public int sumVocalsPita(String str){

        int sumaC = 0;

        for(int i=0;i<str.length();i++){

            if(isVocal(str.charAt(i))){

                sumaC = sumaC + letterValuePita(str.charAt(i));

            }

        }

        return sumaC;

    }

}
