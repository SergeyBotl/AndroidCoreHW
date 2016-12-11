package com.example.sergey.lesson6;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class User implements Parcelable {
    private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/mm/yyyy", Locale.GERMANY);
    private long id;
    private String firstName;
    private String lastName;
    private int tel;
    private int age;
    private String dateReg;
    private List<String> imageUrls = new ArrayList<>();

    public User(String firstName, String lastName, int tel, int age, Date dateReg, List<String> imageUrls) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
        this.age = age;
        this.dateReg = DATE_FORMAT.format(dateReg);
        this.imageUrls = imageUrls;
    }

    private User(Parcel parcel) {
        id = parcel.readLong();
        firstName = parcel.readString();
        lastName = parcel.readString();
        tel = parcel.readInt();
        age = parcel.readInt();
        dateReg = parcel.readString();
        parcel.readList(imageUrls,ClassLoader.getSystemClassLoader());
       // parcel.readList(imageUrls, String.class.getClassLoader());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDateReg() {
        return DATE_FORMAT.format(new Date(dateReg));
    }

    public static  final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {

        @Override
        public User createFromParcel(Parcel parcel) {
            return new User(parcel);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeInt(tel);
        parcel.writeInt(age);
        parcel.writeString(dateReg);
        parcel.writeList(imageUrls);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ",\n firstName='" + firstName + '\'' +
                ",\n lastName='" + lastName + '\'' +
                ",\n tel=" + tel +
                ",\n age=" + age +
                ",\n dateReg='" + dateReg + '\'' +
                ",\n imageUrls=" + imageUrls +
                '}';
    }
}
