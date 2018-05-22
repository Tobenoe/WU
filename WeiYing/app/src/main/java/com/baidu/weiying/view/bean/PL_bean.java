package com.baidu.weiying.view.bean;

import java.util.List;

/**
 * Created by work on 2018/5/22.
 */

public class PL_bean {


    /**
     * msg : 成功
     * ret : {"pnum":1,"totalRecords":5,"records":20,"list":[{"msg":"我只看过这个的h版，现在看看正版是什么样子？","phoneNumber":"善良要余有锋芒","dataId":"ff8080815e3289c7015e36f519d60b7b","userPic":"http://q.qlogo.cn/qqapp/1101034181/60B0A87D1D403CFE8B180F8F26AF17FC/40","time":"2017-08-31 14:23:06","likeNum":2},{"msg":"故事情节一般，没啥新意。","phoneNumber":"伪装坚强","dataId":"ff8080815c7b49e6015c8731528b5d6c","userPic":"","time":"2017-05-31 01:12:55","likeNum":3},{"msg":"男女主角的演技一流啊！","phoneNumber":"伪笑醉相思","dataId":"ff8080815c7b49e6015c873152895d6b","userPic":"","time":"2017-05-25 19:12:55","likeNum":2},{"msg":"作为一个电影资深评论家，我也是没啥可说的了\u2026\u2026","phoneNumber":"看不到未来","dataId":"ff8080815c7b49e6015c873152855d69","userPic":"","time":"2017-05-14 14:26:55","likeNum":3},{"msg":"本来没想看这个，看完了觉得还行，没有想象中的那么差劲。","phoneNumber":"青春散场","dataId":"ff8080815c7b49e6015c873152875d6a","userPic":"","time":"2017-05-01 19:52:55","likeNum":3}],"totalPnum":1}
     * code : 200
     */

    private String msg;
    private RetBean ret;
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RetBean getRet() {
        return ret;
    }

    public void setRet(RetBean ret) {
        this.ret = ret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class RetBean {
        /**
         * pnum : 1
         * totalRecords : 5
         * records : 20
         * list : [{"msg":"我只看过这个的h版，现在看看正版是什么样子？","phoneNumber":"善良要余有锋芒","dataId":"ff8080815e3289c7015e36f519d60b7b","userPic":"http://q.qlogo.cn/qqapp/1101034181/60B0A87D1D403CFE8B180F8F26AF17FC/40","time":"2017-08-31 14:23:06","likeNum":2},{"msg":"故事情节一般，没啥新意。","phoneNumber":"伪装坚强","dataId":"ff8080815c7b49e6015c8731528b5d6c","userPic":"","time":"2017-05-31 01:12:55","likeNum":3},{"msg":"男女主角的演技一流啊！","phoneNumber":"伪笑醉相思","dataId":"ff8080815c7b49e6015c873152895d6b","userPic":"","time":"2017-05-25 19:12:55","likeNum":2},{"msg":"作为一个电影资深评论家，我也是没啥可说的了\u2026\u2026","phoneNumber":"看不到未来","dataId":"ff8080815c7b49e6015c873152855d69","userPic":"","time":"2017-05-14 14:26:55","likeNum":3},{"msg":"本来没想看这个，看完了觉得还行，没有想象中的那么差劲。","phoneNumber":"青春散场","dataId":"ff8080815c7b49e6015c873152875d6a","userPic":"","time":"2017-05-01 19:52:55","likeNum":3}]
         * totalPnum : 1
         */

        private int pnum;
        private int totalRecords;
        private int records;
        private int totalPnum;
        private List<ListBean> list;

        public int getPnum() {
            return pnum;
        }

        public void setPnum(int pnum) {
            this.pnum = pnum;
        }

        public int getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(int totalRecords) {
            this.totalRecords = totalRecords;
        }

        public int getRecords() {
            return records;
        }

        public void setRecords(int records) {
            this.records = records;
        }

        public int getTotalPnum() {
            return totalPnum;
        }

        public void setTotalPnum(int totalPnum) {
            this.totalPnum = totalPnum;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * msg : 我只看过这个的h版，现在看看正版是什么样子？
             * phoneNumber : 善良要余有锋芒
             * dataId : ff8080815e3289c7015e36f519d60b7b
             * userPic : http://q.qlogo.cn/qqapp/1101034181/60B0A87D1D403CFE8B180F8F26AF17FC/40
             * time : 2017-08-31 14:23:06
             * likeNum : 2
             */

            private String msg;
            private String phoneNumber;
            private String dataId;
            private String userPic;
            private String time;
            private int likeNum;

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public String getDataId() {
                return dataId;
            }

            public void setDataId(String dataId) {
                this.dataId = dataId;
            }

            public String getUserPic() {
                return userPic;
            }

            public void setUserPic(String userPic) {
                this.userPic = userPic;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getLikeNum() {
                return likeNum;
            }

            public void setLikeNum(int likeNum) {
                this.likeNum = likeNum;
            }
        }
    }
}
