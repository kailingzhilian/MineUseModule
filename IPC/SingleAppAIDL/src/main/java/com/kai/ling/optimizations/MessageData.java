package com.kai.ling.optimizations;

import android.os.Parcel;
import android.os.Parcelable;

public class MessageData implements Parcelable {

    public long id;  //消息的id
    public String content; //消息的内容
    public long time;  //时间

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", time=" + time +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(content);
        dest.writeLong(time);
    }

    public MessageData(Parcel source) {
        id = source.readLong();
        content = source.readString();
        time = source.readLong();
    }

    public MessageData() {

    }

    public void readFromParcel(Parcel in) {
        id = in.readLong();
        content = in.readString();
        time = in.readLong();
    }


    public static final Creator<MessageData> CREATOR = new Creator<MessageData>() {
        @Override
        public MessageData createFromParcel(Parcel source) {
            return new MessageData(source);
        }

        @Override
        public MessageData[] newArray(int size) {
            return new MessageData[size];
        }
    };
}