package countries;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.math.BigDecimal.ONE;

public class Runner {
    public static void main(String[] args) {
        List<Country> countries = new CountryRepository().getAll();
        //System.out.println(Fel1(countries));
        //Fel3(countries);
        //System.out.println(Fel6(countries));
        //Fel7(countries);
        //System.out.println(Fel9(countries));
        //Fel10(countries);
        //Fel11(countries);
        //System.out.println(Fel12(countries));
        //System.out.println(Fel13(countries));
        //Fel15(countries);
        Fel16(countries);
    }
    public static boolean Fel1(List<Country> countries) {
        return countries.stream()
                .map(Country::name)
                .anyMatch(name -> name.toLowerCase().contains("island"));
    }
    public static Optional<String> Fel2(List<Country> countries) {
        return countries
                .stream()
                .filter(x->x.name().toLowerCase().contains("island"))
                .map(Country::name)
                .findFirst();
    }
    public static void Fel3(List<Country> countries) {
        countries.stream()
                .filter(x->x.name().toLowerCase().charAt(0) == x.name().toLowerCase().charAt(x.name().length()-1))
                .map(Country::name).forEach(System.out::println);
    }

    public static void Fel4(List<Country> countries) {
        countries.stream()
                .sorted(Comparator.comparing(Country::population))
                .limit(10)
                .forEach(System.out::println);
    }

    public static void Fel5(List<Country> countries) {
        countries.stream()
                .sorted(Comparator.comparing(Country::population))
                .limit(10)
                .map(Country::name).forEach(System.out::println);
    }

    public static IntSummaryStatistics Fel6(List<Country> countries) {
        return countries.stream()
                .mapToInt(country->country.translations().size())
                .summaryStatistics();

    }

    public static void Fel7(List<Country> countries) {
        countries.stream()
                .sorted(Comparator.comparing(country -> country.timezones().size()))
                .forEach(
                        x->{
                            System.out.println(x.name() + " " + x.timezones().size());
                        }
                );
    }

    public static void Fel8(List<Country> countries) {
        countries.stream()
                .sorted(Comparator.comparing(country -> country.timezones().size()))
                .forEach(
                        x->{
                            System.out.println(x.name() + " " + x.timezones().size());
                        }
                );
    }

    public static long Fel9(List<Country> countries) {
        return countries.stream()
                .filter(x -> !x.translations().keySet().contains("fa"))
                .count();
    }

    public static void Fel10(List<Country> countries) {
        countries.stream()
                .filter(x->x.area() ==null)
                .forEach(x->
                        System.out.println(x.name() + " " + x.area())
                );
    }

    public static void Fel11(List<Country> countries) {
        countries.stream()
                .flatMap(x->x.translations().keySet().stream())
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    public static long Fel12(List<Country> countries) {
        return countries.stream()
                .map(x->x.name().length())
                .collect(Collectors.averagingInt(Integer::intValue)).longValue();
    }

    public static Country Fel13(List<Country> countries) {
        return countries.stream()
                .filter(country -> country.area() != null)
                .sorted(Comparator.comparing(Country::area).reversed())
                .findFirst().get();
    }

    public static void Fel15(List<Country> countries){
        countries.stream()
                .filter(x->x.area() != null)
                .filter(country -> country.area().compareTo(BigDecimal.ONE) == -1)
                .sorted(Comparator.comparing(Country::area))
                .forEach(System.out::println);
    }

    public static void Fel16(List<Country> countries){
        countries.stream()
                .filter(x->x.region() == Region.ASIA)
                .flatMap(x->x.timezones().stream())
                .distinct()
                .forEach(System.out::println);
    }
}
