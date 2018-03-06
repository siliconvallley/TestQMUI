package com.isoftstone.huidingc.testqmui.entity;

import java.util.List;

/**
 * @auther huidingc
 * @date 2018/1/30 16:22
 * @description Weather
 */

public class Weather {

    /**
     * HeWeather5 : [{"aqi":{"city":{"aqi":"156","qlty":"中度污染","pm25":"119","pm10":"154","no2":"65","so2":"18","co":"1","o3":"25"}},"basic":{"city":"成都","cnty":"中国","id":"CN101270101","lat":"30.65946198","lon":"104.06573486","update":{"loc":"2018-01-30 16:53","utc":"2018-01-30 08:53"}},"daily_forecast":[{"astro":{"mr":"17:20","ms":"06:29","sr":"07:55","ss":"18:38"},"cond":{"code_d":"104","code_n":"101","txt_d":"阴","txt_n":"多云"},"date":"2018-01-30","hum":"54","pcpn":"0.0","pop":"0","pres":"1024","tmp":{"max":"6","min":"0"},"uv":"3","vis":"14","wind":{"deg":"0","dir":"无持续风向","sc":"微风","spd":"5"}},{"astro":{"mr":"18:28","ms":"07:28","sr":"07:55","ss":"18:39"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2018-01-31","hum":"37","pcpn":"0.0","pop":"0","pres":"1031","tmp":{"max":"9","min":"0"},"uv":"4","vis":"19","wind":{"deg":"0","dir":"无持续风向","sc":"微风","spd":"5"}},{"astro":{"mr":"19:36","ms":"08:20","sr":"07:54","ss":"18:40"},"cond":{"code_d":"101","code_n":"404","txt_d":"多云","txt_n":"雨夹雪"},"date":"2018-02-01","hum":"38","pcpn":"0.0","pop":"0","pres":"1027","tmp":{"max":"9","min":"0"},"uv":"4","vis":"20","wind":{"deg":"0","dir":"无持续风向","sc":"微风","spd":"3"}}],"hourly_forecast":[{"cond":{"code":"104","txt":"阴"},"date":"2018-01-30 19:00","hum":"63","pop":"0","pres":"1025","tmp":"3","wind":{"deg":"319","dir":"西北风","sc":"微风","spd":"13"}},{"cond":{"code":"101","txt":"多云"},"date":"2018-01-30 22:00","hum":"60","pop":"0","pres":"1028","tmp":"2","wind":{"deg":"322","dir":"西北风","sc":"微风","spd":"12"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2018-01-31 01:00","hum":"52","pop":"0","pres":"1032","tmp":"1","wind":{"deg":"321","dir":"西北风","sc":"微风","spd":"11"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2018-01-31 04:00","hum":"54","pop":"0","pres":"1031","tmp":"0","wind":{"deg":"302","dir":"西北风","sc":"微风","spd":"9"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2018-01-31 07:00","hum":"53","pop":"0","pres":"1031","tmp":"0","wind":{"deg":"300","dir":"西北风","sc":"微风","spd":"9"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2018-01-31 10:00","hum":"36","pop":"0","pres":"1031","tmp":"4","wind":{"deg":"315","dir":"西北风","sc":"微风","spd":"10"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2018-01-31 13:00","hum":"26","pop":"0","pres":"1029","tmp":"7","wind":{"deg":"331","dir":"西北风","sc":"微风","spd":"9"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2018-01-31 16:00","hum":"26","pop":"0","pres":"1027","tmp":"9","wind":{"deg":"332","dir":"西北风","sc":"微风","spd":"10"}}],"now":{"cond":{"code":"104","txt":"阴"},"fl":"-4","hum":"75","pcpn":"0.0","pres":"1020","tmp":"4","vis":"2","wind":{"deg":"270","dir":"西风","sc":"微风","spd":"10"}},"status":"ok","suggestion":{"air":{"brf":"较差","txt":"气象条件较不利于空气污染物稀释、扩散和清除，请适当减少室外活动时间。"},"comf":{"brf":"较不舒适","txt":"白天天气阴沉，您会感觉偏冷，不很舒适，请注意添加衣物，以防感冒。"},"cw":{"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},"drsg":{"brf":"冷","txt":"天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。"},"flu":{"brf":"较易发","txt":"天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。"},"sport":{"brf":"较适宜","txt":"阴天，较适宜进行各种户内外运动。"},"trav":{"brf":"适宜","txt":"天气较好，气温稍低，会感觉稍微有点凉，不过也是个好天气哦。适宜旅游，可不要错过机会呦！"},"uv":{"brf":"最弱","txt":"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"}}}]
     */

