package converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;

import datamodel.Source;

public class DataConverter implements Serializable {
    @TypeConverter
    public String fromOptionValuesList(Source optionValues) {
        if (optionValues == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Source>() {
        }.getType();
        String json = gson.toJson(optionValues, type);
        return json;
    }

    @TypeConverter // note this annotation
    public Source toOptionValuesList(String optionValuesString) {
        if (optionValuesString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Source>() {
        }.getType();
        Source productCategoriesList = gson.fromJson(optionValuesString, type);
        return productCategoriesList;
    }
}
