package org.practice.pm_check;

public class MyParser {
    static AirPollution ParseData(String str){
        AirPollution data = new AirPollution();

        if(!str.contains("<item>")){
            return null;
        }

        str = str.substring(0, str.indexOf("</item>"));

        if(str.contains("<item>")){
            if(str.contains("<dataTime>")){
                data.SetDataTime(str.substring(str.indexOf("<dataTime>") + "<dataTime>".length(), str.indexOf("</dataTime>")));
            }

            if(str.contains("<so2Grade>")){
                data.so2_.SetGrade(str.substring(str.indexOf("<so2Grade>") + "<so2Grade>".length(), str.indexOf("</so2Grade>")));
            }

            if(str.contains("<so2Flag>")){
                data.so2_.SetFlag(str.substring(str.indexOf("<so2Flag>") + "<so2Flag>".length(), str.indexOf("</so2Flag>")));
            }

            if(str.contains("<so2Value>")){
                data.so2_.SetValue(str.substring(str.indexOf("<so2Value>") + "<so2Value>".length(), str.indexOf("</so2Value>")));
            }

            if(str.contains("<coGrade>")){
                data.co_.SetGrade(str.substring(str.indexOf("<coGrade>") + "<coGrade>".length(), str.indexOf("</coGrade>")));
            }

            if(str.contains("<coFlag>")){
                data.co_.SetFlag(str.substring(str.indexOf("<coFlag>") + "<coFlag>".length(), str.indexOf("</coFlag>")));
            }

            if(str.contains("<coValue>")){
                data.co_.SetValue(str.substring(str.indexOf("<coValue>") + "<coValue>".length(), str.indexOf("</coValue>")));
            }

            if(str.contains("<khaiValue>")){
                data.khai_.SetValue(str.substring(str.indexOf("<khaiValue>") + "<khaiValue>".length(), str.indexOf("</khaiValue>")));
            }

            if(str.contains("<khaiGrade>")){
                data.khai_.SetGrade(str.substring(str.indexOf("<khaiGrade>") + "<khaiGrade>".length(), str.indexOf("</khaiGrade>")));
            }

            if(str.contains("<pm10Value>")){
                data.pm10_.SetValue(str.substring(str.indexOf("<pm10Value>") + "<pm10Value>".length(), str.indexOf("</pm10Value>")));
            }

            if(str.contains("<pm10Flag>")){
                data.pm10_.SetFlag(str.substring(str.indexOf("<pm10Flag>") + "<pm10Flag>".length(), str.indexOf("</pm10Flag>")));
            }

            if(str.contains("<pm10Grade>")){
                data.pm10_.SetGrade(str.substring(str.indexOf("<pm10Grade>") + "<pm10Grade>".length(), str.indexOf("</pm10Grade>")));
            }

            if(str.contains("<pm25Value>")){
                data.pm25_.SetValue(str.substring(str.indexOf("<pm25Value>") + "<pm25Value>".length(), str.indexOf("</pm25Value>")));
            }

            if(str.contains("<pm25Flag>")){
                data.pm25_.SetFlag(str.substring(str.indexOf("<pm25Flag>") + "<pm25Flag>".length(), str.indexOf("</pm25Flag>")));
            }

            if(str.contains("<pm25Grade>")){
                data.pm25_.SetGrade(str.substring(str.indexOf("<pm25Grade>") + "<pm25Grade>".length(), str.indexOf("</pm25Grade>")));
            }

            if(str.contains("<o3Grade>")){
                data.o3_.SetGrade(str.substring(str.indexOf("<o3Grade>") + "<o3Grade>".length(), str.indexOf("</o3Grade>")));
            }

            if(str.contains("<o3Value>")){
                data.o3_.SetValue(str.substring(str.indexOf("<o3Value>") + "<o3Value>".length(), str.indexOf("</o3Value>")));
            }

            if(str.contains("<o3Flag>")){
                data.o3_.SetFlag(str.substring(str.indexOf("<o3Flag>") + "<o3Flag>".length(), str.indexOf("</o3Flag>")));
            }


            if(str.contains("<no2Grade>")){
                data.no2_.SetGrade(str.substring(str.indexOf("<no2Grade>") + "<no2Grade>".length(), str.indexOf("</no2Grade>")));
            }

            if(str.contains("<no2Value>")){
                data.no2_.SetValue(str.substring(str.indexOf("<no2Value>") + "<no2Value>".length(), str.indexOf("</no2Value>")));
            }

            if(str.contains("<no2Flag>")){
                data.no2_.SetFlag(str.substring(str.indexOf("<no2Flag>") + "<no2Flag>".length(), str.indexOf("</no2Flag>")));
            }
        }else{
            return null;
        }

        return data;
    }

    static String OutputFormat(AirPollution data){
        String result = "";

        if(data == null){
            result = "측정소 정보가 없습니다";
            return result;
        }

        result+= "측정 시각 : " + data.GetDataTime() + "\n";

        if(data.pm10_.GetFlag() == null){
            result += "미세먼지 PM 10 농도/등급 : " + data.pm10_.GetValue() + "/" + data.pm10_.GetGrade() + "\n";
        }else{
            result += "미세먼지 PM 10 농도/등급 : " + data.pm10_.GetFlag() + "\n";
        }

        if(data.pm25_.GetFlag() == null){
            //result += "미세먼지 PM 2.5 농도/등급 : " + data.pm25_.GetValue() + "/" + data.pm25_.GetGrade() + "\n";
        }else{
            //result += "미세먼지 PM 2.5 농도/등급 : " + data.pm10_.GetFlag() + "\n";
        }

        if(data.o3_.GetFlag() == null){
            result += "오존 농도/등급 : " + data.o3_.GetValue() + "/" + data.o3_.GetGrade() + "\n";
        }else{
            result += "오존 농도/등급 : " + data.o3_.GetFlag() + "\n";
        }

        if(data.co_.GetFlag() == null){
            result += "일산화탄소 농도/등급 : " + data.co_.GetValue() + "/" + data.co_.GetGrade() + "\n";
        }else{
            result += "일산화탄소 농도/등급 : " + data.co_.GetFlag() + "\n";
        }

        if(data.no2_.GetFlag() == null){
            result += "이산화질소 농도/등급 : " + data.no2_.GetValue() + "/" + data.no2_.GetGrade() + "\n";
        }else{
            result += "이산화질소 농도/등급 : " + data.no2_.GetFlag() + "\n";
        }

        if(data.so2_.GetFlag() == null){
            result += "아황산가스 농도/등급 : " + data.so2_.GetValue() + "/" + data.so2_.GetGrade() + "\n";
        }else{
            result += "아황산가스 농도/등급 : " + data.so2_.GetFlag() + "\n";
        }

        result += "\n통합대기환경수치 : " + data.khai_.GetValue() + "\n" + "통합대기환경지수 : " + data.khai_.GetGrade() + "\n";

        return result;
    }
}
