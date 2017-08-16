package com.oncelogs.hellonitirat;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by son_g on 8/16/2017.
 */

public class CoordinateParcelable implements Parcelable{

    public int x, y, z;

    public CoordinateParcelable(){

    }

    protected CoordinateParcelable(Parcel in) {
        x = in.readInt();
        y = in.readInt();
        z = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(x);
        dest.writeInt(y);
        dest.writeInt(z);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CoordinateParcelable> CREATOR = new Creator<CoordinateParcelable>() {
        @Override
        public CoordinateParcelable createFromParcel(Parcel in) {
            return new CoordinateParcelable(in);
        }

        @Override
        public CoordinateParcelable[] newArray(int size) {
            return new CoordinateParcelable[size];
        }
    };
}
