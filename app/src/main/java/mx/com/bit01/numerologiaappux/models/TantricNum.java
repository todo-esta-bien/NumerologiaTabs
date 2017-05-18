package mx.com.bit01.numerologiaappux.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by roeeyn on 17/05/17.
 */

public class TantricNum extends Numerology implements Parcelable{

    private int mSoul, mKarma, mTalent, mDestinty, mPath, mCosmicAge;

    protected TantricNum(Parcel in) {
        mSoul = in.readInt();
        mKarma = in.readInt();
        mTalent = in.readInt();
        mDestinty = in.readInt();
        mPath = in.readInt();
        mCosmicAge = in.readInt();
    }

    public static final Creator<TantricNum> CREATOR = new Creator<TantricNum>() {
        @Override
        public TantricNum createFromParcel(Parcel in) {
            return new TantricNum(in);
        }

        @Override
        public TantricNum[] newArray(int size) {
            return new TantricNum[size];
        }
    };

    @Override
    public String toString() {
        return "TantricNum{" +
                "mSoul=" + mSoul +
                ", mKarma=" + mKarma +
                ", mTalent=" + mTalent +
                ", mDestinty=" + mDestinty +
                ", mPath=" + mPath +
                ", mCosmicAge=" + mCosmicAge +
                '}';
    }

    public TantricNum(int dia, int mes, int anio){

        this.mSoul = calculateSoul(dia);
        this.mKarma = calculateKarma(mes);
        this.mTalent = calculateTalent(anio);
        this.mDestinty = calculateDestiny(anio);
        this.mPath = calculatePath(dia,mes,anio);
        this.mCosmicAge = calculateCosmicAge(dia,mes,anio);

    }

    public int getSoul() {
        return mSoul;
    }

    public int getKarma() {
        return mKarma;
    }

    public int getTalent() {
        return mTalent;
    }

    public int getDestinty() {
        return mDestinty;
    }

    public int getPath() {
        return mPath;
    }

    public int getCosmicAge() {
        return mCosmicAge;
    }

    public int calculateSoul(int dia){

        return sumAll(dia+"", false);

    }

    public int calculateKarma(int mes){

        return sumAll(mes+"", false);

    }

    public int calculateTalent(int anio){

        String anioS;

        if(anio<10){

            anioS="0"+anio;

        }else{

            anioS = anio+"";

        }

        return sumAll((anioS.charAt(anioS.length()-2))+""+anioS.charAt(anioS.length()-1), true);//se trata de abarcar años con menos de 4 digitos

    }

    public int calculateDestiny(int anio){

        return sumAll(anio+"", true);

    }

    public int calculatePath(int dia, int mes, int anio){

        String todaFecha = dia+""+mes+""+anio;

        return sumAll(todaFecha, true);

    }

    public int calculateCosmicAge(int dia, int mes, int anio){


        String todaFecha = dia+""+mes+""+anio;

        String sumaTmp=todaFecha;

        int sumaTmpInt = 0;

        int[] digs = new int[sumaTmp.length()];

        sumaTmpInt = 0;

        for(int i=0;i<sumaTmp.length();i++){

            digs[i]=Character.getNumericValue(sumaTmp.charAt(i));
            sumaTmpInt=sumaTmpInt+digs[i];

        }

        return sumaTmpInt*1000;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mSoul);
        dest.writeInt(mKarma);
        dest.writeInt(mTalent);
        dest.writeInt(mDestinty);
        dest.writeInt(mPath);
        dest.writeInt(mCosmicAge);
    }
}
