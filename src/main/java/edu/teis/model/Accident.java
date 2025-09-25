package edu.teis.model;

import edu.teis.utils.Utils;

import java.text.ParseException;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

public class Accident {
    private final String num_expedient;
    private final Date date;
    private final LocalTime time;
    private final String localization;
    private final String case_number;
    private final Integer district_code;
    private final String district_name;
    private final String accident_type;
    private final Optional<String> weather;
    private final String vehicle_type;
    private final String person_type;
    private final String person_agerange;
    private final String person_gender;
    private final Optional<Integer> harm_code;
    private final Optional<String> harm;
    private final Long coords_x;
    private final Long coords_y;
    private final Boolean alcohol;
    private final Boolean drugs;

    public Accident(String num_expedient,
                    String date,
                    String time,
                    String localization,
                    String case_number,
                    String district_code,
                    String district_name,
                    String accident_type,
                    String weather,
                    String vehicle_type,
                    String person_type,
                    String person_agerange,
                    String person_gender,
                    String harm_code,
                    String harm,
                    String coords_x,
                    String coords_y,
                    String alcohol,
                    String drugs) throws ParseException {
        this.num_expedient = num_expedient;
        this.date = Utils.stringToDate(date);
        this.time = Utils.stringToTime(time);
        this.localization = localization;
        this.case_number = case_number;
        this.district_code = Integer.parseInt(district_code);
        this.district_name = district_name;
        this.accident_type = accident_type;
        this.weather = weather.isEmpty() ? Optional.empty() : Optional.of(weather);
        this.vehicle_type = vehicle_type;
        this.person_type = person_type;
        this.person_agerange = person_agerange;
        this.person_gender = person_gender;
        this.harm_code = harm_code.isEmpty() ? Optional.empty() : Optional.of(Integer.parseInt(harm_code));
        this.harm = harm.isEmpty() ? Optional.empty() : Optional.of(harm);
        this.coords_x = coords_x.isEmpty() ? 0 : Long.parseLong(coords_x);
        this.coords_y = coords_y.isEmpty() ? 0 : Long.parseLong(coords_y);
        this.alcohol = !alcohol.isEmpty() && !alcohol.equals("N");
        this.drugs = !drugs.isEmpty();
    }

    public String getNum_expedient() {
        return num_expedient;
    }

    public String getPerson_gender(){
        return person_gender;
    }

    public Month getMonth_fromdate(){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getMonth();
    }

    public String getAccident_type() {
        return accident_type;
    }

    public Boolean getAlcohol() {
        return alcohol;
    }

    public Boolean getDrugs() {
        return drugs;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Accidente ").append(getNum_expedient()).toString();
    }
}
