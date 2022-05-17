package utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeAdapter extends XmlAdapter<String, ZonedDateTime> {

    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String marshal(ZonedDateTime dateTime) {
        return dateTime.format(dateFormat);
    }
    //ZonedDateTime bugged asf dogshit class
    @Override
    public ZonedDateTime unmarshal(String dateTime) {
        return ZonedDateTime.of(LocalDateTime.parse(dateTime, dateFormat), ZoneId.systemDefault());
    }
}