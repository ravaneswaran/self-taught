package rave.code;

import java.util.List;

public abstract class HTMLSourceParser<T> {

    private String sourceUrl;

    public HTMLSourceParser(String sourceUrl){
        this.sourceUrl = sourceUrl;
    }

    public abstract List<T> parse();

    public T get(int index){
        return this.parse().get(index);
    }

    public String getSourceUrl(){
        return this.sourceUrl;
    }
}
