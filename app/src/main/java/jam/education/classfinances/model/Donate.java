package jam.education.classfinances.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;
import java.util.Date;

public class Donate implements Parcelable {
    private int id;
    private String name;
    private Date deadLine;
    private BigDecimal amount;
    private int progress;

    public Donate() {
    }

    public Donate(int id, String name, Date deadLine, BigDecimal amount, int progress) {
        this.id = id;
        this.name = name;
        this.deadLine = deadLine;
        this.amount = amount;
        this.progress = progress;
    }

    protected Donate(Parcel in) {
        id = in.readInt();
        name = in.readString();
        progress = in.readInt();
    }

    public static final Creator<Donate> CREATOR = new Creator<Donate>() {
        @Override
        public Donate createFromParcel(Parcel in) {
            return new Donate(in);
        }

        @Override
        public Donate[] newArray(int size) {
            return new Donate[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

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
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(progress);
    }
}
