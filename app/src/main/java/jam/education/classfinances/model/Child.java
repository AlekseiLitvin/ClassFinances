package jam.education.classfinances.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Child implements Parcelable {
    private String name;

    public Child(String name) {
        this.name = name;
    }

    protected Child(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Child> CREATOR = new Creator<Child>() {
        @Override
        public Child createFromParcel(Parcel in) {
            return new Child(in);
        }

        @Override
        public Child[] newArray(int size) {
            return new Child[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }
}
