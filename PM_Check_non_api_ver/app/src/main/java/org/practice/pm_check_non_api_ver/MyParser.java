package org.practice.pm_check_non_api_ver;

public class MyParser {
    static AirPollution ParseData(String str){
        AirPollution result = new AirPollution();


        if(!str.contains("TAB_TODAY :")){
            return null;
        }

        str = str.substring(str.indexOf("TAB_TODAY :"),str.indexOf("function(type, range, regionCode)"));

        if(str.contains("NITROGEN_DIOXIDE")){
            String tmp = str.substring(str.indexOf("NITROGEN_DIOXIDE"));
            tmp = tmp.substring(tmp.indexOf(" TODAY :"));
            tmp = tmp.substring(tmp.indexOf("value :"));
            result.no2_.SetValue(tmp.substring("value :'".length(), tmp.indexOf("',")));
            tmp = tmp.substring(tmp.indexOf("statusName :"));
            result.no2_.SetGrade(tmp.substring("statusName :'".length(), tmp.indexOf("',")));
            tmp = tmp.substring(tmp.indexOf("announce :"));
            result.no2_.SetTime(tmp.substring("announce : '".length(), tmp.indexOf("',")));
        }

        if(str.contains("OZONE")){
            String tmp = str.substring(str.indexOf("OZONE"));
            tmp = tmp.substring(tmp.indexOf(" TODAY :"));
            tmp = tmp.substring(tmp.indexOf("value :"));
            result.o3_.SetValue(tmp.substring("value :'".length(), tmp.indexOf("',")));
            tmp = tmp.substring(tmp.indexOf("statusName :"));
            result.o3_.SetGrade(tmp.substring("statusName :'".length(), tmp.indexOf("',")));
            tmp = tmp.substring(tmp.indexOf("announce :"));
            result.o3_.SetTime(tmp.substring("announce : '".length(), tmp.indexOf("',")));
        }

        if(str.contains("YELLOW_DUST")){
            String tmp = str.substring(str.indexOf("YELLOW_DUST"));
            tmp = tmp.substring(tmp.indexOf(" TODAY :"));
            tmp = tmp.substring(tmp.indexOf("value :"));
            result.dust_.SetValue(tmp.substring("value :'".length(), tmp.indexOf("',")));
            tmp = tmp.substring(tmp.indexOf("statusName :"));
            result.dust_.SetGrade(tmp.substring("statusName :'".length(), tmp.indexOf("',")));
            tmp = tmp.substring(tmp.indexOf("announce :"));
            result.dust_.SetTime(tmp.substring("announce : '".length(), tmp.indexOf("',")));
        }

        if(str.contains("ULTRA_FINE_PATICLE")){
            String tmp = str.substring(str.indexOf("ULTRA_FINE_PATICLE"));
            tmp = tmp.substring(tmp.indexOf(" TODAY :"));
            tmp = tmp.substring(tmp.indexOf("value :"));
            result.pm25_.SetValue(tmp.substring("value :'".length(), tmp.indexOf("',")));
            tmp = tmp.substring(tmp.indexOf("statusName :"));
            result.pm25_.SetGrade(tmp.substring("statusName :'".length(), tmp.indexOf("',")));
            tmp = tmp.substring(tmp.indexOf("announce :"));
            result.pm25_.SetTime(tmp.substring("announce : '".length(), tmp.indexOf("',")));
        }

        if(str.contains("ULTRAVIOLET")){
            String tmp = str.substring(str.indexOf("ULTRAVIOLET"));
            tmp = tmp.substring(tmp.indexOf(" TODAY :"));
            tmp = tmp.substring(tmp.indexOf("value :"));
            result.uv_.SetValue(tmp.substring("value :'".length(), tmp.indexOf("',")));
            tmp = tmp.substring(tmp.indexOf("statusName :"));
            result.uv_.SetGrade(tmp.substring("statusName :'".length(), tmp.indexOf("',")));
            tmp = tmp.substring(tmp.indexOf("announce :"));
            result.uv_.SetTime(tmp.substring("announce : '".length(), tmp.indexOf("',")));
        }

        if(str.contains("CARBON_MONOXIDE")){
            String tmp = str.substring(str.indexOf("CARBON_MONOXIDE"));
            tmp = tmp.substring(tmp.indexOf(" TODAY :"));
            tmp = tmp.substring(tmp.indexOf("value :"));
            result.co_.SetValue(tmp.substring("value :'".length(), tmp.indexOf("',")));
            tmp = tmp.substring(tmp.indexOf("statusName :"));
            result.co_.SetGrade(tmp.substring("statusName :'".length(), tmp.indexOf("',")));
            tmp = tmp.substring(tmp.indexOf("announce :"));
            result.co_.SetTime(tmp.substring("announce : '".length(), tmp.indexOf("',")));
        }

        if(str.contains("COMBINE_AIR")){
            String tmp = str.substring(str.indexOf("COMBINE_AIR"));
            tmp = tmp.substring(tmp.indexOf(" TODAY :"));
            tmp = tmp.substring(tmp.indexOf("value :"));
            result.khai_.SetValue(tmp.substring("value :'".length(), tmp.indexOf("',")));
            tmp = tmp.substring(tmp.indexOf("statusName :"));
            result.khai_.SetGrade(tmp.substring("statusName :'".length(), tmp.indexOf("',")));
            tmp = tmp.substring(tmp.indexOf("announce :"));
            result.khai_.SetTime(tmp.substring("announce : '".length(), tmp.indexOf("',")));
        }


        if(str.contains("FINE_DUST")){
            String tmp = str.substring(str.indexOf("FINE_DUST"));
            tmp = tmp.substring(tmp.indexOf(" TODAY :"));
            tmp = tmp.substring(tmp.indexOf("value :"));
            result.pm10_.SetValue(tmp.substring("value :'".length(), tmp.indexOf("',")));
            tmp = tmp.substring(tmp.indexOf("statusName :"));
            result.pm10_.SetGrade(tmp.substring("statusName :'".length(), tmp.indexOf("',")));
            tmp = tmp.substring(tmp.indexOf("announce :"));
            result.pm10_.SetTime(tmp.substring("announce : '".length(), tmp.indexOf("',")));
        }

        if(str.contains("SULFUROUS_ACID_GAS")){
            String tmp = str.substring(str.indexOf("SULFUROUS_ACID_GAS"));
            tmp = tmp.substring(tmp.indexOf(" TODAY :"));
            tmp = tmp.substring(tmp.indexOf("value :"));
            result.so2_.SetValue(tmp.substring("value :'".length(), tmp.indexOf("',")));
            tmp = tmp.substring(tmp.indexOf("statusName :"));
            result.so2_.SetGrade(tmp.substring("statusName :'".length(), tmp.indexOf("',")));
            tmp = tmp.substring(tmp.indexOf("announce :"));
            result.so2_.SetTime(tmp.substring("announce : '".length(), tmp.indexOf("',")));
        }

        return result;
    }

