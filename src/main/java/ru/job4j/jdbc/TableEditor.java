package ru.job4j.jdbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor() throws Exception {
        initProperties();
        initConnection();
    }

    private void initProperties() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("data/app.properties")) {
            properties.load(fileInputStream);
            this.properties = properties;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = properties.getProperty("hibernate.connection.url");
        String login = properties.getProperty("hibernate.connection.username");
        String password = properties.getProperty("hibernate.connection.password");
        this.connection = DriverManager.getConnection(url, login, password);
    }

    public void createTable(String tableName) throws Exception {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "create table if not exists %s();",
                    tableName
            );
            statement.execute(sql);
        }
    }

    private void statementExec(String string) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dropTable(String tableName) {
        String sql = String.format("drop table %s;", tableName);
        statementExec(sql);
    }

    public void addColumn(String tableName, String columnName, String type) {
        String sql = String.format(
                "alter table %s add column if not exists %s %s;", tableName, columnName, type);
        statementExec(sql);
    }

    public void dropColumn(String tableName, String columnName) {
        String sql = String.format(
                "alter table %s drop column if exists %s;", tableName, columnName);
        statementExec(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        String sql = String.format(
                "alter table %s rename column %s to %s;", tableName, columnName, newColumnName);
        statementExec(sql);
    }

    public String getScheme(String tableName) throws Exception {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}