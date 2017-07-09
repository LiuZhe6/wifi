package cn.wust.util;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by root on 17-5-8.
 */
public class InfoReport {
    //
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

    private String id;
    private ArrayList<OneCol> data;
    private String mmac;
    private String rate;
    private String time;
    private String lat;
    private String lon;

    public InfoReport(String id, ArrayList<InfoReport.OneCol> data, String mmac, String rate, String time, String lat, String lon) {
        this.id = id;
        this.data = data;
        this.mmac = mmac;
        this.rate = rate;
        this.time = time;
        this.lat = lat;
        this.lon = lon;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<InfoReport.OneCol> getData() {
        return this.data;
    }

    public void setData(ArrayList<InfoReport.OneCol> data) {
        this.data = data;
    }

    public String getMmac() {
        return this.mmac;
    }

    public void setMmac(String mmac) {
        this.mmac = mmac;
    }

    public String getRate() {
        return this.rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return this.lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public static class OneCol {
        private String mac;
        private String rssi;
        private String ts = "NULL";
        private String tmc = "NULL";
        private String tc = "NULL";

        public OneCol(String mac, String rssi, String ts, String tmc, String tc) {
            this.mac = mac;
            this.rssi = rssi;
            this.ts = ts;
            this.tmc = tmc;
            this.tc = tc;
        }

        public String getMac() {
            return this.mac;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public String getRssi() {
            return this.rssi;
        }

        public void setRssi(String rssi) {
            this.rssi = rssi;
        }

        public String getTs() {
            return this.ts;
        }

        public void setTs(String ts) {
            this.ts = ts;
        }

        public String getTmc() {
            return this.tmc;
        }

        public void setTmc(String tmc) {
            this.tmc = tmc;
        }

        public String getTc() {
            return this.tc;
        }

        public void setTc(String tc) {
            this.tc = tc;
        }
    }
}