    static String OutputFormat(AirPollution data) {
        String result ="";

        if(data == null){
            result = "????????? ????????? ????????????";
            return result;
        }

        result += "???????????? PM 10 ??????/?????? : ";
        if(data.pm10_.GetValue() != null){
            result += data.pm10_.GetValue() + "/" + data.pm10_.GetGrade() + "\n?????? ?????? : " + data.pm10_.GetTime() + "\n\n";
        }else{
            result += "????????? ??????\n";
        }

        result += "??????????????? PM 2.5 ??????/?????? : ";
        if(data.pm25_.GetValue() != null){
            result += data.pm25_.GetValue() + "/" + data.pm25_.GetGrade() + "\n?????? ?????? : " + data.pm25_.GetTime() + "\n\n";
        }else{
            result += "????????? ??????\n";
        }

        result += "?????? ??????/?????? : ";
        if(data.o3_.GetValue() != null){
            result += data.o3_.GetValue() + "/" + data.o3_.GetGrade() + "\n?????? ?????? : " + data.o3_.GetTime() + "\n\n";
        }else{
            result += "????????? ??????\n";
        }

        result += "????????? ??????/?????? : ";
        if(data.uv_.GetValue() != null){
            result += data.uv_.GetValue() + "/" + data.uv_.GetGrade() + "\n?????? ?????? : " + data.uv_.GetTime() + "\n\n";
        }else{
            result += "????????? ??????\n";
        }

        result += "??????????????? ??????/?????? : ";
        if(data.so2_.GetValue() != null){
            result += data.so2_.GetValue() + "/" + data.so2_.GetGrade() + "\n?????? ?????? : " + data.so2_.GetTime() + "\n\n";
        }else{
            result += "????????? ??????\n";
        }

        result += "??????????????? ??????/?????? : ";
        if(data.co_.GetValue() != null){
            result += data.co_.GetValue() + "/" + data.co_.GetGrade() + "\n?????? ?????? : " + data.co_.GetTime() + "\n\n";
        }else{
            result += "????????? ??????\n";
        }

        result += "?????? ??????/?????? : ";
        if(data.dust_.GetValue() != null){
            result += data.dust_.GetValue() + "/" + data.dust_.GetGrade() + "\n?????? ?????? : " + data.dust_.GetTime() + "\n\n";
        }else{
            result += "????????? ??????\n";
        }

        result += "????????? ??????/?????? : ";
        if(data.uv_.GetValue() != null){
            result += data.uv_.GetValue() + "/" + data.uv_.GetGrade() + "\n?????? ?????? : " + data.uv_.GetTime() + "\n\n";
        }else{
            result += "????????? ??????\n";
        }

        result += "\n???????????????????????? ??????/?????? : ";
        if(data.khai_.GetValue() != null){
            result += data.khai_.GetValue() + "/" + data.khai_.GetGrade() + "\n?????? ?????? : " + data.khai_.GetTime() + "\n";
        }else{
            result += "????????? ??????\n";
        }

        return result;
    }
}
