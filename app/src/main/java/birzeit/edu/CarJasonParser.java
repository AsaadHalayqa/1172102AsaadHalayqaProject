package birzeit.edu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CarJasonParser {

    public static List<Car> getObjectFromJason(String CarJason) {

        List<Car> cars;
        JSONArray jsonArray;
        try {
            jsonArray  = new JSONArray(CarJason);
            cars = new ArrayList<>();
            for(int k = 0; k<jsonArray.length(); k++)
            {
                JSONObject jsonObject = new JSONObject();
                jsonObject= (JSONObject) jsonArray.get(k);
                Car NewCar = new Car();
                NewCar.setYear(jsonObject.getString("year"));
                NewCar.setMake(jsonObject.getString("make"));
                NewCar.setModel(jsonObject.getString("model"));
                NewCar.setDistance(jsonObject.getString("distance"));
                NewCar.setPrice(jsonObject.getString("price"));
                NewCar.setAccidents(jsonObject.getString("accidents"));

                cars.add(NewCar);
            }
        } catch (JSONException e)
        {
            e.printStackTrace();
            return null;
        }
        return cars;
    }
}
