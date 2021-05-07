
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CountriesController {

    URL url;
    String uri = "https://gist.githubusercontent.com/Yizack/bbfce31e0217a3689c8d961a356cb10d/raw/107e0bdf27918adea625410af0d340e8fc1cd5bf/countries.json";
    List<Country> countries;

    public CountriesController() throws Exception {
        url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64;) AppleWebKit/537.36 (KHTML, like Gecko) Chrome");
        connection.setRequestMethod("GET");
        connection.setReadTimeout(60 * 300);
        connection.setRequestProperty("Content-Type", "application/json");

        connection.connect();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
        String buffer = "";
        String response = "";
        while ((buffer = reader.readLine()) != null) {
            response += buffer;
        }
        JsonObject  object = new JsonObject (response);
        JsonArray  array = object.getJsonArray("countries");
        ArrayList<Country> countries = new ArrayList<>();
        for(int i=0; i<array.length(); i++){
            JsonObject obj = array.getJsonObject(i);
            Country c = new Country();
            c.setName_en(obj.get("name_en"));
            c.setName_es("name_es");
            c.setDial_code("dial_code");
            c.setCode("code");
            countries.add(c);
        }
    }

    public List<Country> list() {
        return this.countries;
    }

    public static void main(String[] args) {
        try {
            CountriesController ctrl = new CountriesController();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class Countries {
    List<Country> countries;

    public void setCountries(List<Country> lts) {
        countries = lts;
    }

    public List<Country> getCountries() {
        return countries;
    }
}