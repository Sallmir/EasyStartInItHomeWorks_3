package SiteParser;

public class ClearHtml {

    private StringBuilder siteText;



    public StringBuilder getSiteText() {
        return siteText;
    }

    public void setSiteText(StringBuilder siteText) {
        this.siteText = siteText;
    }



    public StringBuilder deleteScripts(){

        int scripts = siteText.indexOf("<script>");
        int scriptsEnd = siteText.indexOf("</script>");
        int i = 0;

        while (i <= 5) {
            siteText.replace(scripts, scriptsEnd + 9, "");
            i++;
        }



        //siteText.delete(siteText.indexOf("<script>"), siteText.indexOf("</script>")+9);

        return siteText;
    }

}
