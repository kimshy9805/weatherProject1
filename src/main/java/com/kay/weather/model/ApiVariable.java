package com.kay.weather.model;


//static final한번 initilizaed되면 절대 못바뀜
//final은 class 마다 다른값을 가질수 있음.
//static은 class 전체에서 share하는것들 object단위가 아님
//non-static class의 object들이 가질숭 있는것들.
//기준을 object마다 다른값을 가지냐 아니면 class기준에서 같은 값들을 가질것이냐 차이로
//private 함부로 class외부에서 attribute값들을 바꿀수 없게 하는 getter와 setter로만 가능하게

// TODO: 12/02/2021 apivaribale들을 이용해서 service layer해서 URL만들고 openweatherapi로 전달해서 getmapping으로 값얻기.


public class ApiVariable {
    private final String cityId;
    private final String unit;
    private static final String API_KEY = "320044c0cf7b1d685ff79af4bff6bb97";
    private StringBuilder apiUri = new StringBuilder("api.openweathermap.org/data/2.5/weather?");


    public ApiVariable(String unit, String cityId) {
        this.unit = unit;
        this.cityId = cityId;
    }

    //이게 안됨. Bean때문인건지 모르겟는데
    //Parameter 0 of constructor in com.kay.weather.controller.api.OpenWeatherApi required a bean of type 'com.kay.weather.model.ApiVariable' that could not be found.
    public StringBuilder getApiUri() {
        return apiUri;
    }

    public void setApiUri(StringBuilder apiUri) {
        this.apiUri = apiUri;
    }

    public String getCityId() {
        return cityId;
    }

    public String getUnit() {
        return unit;
    }

    public static String getApiKey() {
        return API_KEY;
    }
}
