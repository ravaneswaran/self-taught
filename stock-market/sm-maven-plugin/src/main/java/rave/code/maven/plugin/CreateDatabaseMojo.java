package rave.code.maven.plugin;

import org.apache.maven.plugin.MojoExecutionException;

public class CreateDatabaseMojo extends AbstractStockMarketMojo{

    private String fileName = "create-database.sql";

    public void execute() throws MojoExecutionException {
        this.executeFile(this.fileName);
    }
}
