package org.practice.pm_check;

public class AirPollution {
    PollutionData so2_;     //아황산가스
    PollutionData co_;      //일산화탄소
    PollutionData pm10_;    //미세먼지 PM 10
    PollutionData pm25_;    //미세먼지 PM 2.5
    PollutionData o3_;      //오존
    PollutionData khai_;    //통합대기환경
    PollutionData no2_;
    private String data_time_;

    AirPollution(){
        so2_ = new PollutionData();
        co_ = new PollutionData();
        pm10_ = new PollutionData();
        pm25_ = new PollutionData();
        o3_ = new PollutionData();
        khai_ = new PollutionData();
        no2_ = new PollutionData();
    }

    protected void SetDataTime(String data_time){
        this.data_time_ = data_time;
    }

    protected String GetDataTime(){
        return data_time_;
    }

    static class PollutionData{
        private String grade_;
        private String value_;
        private String flag_;

        protected void SetGrade(String grade){
            this.grade_ = grade;
        }

        protected void SetValue(String value){
            this.value_ = value;
        }

        protected void SetFlag (String flag){
            this.flag_ = flag;
        }

        protected String GetGrade(){
            return grade_;
        }

        protected String GetValue(){
            return value_;
        }

        protected String GetFlag(){
            return flag_;
        }
    }
}