    private List<HeWeather5Bean> HeWeather5;

    public void setHeWeather5(List<HeWeather5Bean> HeWeather5) {
        this.HeWeather5 = HeWeather5;
    }

    public List<HeWeather5Bean> getHeWeather5() {
        return HeWeather5;
    }

    public static class HeWeather5Bean {
        /**
         * aqi : {"city":{"aqi":"156","qlty":"中度污染","pm25":"119","pm10":"154","no2":"65","so2":"18","co":"1","o3":"25"}}
         * basic : {"city":"成都","cnty":"中国","id":"CN101270101","lat":"30.65946198","lon":"104.06573486","update":{"loc":"2018-01-30 16:53","utc":"2018-01-30 08:53"}}
         * daily_forecast : [{"astro":{"mr":"17:20","ms":"06:29","sr":"07:55","ss":"18:38"},"cond":{"code_d":"104","code_n":"101","txt_d":"阴","txt_n":"多云"},"date":"2018-01-30","hum":"54","pcpn":"0.0","pop":"0","pres":"1024","tmp":{"max":"6","min":"0"},"uv":"3","vis":"14","wind":{"deg":"0","dir":"无持续风向","sc":"微风","spd":"5"}},{"astro":{"mr":"18:28","ms":"07:28","sr":"07:55","ss":"18:39"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2018-01-31","hum":"37","pcpn":"0.0","pop":"0","pres":"1031","tmp":{"max":"9","min":"0"},"uv":"4","vis":"19","wind":{"deg":"0","dir":"无持续风向","sc":"微风","spd":"5"}},{"astro":{"mr":"19:36","ms":"08:20","sr":"07:54","ss":"18:40"},"cond":{"code_d":"101","code_n":"404","txt_d":"多云","txt_n":"雨夹雪"},"date":"2018-02-01","hum":"38","pcpn":"0.0","pop":"0","pres":"1027","tmp":{"max":"9","min":"0"},"uv":"4","vis":"20","wind":{"deg":"0","dir":"无持续风向","sc":"微风","spd":"3"}}]
         * hourly_forecast : [{"cond":{"code":"104","txt":"阴"},"date":"2018-01-30 19:00","hum":"63","pop":"0","pres":"1025","tmp":"3","wind":{"deg":"319","dir":"西北风","sc":"微风","spd":"13"}},{"cond":{"code":"101","txt":"多云"},"date":"2018-01-30 22:00","hum":"60","pop":"0","pres":"1028","tmp":"2","wind":{"deg":"322","dir":"西北风","sc":"微风","spd":"12"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2018-01-31 01:00","hum":"52","pop":"0","pres":"1032","tmp":"1","wind":{"deg":"321","dir":"西北风","sc":"微风","spd":"11"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2018-01-31 04:00","hum":"54","pop":"0","pres":"1031","tmp":"0","wind":{"deg":"302","dir":"西北风","sc":"微风","spd":"9"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2018-01-31 07:00","hum":"53","pop":"0","pres":"1031","tmp":"0","wind":{"deg":"300","dir":"西北风","sc":"微风","spd":"9"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2018-01-31 10:00","hum":"36","pop":"0","pres":"1031","tmp":"4","wind":{"deg":"315","dir":"西北风","sc":"微风","spd":"10"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2018-01-31 13:00","hum":"26","pop":"0","pres":"1029","tmp":"7","wind":{"deg":"331","dir":"西北风","sc":"微风","spd":"9"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2018-01-31 16:00","hum":"26","pop":"0","pres":"1027","tmp":"9","wind":{"deg":"332","dir":"西北风","sc":"微风","spd":"10"}}]
         * now : {"cond":{"code":"104","txt":"阴"},"fl":"-4","hum":"75","pcpn":"0.0","pres":"1020","tmp":"4","vis":"2","wind":{"deg":"270","dir":"西风","sc":"微风","spd":"10"}}
         * status : ok
         * suggestion : {"air":{"brf":"较差","txt":"气象条件较不利于空气污染物稀释、扩散和清除，请适当减少室外活动时间。"},"comf":{"brf":"较不舒适","txt":"白天天气阴沉，您会感觉偏冷，不很舒适，请注意添加衣物，以防感冒。"},"cw":{"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},"drsg":{"brf":"冷","txt":"天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。"},"flu":{"brf":"较易发","txt":"天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。"},"sport":{"brf":"较适宜","txt":"阴天，较适宜进行各种户内外运动。"},"trav":{"brf":"适宜","txt":"天气较好，气温稍低，会感觉稍微有点凉，不过也是个好天气哦。适宜旅游，可不要错过机会呦！"},"uv":{"brf":"最弱","txt":"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"}}
         */

