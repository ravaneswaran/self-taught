package rave.code.maven.plugin;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "dropdb")
public class DropDatabaseMojo extends AbstractStockMarketMojo{

    private String fileName = "drop-database.sql";

    public void execute() throws MojoExecutionException {
        this.executeFile(this.fileName);
    }
}
