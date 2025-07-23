package rave.code.cassandra.table;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Table("book")
public class Book {

    @PrimaryKey
    private int id;
    private String title;
    private String description;
    private String author;
    private int year;
    private String dateCreated;

}
