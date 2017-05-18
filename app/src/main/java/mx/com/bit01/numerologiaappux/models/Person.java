package mx.com.bit01.numerologiaappux.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by roeeyn on 17/05/17.
 */

public class Person implements Parcelable{

    private String mName;
    private String mLastName;
    private int mDay;
    private int mMonth;
    private int mYear;
    private TantricNum mTantricNum;

    public int getmDay() {
        return mDay;
    }

    public void setmDay(int mDay) {
        this.mDay = mDay;
    }

    public int getmMonth() {
        return mMonth;
    }

    public void setmMonth(int mMonth) {
        this.mMonth = mMonth;
    }

    public int getmYear() {
        return mYear;
    }

    public void setmYear(int mYear) {
        this.mYear = mYear;
    }

    public void setTantricNum(int mDay, int mMonth, int mYear) {
        this.mTantricNum = new TantricNum(mDay,mMonth,mYear);
    }

    @Override
    public String toString() {
        return "Person{" +
                "mName='" + mName + '\'' +
                ", mLastName='" + mLastName + '\'' +
                ", mDay=" + mDay +
                ", mMonth=" + mMonth +
                ", mYear=" + mYear +
                ", mTantricNum=" + mTantricNum +
                '}';
    }

    protected Person(Parcel in) {
        mName = in.readString();
        mLastName = in.readString();
        mDay = in.readInt();
        mMonth = in.readInt();
        mYear = in.readInt();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public TantricNum getmTantricNum() {
        return mTantricNum;
    }

    public Person(String mName, String mLastName, int mDay, int mMonth, int mYear) {
        this.mName = mName;
        this.mLastName = mLastName;
        this.mDay = mDay;
        this.mMonth = mMonth;
        this.mYear = mYear;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mLastName);
        dest.writeInt(mDay);
        dest.writeInt(mMonth);
        dest.writeInt(mYear);
    }
}
