package test.time1_8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;

/**
 * @author guoqb
 * @date : 2020/1/29 17:04
 * @descript
 */
public class Test {
    public static void main(String[] args) {

        LocalDateTime dateTime = LocalDateTime.now();

        LocalDate date = LocalDate.now();
        System.out.println(date);
        date = date.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(date);
        date = date.withDayOfMonth(29);
        System.out.println(date);
        LocalDate of = LocalDate.of(2020, 02, 29);
        System.out.println(of);
        System.out.println(of.minusMonths(-1));
        System.out.println(of.plusDays(1));
        System.out.println(of);
        System.out.println(of.getDayOfYear());//一年中是第几天 此时是60
        System.out.println(of.getMonthValue());//2,不是02
        System.out.println(of.getYear());
        LocalDate parse = LocalDate.parse("2020-01-29");
//        LocalDate parse2 = LocalDate.parse("2020.01.29");//解析不了
        System.out.println(parse);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM.dd");
        String format = formatter.format(parse);
        System.out.println(format);

        LocalDate parse1 = LocalDate.parse(format, formatter);
        System.out.println(parse1);
    }
}
