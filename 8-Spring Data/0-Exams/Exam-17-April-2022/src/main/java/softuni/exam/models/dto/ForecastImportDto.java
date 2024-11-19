package softuni.exam.models.dto;

import softuni.exam.models.enums.Weekday;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "forecast")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastImportDto {
    @XmlElement(name = "day_of_week")
    @NotNull
    private Weekday dayOfWeek;
    @XmlElement(name = "max_temperature")
    @NotNull
    @DecimalMin("-20") @DecimalMax("60")
    private BigDecimal maxTemperature;
    @XmlElement(name = "min_temperature")
    @NotNull
    @DecimalMin("-50") @DecimalMax("40")
    private BigDecimal minTemperature;
    @XmlElement
    @NotNull
    private String sunrise;
    @XmlElement
    @NotNull
    private String sunset;
    private Long city;

    public ForecastImportDto() {}

    public @NotNull Weekday getWeekday() {
        return dayOfWeek;
    }

    public void setWeekday(@NotNull Weekday weekday) {
        this.dayOfWeek = weekday;
    }

    public @NotNull @DecimalMin("-20") @DecimalMax("60") BigDecimal getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(@NotNull @DecimalMin("-20") @DecimalMax("60") BigDecimal maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public @NotNull @DecimalMin("-50") @DecimalMax("40") BigDecimal getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(@NotNull @DecimalMin("-50") @DecimalMax("40") BigDecimal minTemperature) {
        this.minTemperature = minTemperature;
    }

    public @NotNull String getSunrise() {
        return sunrise;
    }

    public void setSunrise(@NotNull String sunrise) {
        this.sunrise = sunrise;
    }

    public @NotNull String getSunset() {
        return sunset;
    }

    public void setSunset(@NotNull String sunset) {
        this.sunset = sunset;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }
}
