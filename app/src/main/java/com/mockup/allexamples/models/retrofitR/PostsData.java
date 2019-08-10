package com.mockup.allexamples.models.retrofitR;

public class PostsData {
    private int mImageResourse;
    private String mText1;
    private String mText2;
    private String mText3;

    public PostsData(int mImageResourse, String mText1, String mText2, String mText3) {
        this.mImageResourse = mImageResourse;
        this.mText1 = mText1;
        this.mText2 = mText2;
        this.mText3 = mText3;
    }

    public int getmImageResourse() {
        return mImageResourse;
    }

    public String getmText1() {
        return mText1;
    }

    public String getmText2() {
        return mText2;
    }

    public String getmText3() {
        return mText3;
    }
}
