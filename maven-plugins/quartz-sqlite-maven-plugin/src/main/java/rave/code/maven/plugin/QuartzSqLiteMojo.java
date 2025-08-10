package rave.code.maven.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class QuartzSqLiteMojo extends AbstractMojo {

    @Parameter(property = "jdbcUrl", required = true)
    protected String jdbcUrl;
    @Parameter(property = "driver", required = true)
    protected String driver;
    @Parameter(property = "username", required = true)
    protected String username;
    @Parameter(property = "password", required = true)
    protected String password;
    @Parameter(property = "prefix", required = false, defaultValue = "QRTZ_")
    protected String prefix;

    protected void executeFile(String fileName) {
        getLog().info(String.format("Executing the file -- %s", fileName));
        try (InputStream inputStream = this.getClass().getResourceAsStream("/" + fileName);
             Connection connection = DriverManager.getConnection(this.jdbcUrl, this.username, this.password);
             Statement statement = connection.createStatement();

             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            StringBuilder sqlBuilder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                // Skip comments and empty lines
                line = line.trim();
                if (line.isEmpty() || line.startsWith("--") || line.startsWith("//") || line.startsWith("#")) {
                    continue;
                }

                sqlBuilder.append(line).append(" ");
                // If we reached a semicolon, execute the statement
                if (line.endsWith(";")) {
                    String sql = sqlBuilder.toString();
                    sql = sql.substring(0, sql.length() - 1).replaceAll("QRTZ_", this.prefix);; // remove last semicolon
                    getLog().info(String.format("mysql> %s%s", sql, "\n"));
                    statement.execute(sql);
                    sqlBuilder.setLength(0); // reset buffer
                }
            }
        } catch (SQLException sqlException) {
            getLog().error(sqlException.getMessage(), sqlException);
        } catch (FileNotFoundException fileNotFoundException) {
            getLog().error(fileNotFoundException.getMessage(), fileNotFoundException);
        } catch (IOException ioException) {
            getLog().error(ioException.getMessage(), ioException);
        }
    }
}
