package rave.code.maven.plugin;

import org.apache.maven.plugin.MojoExecutionException;

public class DropDatabaseMojo extends AbstractStockMarketMojo{

    private String fileName = "drop-database.sql";

    public void execute() throws MojoExecutionException {
        this.executeFile(this.fileName);
    }
}
