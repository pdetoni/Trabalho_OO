package Classes.Data;

import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

//Classe necessária para adaptar o formato desejado de data para o formato do Gson
public class GsonDateAdapter extends TypeAdapter<Date> {

    private final DateFormat df;

    public GsonDateAdapter() {
        df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Override
    public void write(JsonWriter out, Date value) throws IOException {
        if (value == null) {
            out.nullValue();
        } else {
            String valueAsString = df.format(value);
            out.value(valueAsString);
        }
    }

    @Override
    public Date read(JsonReader in) throws IOException {
        if (in != null) {
            try {
                return df.parse(in.nextString());
            } catch (ParseException e) {
                throw new JsonParseException(e);
            }
        } else {
            return null;
        }
    }
}