        private AqiBean aqi;
        private BasicBean basic;
        private NowBean now;
        private String status;
        private SuggestionBean suggestion;
        private List<DailyForecastBean> daily_forecast;
        private List<HourlyForecastBean> hourly_forecast;

        public void setAqi(AqiBean aqi) {
            this.aqi = aqi;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setSuggestion(SuggestionBean suggestion) {
            this.suggestion = suggestion;
        }

        public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public void setHourly_forecast(List<HourlyForecastBean> hourly_forecast) {
            this.hourly_forecast = hourly_forecast;
        }

        public AqiBean getAqi() {
            return aqi;
        }

        public BasicBean getBasic() {
            return basic;
        }

        public NowBean getNow() {
            return now;
        }

        public String getStatus() {
            return status;
        }

        public SuggestionBean getSuggestion() {
            return suggestion;
        }

        public List<DailyForecastBean> getDaily_forecast() {
            return daily_forecast;
        }

        public List<HourlyForecastBean> getHourly_forecast() {
            return hourly_forecast;
        }

        public static class AqiBean {
            /**
             * city : {"aqi":"156","qlty":"中度污染","pm25":"119","pm10":"154","no2":"65","so2":"18","co":"1","o3":"25"}
             */

            private CityBean city;

            public void setCity(CityBean city) {
                this.city = city;
            }

            public CityBean getCity() {
                return city;
            }

            public static class CityBean {
                /**
                 * aqi : 156
                 * qlty : 中度污染
                 * pm25 : 119
                 * pm10 : 154
                 * no2 : 65
                 * so2 : 18
                 * co : 1
                 * o3 : 25
                 */

                private String aqi;
                private String qlty;
                private String pm25;
                private String pm10;
                private String no2;
                private String so2;
                private String co;
                private String o3;

                public void setAqi(String aqi) {
                    this.aqi = aqi;
                }

                public void setQlty(String qlty) {
                    this.qlty = qlty;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }

                public void setPm10(String pm10) {
                    this.pm10 = pm10;
                }

                public void setNo2(String no2) {
                    this.no2 = no2;
                }

                public void setSo2(String so2) {
                    this.so2 = so2;
                }

                public void setCo(String co) {
                    this.co = co;
                }

                public void setO3(String o3) {
                    this.o3 = o3;
                }

                public String getAqi() {
                    return aqi;
                }

                public String getQlty() {
                    return qlty;
                }

                public String getPm25() {
                    return pm25;
                }

                public String getPm10() {
                    return pm10;
                }

                public String getNo2() {
                    return no2;
                }

                public String getSo2() {
                    return so2;
                }

                public String getCo() {
                    return co;
                }

                public String getO3() {
                    return o3;
                }
            }
        }

        public static class BasicBean {
            /**
             * city : 成都
             * cnty : 中国
             * id : CN101270101
             * lat : 30.65946198
             * lon : 104.06573486
             * update : {"loc":"2018-01-30 16:53","utc":"2018-01-30 08:53"}
             */

            private String city;
            private String cnty;
            private String id;
            private String lat;
            private String lon;
            private UpdateBean update;

            public void setCity(String city) {
                this.city = city;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public void setUpdate(UpdateBean update) {
                this.update = update;
            }

            public String getCity() {
                return city;
            }

            public String getCnty() {
                return cnty;
            }

            public String getId() {
                return id;
            }

            public String getLat() {
                return lat;
            }

            public String getLon() {
                return lon;
            }

            public UpdateBean getUpdate() {
                return update;
            }

            public static class UpdateBean {
                /**
                 * loc : 2018-01-30 16:53
                 * utc : 2018-01-30 08:53
                 */

                private String loc;
                private String utc;

                public void setLoc(String loc) {
                    this.loc = loc;
                }

                public void setUtc(String utc) {
                    this.utc = utc;
                }

                public String getLoc() {
                    return loc;
                }

                public String getUtc() {
                    return utc;
                }
            }
        }

        public static class NowBean {
            /**
             * cond : {"code":"104","txt":"阴"}
             * fl : -4
             * hum : 75
             * pcpn : 0.0
             * pres : 1020
             * tmp : 4
             * vis : 2
             * wind : {"deg":"270","dir":"西风","sc":"微风","spd":"10"}
             */

            private CondBean cond;
            private String fl;
            private String hum;
            private String pcpn;
            private String pres;
            private String tmp;
            private String vis;
            private WindBean wind;

            public void setCond(CondBean cond) {
                this.cond = cond;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public CondBean getCond() {
                return cond;
            }

            public String getFl() {
                return fl;
            }

            public String getHum() {
                return hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public String getPres() {
                return pres;
            }

            public String getTmp() {
                return tmp;
            }

            public String getVis() {
                return vis;
            }

            public WindBean getWind() {
                return wind;
            }

            public static class CondBean {
                /**
                 * code : 104
                 * txt : 阴
                 */

                private String code;
                private String txt;

                public void setCode(String code) {
                    this.code = code;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }

                public String getCode() {
                    return code;
                }

                public String getTxt() {
                    return txt;
                }
            }

            public static class WindBean {
                /**
                 * deg : 270
                 * dir : 西风
                 * sc : 微风
                 * spd : 10
                 */

                private String deg;
                private String dir;
                private String sc;
                private String spd;

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }

                public String getDeg() {
                    return deg;
                }

                public String getDir() {
                    return dir;
                }

                public String getSc() {
                    return sc;
                }

                public String getSpd() {
                    return spd;
                }
            }
        }

        public static class SuggestionBean {
            /**
             * air : {"brf":"较差","txt":"气象条件较不利于空气污染物稀释、扩散和清除，请适当减少室外活动时间。"}
             * comf : {"brf":"较不舒适","txt":"白天天气阴沉，您会感觉偏冷，不很舒适，请注意添加衣物，以防感冒。"}
             * cw : {"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"}
             * drsg : {"brf":"冷","txt":"天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。"}
             * flu : {"brf":"较易发","txt":"天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。"}
             * sport : {"brf":"较适宜","txt":"阴天，较适宜进行各种户内外运动。"}
             * trav : {"brf":"适宜","txt":"天气较好，气温稍低，会感觉稍微有点凉，不过也是个好天气哦。适宜旅游，可不要错过机会呦！"}
             * uv : {"brf":"最弱","txt":"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"}
             */

            private AirBean air;
            private ComfBean comf;
            private CwBean cw;
            private DrsgBean drsg;
            private FluBean flu;
            private SportBean sport;
            private TravBean trav;
            private UvBean uv;

            public void setAir(AirBean air) {
                this.air = air;
            }

            public void setComf(ComfBean comf) {
                this.comf = comf;
            }

            public void setCw(CwBean cw) {
                this.cw = cw;
            }

            public void setDrsg(DrsgBean drsg) {
                this.drsg = drsg;
            }

            public void setFlu(FluBean flu) {
                this.flu = flu;
            }

            public void setSport(SportBean sport) {
                this.sport = sport;
            }

            public void setTrav(TravBean trav) {
                this.trav = trav;
            }

            public void setUv(UvBean uv) {
                this.uv = uv;
            }

            public AirBean getAir() {
                return air;
            }

            public ComfBean getComf() {
                return comf;
            }

            public CwBean getCw() {
                return cw;
            }

            public DrsgBean getDrsg() {
                return drsg;
            }

            public FluBean getFlu() {
                return flu;
            }

            public SportBean getSport() {
                return sport;
            }

            public TravBean getTrav() {
                return trav;
            }

            public UvBean getUv() {
                return uv;
            }

            public static class AirBean {
                /**
                 * brf : 较差
                 * txt : 气象条件较不利于空气污染物稀释、扩散和清除，请适当减少室外活动时间。
                 */

                private String brf;
                private String txt;

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }

                public String getBrf() {
                    return brf;
                }

                public String getTxt() {
                    return txt;
                }
            }

            public static class ComfBean {
                /**
                 * brf : 较不舒适
                 * txt : 白天天气阴沉，您会感觉偏冷，不很舒适，请注意添加衣物，以防感冒。
                 */

                private String brf;
                private String txt;

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }

                public String getBrf() {
                    return brf;
                }

                public String getTxt() {
                    return txt;
                }
            }

            public static class CwBean {
                /**
                 * brf : 较适宜
                 * txt : 较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。
                 */

                private String brf;
                private String txt;

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }

                public String getBrf() {
                    return brf;
                }

                public String getTxt() {
                    return txt;
                }
            }

            public static class DrsgBean {
                /**
                 * brf : 冷
                 * txt : 天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。
                 */

                private String brf;
                private String txt;

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }

                public String getBrf() {
                    return brf;
                }

                public String getTxt() {
                    return txt;
                }
            }

