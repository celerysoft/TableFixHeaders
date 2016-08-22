package com.celerysoft.demo.bean;

/**
 * Created by Celery on 16/8/19.
 *
 */
public class Human implements AttributeEnumerable {
    private String mName;
    private String mAge;
    private String mGender;
    private String mHeight;
    private String mWeight;
    private String mId;
    private String mIsVip;

    public Human() {
        super();
    }

    public Human(String name, String age, String gender, String height, String weight, String id, String isVip) {
        mName = name;
        mAge = age;
        mHeight = height;
        mGender = gender;
        mWeight = weight;
        mId = id;
        mIsVip = isVip;
    }

    @Override
    public int getAttributeCountable() {
        return 7;
    }

    @Override
    public Object getAttribute(int i) {
        Object attribute;
        switch (i) {
            case 0:
                attribute = mName;
                break;
            case 1:
                attribute = mAge;
                break;
            case 2:
                attribute = mGender;
                break;
            case 3:
                attribute = mHeight;
                break;
            case 4:
                attribute = mWeight;
                break;
            case 5:
                attribute = mId;
                break;
            case 6:
            default:
                attribute = mIsVip;
                break;
        }
        return attribute;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAge() {
        return mAge;
    }

    public void setAge(String age) {
        mAge = age;
    }

    public String getHeight() {
        return mHeight;
    }

    public void setHeight(String height) {
        mHeight = height;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    public String getWeight() {
        return mWeight;
    }

    public void setWeight(String weight) {
        mWeight = weight;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getIsVip() {
        return mIsVip;
    }

    public void setIsVip(String isVip) {
        mIsVip = isVip;
    }
}
