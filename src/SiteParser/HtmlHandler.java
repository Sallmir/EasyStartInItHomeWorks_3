package SiteParser;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class HtmlHandler {
    public StringBuilder handleWebPage(String url) throws IOException {
        URL targetUrl = new URL(url);
        HttpsURLConnection connection = (HttpsURLConnection) targetUrl.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Chrome/41.0.2228.0");

        return getWebPage(connection);
    }

    private StringBuilder getWebPage(HttpsURLConnection connection) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder result = new StringBuilder();

        String nextString;

        while ((nextString=reader.readLine())!=null){
            result.append(nextString.toLowerCase());
        }
        return getBody(result);
    }

    private StringBuilder getBody(StringBuilder htmlDocument) {
        int openBodyTag = htmlDocument.indexOf("<body");
        int closeBodyTag  = htmlDocument.indexOf("</body");
        return new StringBuilder(htmlDocument.substring(openBodyTag, closeBodyTag));
    }

    public static void main(String[] args) throws IOException {
        HtmlHandler handler = new HtmlHandler();

        //System.out.println(handler.handleWebPage("https://eda.ru/recepty/osnovnye-blyuda/kurica-pikasso-25902"));

        ClearHtml htmlDoc = new ClearHtml();
        htmlDoc.setSiteText(handler.handleWebPage("https://eda.ru/recepty/osnovnye-blyuda/kurica-pikasso-25902"));
        System.out.println(htmlDoc.getSiteText());
        htmlDoc.deleteScripts();
        System.out.println(htmlDoc.getSiteText());



     /*
       // System.out.println(htmlDoc.deleteScripts());
        StringBuilder test = handler.handleWebPage("https://eda.ru/recepty/osnovnye-blyuda/kurica-pikasso-25902");
        System.out.println(test);
        //for (int i = 0; i <= 5; i++) {
            test.delete(test.indexOf("<script>"), test.indexOf("</script>") + 9);
        //}
        System.out.println(test);

       // System.out.println(htmlDoc.indexOf("<script>"));
      // System.out.println(htmlDoc.indexOf("</script>"));
      //  System.out.println(htmlDoc.delete(htmlDoc.indexOf("<script>"), htmlDoc.indexOf("</script>")+9));

      //  System.out.println(htmlDoc.delete(htmlDoc.indexOf("<"), htmlDoc.indexOf(">")+1));
        //System.out.println(htmlDoc.delete(htmlDoc.indexOf("<"), htmlDoc.indexOf(">")));
     */
    }
}
