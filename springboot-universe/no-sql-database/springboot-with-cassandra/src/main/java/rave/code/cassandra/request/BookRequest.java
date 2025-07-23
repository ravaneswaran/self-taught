package rave.code.cassandra.request;

public class BookRequest {

    private int id;
    private String title;
    private String description;
    private String author;
    private int year;
    private String dateCreated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDateCreated(){
	    return dateCreated;
    }

    public void setDateCreated(String dateCreated){
	    this.dateCreated = dateCreated;
    }
}
