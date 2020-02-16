package com.example.frameapp.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Mvp 测试数据 实体类
 * 2020-02-15
 *
 * @author
 */
public class MvpTestDataBean implements Parcelable {

    /**
     * code : 1
     * msg : ok
     * data : {"count":1442,"item":[{"date":"20200215","filename":"OHR.HumpbackHerring_ZH-CN2868885675_1920x1080.jpg","rmsimg":null,"copyright":"克瓦尔岛海岸以鲱鱼为食的座头鲸，北挪威特罗姆瑟 (© Espen Bergersen/Minden Pictures)","title":null,"desc":null,"address":null,"provider":null,"country":null,"city":null,"longitude":0,"latitude":0,"continent":null,"viewcount":21,"downloadcount":4,"likecount":0,"url":"//img.nicebing.com/OHR.HumpbackHerring_ZH-CN2868885675_1920x1080.jpg"}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * count : 1442
         * item : [{"date":"20200215","filename":"OHR.HumpbackHerring_ZH-CN2868885675_1920x1080.jpg","rmsimg":null,"copyright":"克瓦尔岛海岸以鲱鱼为食的座头鲸，北挪威特罗姆瑟 (© Espen Bergersen/Minden Pictures)","title":null,"desc":null,"address":null,"provider":null,"country":null,"city":null,"longitude":0,"latitude":0,"continent":null,"viewcount":21,"downloadcount":4,"likecount":0,"url":"//img.nicebing.com/OHR.HumpbackHerring_ZH-CN2868885675_1920x1080.jpg"}]
         */

        private int count;
        private List<ItemBean> item;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ItemBean> getItem() {
            return item;
        }

        public void setItem(List<ItemBean> item) {
            this.item = item;
        }

        public static class ItemBean {
            /**
             * date : 20200215
             * filename : OHR.HumpbackHerring_ZH-CN2868885675_1920x1080.jpg
             * rmsimg : null
             * copyright : 克瓦尔岛海岸以鲱鱼为食的座头鲸，北挪威特罗姆瑟 (© Espen Bergersen/Minden Pictures)
             * title : null
             * desc : null
             * address : null
             * provider : null
             * country : null
             * city : null
             * longitude : 0
             * latitude : 0
             * continent : null
             * viewcount : 21
             * downloadcount : 4
             * likecount : 0
             * url : //img.nicebing.com/OHR.HumpbackHerring_ZH-CN2868885675_1920x1080.jpg
             */

            private String date;
            private String filename;
            private Object rmsimg;
            private String copyright;
            private Object title;
            private Object desc;
            private Object address;
            private Object provider;
            private Object country;
            private Object city;
            private int longitude;
            private int latitude;
            private Object continent;
            private int viewcount;
            private int downloadcount;
            private int likecount;
            private String url;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getFilename() {
                return filename;
            }

            public void setFilename(String filename) {
                this.filename = filename;
            }

            public Object getRmsimg() {
                return rmsimg;
            }

            public void setRmsimg(Object rmsimg) {
                this.rmsimg = rmsimg;
            }

            public String getCopyright() {
                return copyright;
            }

            public void setCopyright(String copyright) {
                this.copyright = copyright;
            }

            public Object getTitle() {
                return title;
            }

            public void setTitle(Object title) {
                this.title = title;
            }

            public Object getDesc() {
                return desc;
            }

            public void setDesc(Object desc) {
                this.desc = desc;
            }

            public Object getAddress() {
                return address;
            }

            public void setAddress(Object address) {
                this.address = address;
            }

            public Object getProvider() {
                return provider;
            }

            public void setProvider(Object provider) {
                this.provider = provider;
            }

            public Object getCountry() {
                return country;
            }

            public void setCountry(Object country) {
                this.country = country;
            }

            public Object getCity() {
                return city;
            }

            public void setCity(Object city) {
                this.city = city;
            }

            public int getLongitude() {
                return longitude;
            }

            public void setLongitude(int longitude) {
                this.longitude = longitude;
            }

            public int getLatitude() {
                return latitude;
            }

            public void setLatitude(int latitude) {
                this.latitude = latitude;
            }

            public Object getContinent() {
                return continent;
            }

            public void setContinent(Object continent) {
                this.continent = continent;
            }

            public int getViewcount() {
                return viewcount;
            }

            public void setViewcount(int viewcount) {
                this.viewcount = viewcount;
            }

            public int getDownloadcount() {
                return downloadcount;
            }

            public void setDownloadcount(int downloadcount) {
                this.downloadcount = downloadcount;
            }

            public int getLikecount() {
                return likecount;
            }

            public void setLikecount(int likecount) {
                this.likecount = likecount;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            @Override
            public String toString() {
                return "ItemBean{" +
                        "date='" + date + '\'' +
                        ", filename='" + filename + '\'' +
                        ", rmsimg=" + rmsimg +
                        ", copyright='" + copyright + '\'' +
                        ", title=" + title +
                        ", desc=" + desc +
                        ", address=" + address +
                        ", provider=" + provider +
                        ", country=" + country +
                        ", city=" + city +
                        ", longitude=" + longitude +
                        ", latitude=" + latitude +
                        ", continent=" + continent +
                        ", viewcount=" + viewcount +
                        ", downloadcount=" + downloadcount +
                        ", likecount=" + likecount +
                        ", url='" + url + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "count=" + count +
                    ", item=" + item +
                    '}';
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.code);
        dest.writeString(this.msg);
        dest.writeParcelable((Parcelable) this.data, flags);
    }

    public MvpTestDataBean() {
    }

    protected MvpTestDataBean(Parcel in) {
        this.code = in.readInt();
        this.msg = in.readString();
        this.data = in.readParcelable(DataBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<MvpTestDataBean> CREATOR = new Parcelable.Creator<MvpTestDataBean>() {
        @Override
        public MvpTestDataBean createFromParcel(Parcel source) {
            return new MvpTestDataBean(source);
        }

        @Override
        public MvpTestDataBean[] newArray(int size) {
            return new MvpTestDataBean[size];
        }
    };

    @Override
    public String toString() {
        return "MvpTestDataBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
