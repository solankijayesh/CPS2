package com.example.damo.djg;

/**
 * Created by DamO on 04-04-2017.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExResponse {

        @SerializedName("0")
        @Expose
        private String _0;
        @SerializedName("adharnumber")
        @Expose
        private String adharnumber;
        @SerializedName("1")
        @Expose
        private String _1;
        @SerializedName("units")
        @Expose
        private String units;
        @SerializedName("2")
        @Expose
        private String _2;
        @SerializedName("amount")
        @Expose
        private String amount;
        @SerializedName("3")
        @Expose
        private String _3;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("4")
        @Expose
        private String _4;
        @SerializedName("Date")
        @Expose
        private String date;

        public String get0() {
            return _0;
        }

        public void set0(String _0) {
            this._0 = _0;
        }

        public String getAdharnumber() {
            return adharnumber;
        }

        public void setAdharnumber(String adharnumber) {
            this.adharnumber = adharnumber;
        }

        public String get1() {
            return _1;
        }

        public void set1(String _1) {
            this._1 = _1;
        }

        public String getUnits() {
            return units;
        }

        public void setUnits(String units) {
            this.units = units;
        }

        public String get2() {
            return _2;
        }

        public void set2(String _2) {
            this._2 = _2;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String get3() {
            return _3;
        }

        public void set3(String _3) {
            this._3 = _3;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String get4() {
            return _4;
        }

        public void set4(String _4) {
            this._4 = _4;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

    }