            public static class FluBean {
                /**
                 * brf : 较易发
                 * txt : 天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。
                 */

                private String brf;
                private String txt;

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }

                public String getBrf() {
                    return brf;
                }

                public String getTxt() {
                    return txt;
                }
            }

            public static class SportBean {
                /**
                 * brf : 较适宜
                 * txt : 阴天，较适宜进行各种户内外运动。
                 */

                private String brf;
                private String txt;

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }

                public String getBrf() {
                    return brf;
                }

                public String getTxt() {
                    return txt;
                }
            }

            public static class TravBean {
                /**
                 * brf : 适宜
                 * txt : 天气较好，气温稍低，会感觉稍微有点凉，不过也是个好天气哦。适宜旅游，可不要错过机会呦！
                 */

                private String brf;
                private String txt;

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }

                public String getBrf() {
                    return brf;
                }

                public String getTxt() {
                    return txt;
                }
            }

            public static class UvBean {
                /**
                 * brf : 最弱
                 * txt : 属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。
                 */

                private String brf;
                private String txt;

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }

                public String getBrf() {
                    return brf;
                }

                public String getTxt() {
                    return txt;
                }
            }
        }

        public static class DailyForecastBean {
            /**
             * astro : {"mr":"17:20","ms":"06:29","sr":"07:55","ss":"18:38"}
             * cond : {"code_d":"104","code_n":"101","txt_d":"阴","txt_n":"多云"}
             * date : 2018-01-30
             * hum : 54
             * pcpn : 0.0
             * pop : 0
             * pres : 1024
             * tmp : {"max":"6","min":"0"}
             * uv : 3
             * vis : 14
             * wind : {"deg":"0","dir":"无持续风向","sc":"微风","spd":"5"}
             */

            private AstroBean astro;
            private CondBean cond;
            private String date;
            private String hum;
            private String pcpn;
            private String pop;
            private String pres;
            private TmpBean tmp;
            private String uv;
            private String vis;
            private WindBean wind;

            public void setAstro(AstroBean astro) {
                this.astro = astro;
            }

            public void setCond(CondBean cond) {
                this.cond = cond;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public void setTmp(TmpBean tmp) {
                this.tmp = tmp;
            }

            public void setUv(String uv) {
                this.uv = uv;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public AstroBean getAstro() {
                return astro;
            }

            public CondBean getCond() {
                return cond;
            }

            public String getDate() {
                return date;
            }

            public String getHum() {
                return hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public String getPop() {
                return pop;
            }

            public String getPres() {
                return pres;
            }

            public TmpBean getTmp() {
                return tmp;
            }

            public String getUv() {
                return uv;
            }

            public String getVis() {
                return vis;
            }

            public WindBean getWind() {
                return wind;
            }

            public static class AstroBean {
                /**
                 * mr : 17:20
                 * ms : 06:29
                 * sr : 07:55
                 * ss : 18:38
                 */

                private String mr;
                private String ms;
                private String sr;
                private String ss;

                public void setMr(String mr) {
                    this.mr = mr;
                }

                public void setMs(String ms) {
                    this.ms = ms;
                }

                public void setSr(String sr) {
                    this.sr = sr;
                }

                public void setSs(String ss) {
                    this.ss = ss;
                }

                public String getMr() {
                    return mr;
                }

                public String getMs() {
                    return ms;
                }

                public String getSr() {
                    return sr;
                }

                public String getSs() {
                    return ss;
                }
            }

            public static class CondBean {
                /**
                 * code_d : 104
                 * code_n : 101
                 * txt_d : 阴
                 * txt_n : 多云
                 */

                private String code_d;
                private String code_n;
                private String txt_d;
                private String txt_n;

                public void setCode_d(String code_d) {
                    this.code_d = code_d;
                }

                public void setCode_n(String code_n) {
                    this.code_n = code_n;
                }

                public void setTxt_d(String txt_d) {
                    this.txt_d = txt_d;
                }

                public void setTxt_n(String txt_n) {
                    this.txt_n = txt_n;
                }

                public String getCode_d() {
                    return code_d;
                }

                public String getCode_n() {
                    return code_n;
                }

                public String getTxt_d() {
                    return txt_d;
                }

                public String getTxt_n() {
                    return txt_n;
                }
            }

            public static class TmpBean {
                /**
                 * max : 6
                 * min : 0
                 */

                private String max;
                private String min;

                public void setMax(String max) {
                    this.max = max;
                }

                public void setMin(String min) {
                    this.min = min;
                }

                public String getMax() {
                    return max;
                }

                public String getMin() {
                    return min;
                }
            }

            public static class WindBean {
                /**
                 * deg : 0
                 * dir : 无持续风向
                 * sc : 微风
                 * spd : 5
                 */

                private String deg;
                private String dir;
                private String sc;
                private String spd;

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }

                public String getDeg() {
                    return deg;
                }

                public String getDir() {
                    return dir;
                }

                public String getSc() {
                    return sc;
                }

                public String getSpd() {
                    return spd;
                }
            }
        }

        public static class HourlyForecastBean {
            /**
             * cond : {"code":"104","txt":"阴"}
             * date : 2018-01-30 19:00
             * hum : 63
             * pop : 0
             * pres : 1025
             * tmp : 3
             * wind : {"deg":"319","dir":"西北风","sc":"微风","spd":"13"}
             */

            private CondBean cond;
            private String date;
            private String hum;
            private String pop;
            private String pres;
            private String tmp;
            private WindBean wind;

            public void setCond(CondBean cond) {
                this.cond = cond;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public CondBean getCond() {
                return cond;
            }

            public String getDate() {
                return date;
            }

            public String getHum() {
                return hum;
            }

            public String getPop() {
                return pop;
            }

            public String getPres() {
                return pres;
            }

            public String getTmp() {
                return tmp;
            }

            public WindBean getWind() {
                return wind;
            }

            public static class CondBean {
                /**
                 * code : 104
                 * txt : 阴
                 */

                private String code;
                private String txt;

                public void setCode(String code) {
                    this.code = code;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }

                public String getCode() {
                    return code;
                }

                public String getTxt() {
                    return txt;
                }
            }

            public static class WindBean {
                /**
                 * deg : 319
                 * dir : 西北风
                 * sc : 微风
                 * spd : 13
                 */

                private String deg;
                private String dir;
                private String sc;
                private String spd;

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }

                public String getDeg() {
                    return deg;
                }

                public String getDir() {
                    return dir;
                }

                public String getSc() {
                    return sc;
                }

                public String getSpd() {
                    return spd;
                }
            }
        }
    }
}
