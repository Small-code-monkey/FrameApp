package com.example.frameapp.bean;

import androidx.databinding.BaseObservable;

import java.util.List;

/**
 * bing 测试数据 实体类 Mvvm
 * 2020/3/3
 *
 * @author
 */
public class BingMvvmDataBean extends BaseObservable {

    /**
     * code : 1
     * msg : ok
     * data : {"count":1459,"item":[{"date":"20200303","filename":"OHR.SpectralTarsiers_ZH-CN1108590907_1920x1080.jpg","rmsimg":null,"copyright":"榕树上的幽灵眼镜猴，印度尼西亚Tangkoko Batuangus自然保护区 (© Ondrej Prosicky/Shutterstock)","title":null,"desc":null,"address":null,"provider":null,"country":null,"city":null,"longitude":0,"latitude":0,"continent":null,"viewcount":357,"downloadcount":16,"likecount":8,"url":"//img.nicebing.com/OHR.SpectralTarsiers_ZH-CN1108590907_1920x1080.jpg"}]}
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
         * count : 1459
         * item : [{"date":"20200303","filename":"OHR.SpectralTarsiers_ZH-CN1108590907_1920x1080.jpg","rmsimg":null,"copyright":"榕树上的幽灵眼镜猴，印度尼西亚Tangkoko Batuangus自然保护区 (© Ondrej Prosicky/Shutterstock)","title":null,"desc":null,"address":null,"provider":null,"country":null,"city":null,"longitude":0,"latitude":0,"continent":null,"viewcount":357,"downloadcount":16,"likecount":8,"url":"//img.nicebing.com/OHR.SpectralTarsiers_ZH-CN1108590907_1920x1080.jpg"}]
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
             * date : 20200303
             * filename : OHR.SpectralTarsiers_ZH-CN1108590907_1920x1080.jpg
             * rmsimg : null
             * copyright : 榕树上的幽灵眼镜猴，印度尼西亚Tangkoko Batuangus自然保护区 (© Ondrej Prosicky/Shutterstock)
             * title : null
             * desc : null
             * address : null
             * provider : null
             * country : null
             * city : null
             * longitude : 0
             * latitude : 0
             * continent : null
             * viewcount : 357
             * downloadcount : 16
             * likecount : 8
             * url : //img.nicebing.com/OHR.SpectralTarsiers_ZH-CN1108590907_1920x1080.jpg
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
        }
    }
}
