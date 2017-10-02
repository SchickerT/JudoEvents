package entity.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//https://www.jorgenringen.com/2015/05/23/jsr310-java-time-api-with-jax-rs/
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    @Override
    public LocalDate unmarshal(String dateInput) throws Exception {
        return LocalDate.parse(dateInput, DateTimeFormatter.ISO_DATE);
    }
    @Override
    public String marshal(LocalDate localDate) throws Exception {
        return DateTimeFormatter.ISO_DATE.format(localDate);
    }
}