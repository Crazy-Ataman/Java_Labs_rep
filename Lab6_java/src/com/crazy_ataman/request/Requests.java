package com.crazy_ataman.request;

import com.crazy_ataman.data.Citizen;
import com.crazy_ataman.data.City;

import java.sql.*;
import java.util.Scanner;

public class Requests {
    private final Connection connection;

    public Requests(Connection connection) {
        this.connection = connection;
    }

    public void getAllCitizensSelectedLanguage() throws SQLException {
        System.out.println("Selected city with selected language: ");
        String sqlreq = "select * from Citizens\n" +
                "where Citizens.Город_проживания = 'Молодечно' and\n" +
                "Citizens.Язык_общения = 'Белорусский язык'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlreq);
        while (resultSet.next()) {
            Citizen citizen = new Citizen();

            citizen.setCity(resultSet.getString(1));
            citizen.setNationality(resultSet.getString(2));
            citizen.setLanguage(resultSet.getString(3));

            System.out.println(citizen);
        }
    }

    public void getAllSelectedCitizensInCities() throws SQLException {
        System.out.println("Selected citizens in all cities: ");
        String sqlreq = "select * from Cities join Citizens\n" +
                "on Cities.Название = Citizens.Город_проживания\n" +
                "where Citizens.Название = 'Поляки'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlreq);
        while (resultSet.next()) {
            City city = new City();
            Citizen citizen = new Citizen();
            city.setName(resultSet.getString(1));
            city.setYear_of_found(resultSet.getInt(2));
            city.setArea(resultSet.getFloat(3));
            city.setCount_men(resultSet.getInt(4));
            city.setCount_women(resultSet.getInt(5));
            city.setCount_foreigner(resultSet.getInt(6));

            citizen.setCity(resultSet.getString(7));
            citizen.setNationality(resultSet.getString(8));
            citizen.setLanguage(resultSet.getString(9));

            System.out.println(city);
            System.out.println(citizen);
        }
    }

    public void getAllCitiesWithSelectedPopulation() throws SQLException {

//        System.out.println("All cities with selected population: ");
//        String sqlreq = "select * from Cities join Citizens\n" +
//                "on Cities.Название = Citizens.Город_проживания\n" +
//                "where Cities.Количество_населения_мужчин > 100000\n" +
//                "and Cities.Количество_населения_женщин > 150000";
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(sqlreq);
//        while (resultSet.next()) {
//            City city = new City();
//            Citizen citizen = new Citizen();
//            city.setName(resultSet.getString(1));
//            city.setYear_of_found(resultSet.getInt(2));
//            city.setArea(resultSet.getFloat(3));
//            city.setCount_men(resultSet.getInt(4));
//            city.setCount_women(resultSet.getInt(5));
//            city.setCount_foreigner(resultSet.getInt(6));
//
//            citizen.setCity(resultSet.getString(7));
//            citizen.setNationality(resultSet.getString(8));
//            citizen.setLanguage(resultSet.getString(9));
//
//            System.out.println(city);
//            System.out.println(citizen);

        System.out.println("All cities with selected population: ");
        String sqlreq = "select * from Cities join Citizens\n" +
                "on Cities.Название = Citizens.Город_проживания\n" +
                "where Cities.Количество_населения_мужчин > ?\n" +
                "and Cities.Количество_населения_женщин > ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlreq);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input value of Количество_населения_мужчин: ");
        int value1 = scanner.nextInt();
        System.out.println("Input value of Количество_населения_женщин: ");
        int value2 = scanner.nextInt();

        preparedStatement.setInt(1, value1);
        preparedStatement.setInt(2, value2);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            City city = new City();
            Citizen citizen = new Citizen();
            city.setName(resultSet.getString(1));
            city.setYear_of_found(resultSet.getInt(2));
            city.setArea(resultSet.getFloat(3));
            city.setCount_men(resultSet.getInt(4));
            city.setCount_women(resultSet.getInt(5));
            city.setCount_foreigner(resultSet.getInt(6));

            citizen.setCity(resultSet.getString(7));
            citizen.setNationality(resultSet.getString(8));
            citizen.setLanguage(resultSet.getString(9));

            System.out.println(city);
            System.out.println(citizen);
        }
    }

    public void getPopulationInTheOldestCity() throws SQLException {
        System.out.println("Population in the oldest city: ");
        String sqlreq = "select * from Cities join Citizens\n" +
                "on Cities.Название = Citizens.Город_проживания\n" +
                "where Cities.Год_основания = (select min(Cities.Год_основания) from Cities)\n";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlreq);
        while (resultSet.next()) {
            Citizen citizen = new Citizen();

            citizen.setCity(resultSet.getString(7));
            citizen.setNationality(resultSet.getString(8));
            citizen.setLanguage(resultSet.getString(9));

            System.out.println(citizen);
        }
    }
}
