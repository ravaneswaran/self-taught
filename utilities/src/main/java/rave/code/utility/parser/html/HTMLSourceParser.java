package rave.code.utility.parser.html;

public abstract class HTMLSourceParser {

    private String sourceUrl;

    public HTMLSourceParser(String sourceUrl){
        this.sourceUrl = sourceUrl;
    }

    public abstract void parse();

    public String getSourceUrl(){
        return this.sourceUrl;
    }
}
