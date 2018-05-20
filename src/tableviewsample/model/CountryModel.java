/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableviewsample.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author bradd
 */
public class CountryModel {
    
    private final SimpleIntegerProperty countryId;
    private final SimpleStringProperty country;
    private final SimpleStringProperty createDate;
    private final SimpleStringProperty createdBy;
    private final SimpleStringProperty lastUpdate;
    private final SimpleStringProperty lastUpdateBy;
 
    public CountryModel(int countryId, String country, String createDate, String createdBy, String lastUpdate, String lastUpdateBy) {
        this.countryId = new SimpleIntegerProperty(countryId);
        this.country = new SimpleStringProperty(country);
        this.createDate = new SimpleStringProperty(createDate);
        this.createdBy = new SimpleStringProperty(createdBy);
        this.lastUpdate = new SimpleStringProperty(lastUpdate);
        this.lastUpdateBy = new SimpleStringProperty(lastUpdateBy);
    }
 
    public int getCountryId() {
        return countryId.get();
    }

    public void setCountryId(int _countryId) {
        countryId.set(_countryId);
    }

    public String getCountry() {
        return country.get();
    }

    public void setCountry(String _country) {
        country.set(_country);
    }

    public String getCreateDate() {
        return createDate.get();
    }

    public void setCreateDate(String _createDate) {
        createDate.set(_createDate);
    }

    public String getCreatedBy() {
        return createdBy.get();
    }

    public void setCreatedBy(String _createdBy) {
        createdBy.set(_createdBy);
    }

    public String getLastUpdate() {
        return lastUpdate.get();
    }

    public void setLastUpdate(String _lastUpdate) {
        lastUpdate.set(_lastUpdate);
    }

    public String getLastUpdateBy() {
        return lastUpdateBy.get();
    }

    public void setLastUpdateBy(String _lastUpdateBy) {
        lastUpdateBy.set(_lastUpdateBy);
    }
}
