package entities;

import java.sql.Date;
import java.util.Objects;

public class HourContract {
    
    private Date date;
    private Double valuePerHour;
    private Integer hours;

    public HourContract() {
    }

    public HourContract(Date date, Double valuePerHour, Integer hours) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValuePerHour() {
        return this.valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Integer getHours() {
        return this.hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public HourContract date(Date date) {
        setDate(date);
        return this;
    }

    public HourContract valuePerHour(Double valuePerHour) {
        setValuePerHour(valuePerHour);
        return this;
    }

    public HourContract hours(Integer hours) {
        setHours(hours);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof HourContract)) {
            return false;
        }
        HourContract hourContract = (HourContract) o;
        return Objects.equals(date, hourContract.date) && Objects.equals(valuePerHour, hourContract.valuePerHour) && Objects.equals(hours, hourContract.hours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, valuePerHour, hours);
    }

    @Override
    public String toString() {
        return "{" +
            " date='" + getDate() + "'" +
            ", valuePerHour='" + getValuePerHour() + "'" +
            ", hours='" + getHours() + "'" +
            "}";
    }



}
