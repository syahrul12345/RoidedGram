package model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Creator extends Observable implements Runnable {

    private final int accToCreate;
    private List<String> cookies;
    private HttpsURLConnection conn;
    private final String USER_AGENT = "Mozilla/5.0";
    private List<String> userList = new ArrayList<String>();


    public Creator(int accToCreate) throws IOException {
        //String page = getFormInfo();
        this.accToCreate = accToCreate;

    }

    private String getFormInfo() throws IOException {
        String url = "https://www.instagram.com/?hl=en";
        URL obj = new URL(url);
        conn = (HttpsURLConnection) obj.openConnection();
        // default is   GET
        conn.setRequestMethod("GET");

        conn.setUseCaches(false);

        // act like a browser
        conn.setRequestProperty("User-Agent", USER_AGENT);
        conn.setRequestProperty("Accept",
                "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        if (cookies != null) {
            for (String cookie : this.cookies) {
                conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
            }
        }
        int responseCode = conn.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in =
                new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Get the response cookies
        setCookies(conn.getHeaderFields().get("Set-Cookie"));

        return response.toString();


    }

    public void setCookies(List<String> cookies) {
        this.cookies = cookies;

    }


    public List<String> getUserName() throws IOException {
        for(int i=0;i<accToCreate;i++) {
            String user = "";
            String url = "https://www.behindthename.com/random/random.php?number=2&gender=m&surname=&all=yes";
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.getElementsByClass("plain");
            for(Element element: elements) {
                user = user + element.text();
            }
            userList.add(user);

        }
        System.out.println(userList);
        return userList;
    }

    @Override
    public void run() {
        try {
            getUserName();
            createAccount();
            setChanged();
            notifyObservers();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
