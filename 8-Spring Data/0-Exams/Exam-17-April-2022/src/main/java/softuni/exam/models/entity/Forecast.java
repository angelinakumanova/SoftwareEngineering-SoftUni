package softuni.exam.models.entity;

import softuni.exam.models.enums.Weekday;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Time;

@Entity
@Table(name = "forecasts")
public class Forecast extends BaseEntity{
    @Column(name = "day_of_week", nullable = false)
    private Weekday dayOfWeek;
    @Column(name = "max_temperature", nullable = false)
    private Double maxTemperature;
    @Column(name = "min_temperature", nullable = false)
    private Double minTemperature;
    @Column(nullable = false)
    private Time sunrise;
    @Column(nullable = false)
    private Time sunset;
    @ManyToOne
    private City city;

    public Forecast() {}

    public Weekday getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Weekday dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Time getSunrise() {
        return sunrise;
    }

    public void setSunrise(Time sunrise) {
        this.sunrise = sunrise;
    }

    public Time getSunset() {
        return sunset;
    }

    public void setSunset(Time sunset) {
        this.sunset = sunset;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
