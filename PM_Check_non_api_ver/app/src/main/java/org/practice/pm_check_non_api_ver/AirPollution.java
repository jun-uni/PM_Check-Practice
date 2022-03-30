package org.practice.pm_check_non_api_ver;

public class AirPollution {
    PollutionData so2_;     //아황산가스 SULFUROUS_ACID_GAS
    PollutionData co_;      //일산화탄소 CARBON_MONOXIDE
    PollutionData pm10_;    //미세먼지 PM 10 FINE_DUST
    PollutionData pm25_;    //미세먼지 PM 2.5 ULTRA_FINE_PATICLE
    PollutionData o3_;      //오존 OZONE
    PollutionData khai_;    //통합대기환경 COMBINE_AIR
    PollutionData no2_;     //이산화질소 NITROGEN_DIOXIDE
    PollutionData dust_;    //황사 YELLOW_DUST
    PollutionData uv_;      //자외선 ULTRAVIOLET


    AirPollution(){
        so2_ = new PollutionData();
        co_ = new PollutionData();
        pm10_ = new PollutionData();
        pm25_ = new PollutionData();
        o3_ = new PollutionData();
        khai_ = new PollutionData();
        no2_ = new PollutionData();
        dust_ = new PollutionData();
        uv_ = new PollutionData();
    }

    static class PollutionData{
        private String grade_;
        private String value_;
        private String time_;

        protected void SetGrade(String grade){ this.grade_ = grade; }

        protected void SetValue(String value){
            this.value_ = value;
        }

        protected void SetTime(String time){ this.time_ = time; }

        protected String GetGrade(){
            return grade_;
        }

        protected String GetValue(){
            return value_;
        }

        protected String GetTime() { return time_; }

    }
}
