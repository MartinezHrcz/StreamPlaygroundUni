package countries;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Country> countries = new CountryRepository().getAll();
        //feladat1(countries);
        //feladat2(countries);
        //System.out.println(feladat4(countries));
        //System.out.println(feladat5(countries));
        //System.out.println(feladat6(countries));
        //feladat7(countries);
        //System.out.println(feladat8(countries));
        //System.out.println(feladat9(countries));
        //feladat10(countries);
        //System.out.println(feladat12(countries));
        //System.out.println(feladat16(countries));
        //feladat17(countries);
        //System.out.println(feladat20(countries));
        //System.out.println(feladat21(countries));
        //----------------------------------------------------------------
        //3.Feladatsor: redukciós műveletek
        //System.out.println(feladat31(countries));
        //feladat32(countries);
        //System.out.println(feladat33(countries));
        //System.out.println(feladat34(countries));
        //System.out.println(feladat35(countries));
        //System.out.println(feladat36(countries));
        //System.out.println(feladat37(countries));

    }
    public static Country feladat31(List<Country> countries) {
        return countries.stream()
                .filter(country -> country.area() != null)
                .max(Comparator.comparing(Country::area))
                .get();
    }

    public static void feladat32(List<Country> countries) {
        countries.stream()
                .filter(country -> country.area() == null)
                .forEach(System.out::println);
    }
    public static DoubleSummaryStatistics feladat33(List<Country> countries) {
        return countries.stream()
                .map(country -> country.area())
                .filter(Objects::nonNull)
                .mapToDouble(BigDecimal::doubleValue)
                .summaryStatistics();
    }
    public static String feladat35(List<Country> countries) {
        return  countries.stream()
                .map(country -> country.name())
                .sorted().collect(Collectors.joining(","));
    }

    public static BigDecimal feladat34(List<Country> countries) {
        return countries.stream()
                .map(country -> country.area())
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    public static Map<String, String> feladat36(List<Country> countries) {
        return countries.stream()
                .collect(Collectors.toMap(Country::code, Country::name));
    }

    public static Map<String, Country> feladat37(List<Country> countries) {
        return countries.stream()
                .collect(Collectors.toMap(Country::code, country -> country));
    }

    public static void feladat38(List<Country> countries) {
        Country hungray = feladat37(countries).get("Hu");
        countries.stream()
                .filter(x->x.population() <= hungray.population())
                .sorted(Comparator.comparing(Country::population)).forEach(country -> {
                    System.out.println(country.name() + " " + country.population());
                });
    }

    public static Map<Boolean, Long> feladat39(List<Country> countries) {
        return countries.stream()
                .collect(Collectors.partitioningBy(country-> country.region() != Region.EUROPE, Collectors.counting()));
    }

    public static Map<Region,List<Country>> feladat310(List<Country> countries){
        return countries.stream()
                .collect(Collectors.groupingBy(Country::region));
    }

    public static Map<Region,Long> feladat311(List<Country> countries){
        return countries.stream()
                .collect(Collectors.groupingBy(Country::region,Collectors.counting()));
    }
    public static Map<Region,Double> feladat313(List<Country> countries){
        return countries.stream()
                .collect(Collectors.groupingBy(Country::region,Collectors.averagingLong(Country::population)));
    }

    //---------------------------------------------------
    public static void feladat1(List<Country> countries) {
        countries.stream()
                .map(country -> country.name())
                .forEach(System.out::println);
    }

    public static void feladat2(List<Country> countries) {
        countries.stream()
                .map(country -> country.capital())
                .sorted(Comparator.nullsFirst(Comparator.naturalOrder()))
                .forEach(System.out::println);
    }

    public static long feladat4(List<Country> countries) {
        return countries.stream()
                .mapToLong(Country::population)
                .max()
                .getAsLong();
    }

    public static double feladat5(List<Country> countries) {
        return countries.stream()
                .mapToLong(Country::population)
                .average()
                .getAsDouble();
    }

    public static LongSummaryStatistics feladat6(List<Country> countries) {
        return countries.stream()
                .mapToLong(Country::population)
                .summaryStatistics();
    }

    public static void feladat7(List<Country> countries) {
        countries.stream().filter(country -> country.region() == Region.EUROPE)
                .map(Country::name)
                .forEach(System.out::println);
    }

    public static long feladat8(List<Country> countries) {
        return countries.stream().filter(country -> country.region() == Region.EUROPE)
                .count();
    }

    public static long feladat9(List<Country> countries) {
        return countries.stream().filter(country -> country.independent()).count();
    }

    public static void feladat10(List<Country> countries) {
        countries.stream().filter(country -> country.population() < 100).map(Country::name).forEach(System.out::println);
    }

    public static long feladat12(List<Country> countries) {
        return countries.stream()
                .filter(country -> country.region() == Region.EUROPE)
                .mapToLong(Country::population).sum();
    }

    public static String feladat16(List<Country> countries) {
        return countries.stream()
                .filter(country -> country.region() == Region.EUROPE)
                .max(Comparator.comparingLong(Country::population))
                .get().name();
    }

    public static void feladat17(List<Country> countries) {
        countries.stream()
                .map(Country::name)
                .limit(5).forEach(System.out::println);
    }

    public static boolean feladat18(List<Country> countries) {
        return countries.stream()
                .anyMatch(country -> country.population() == 0);
    }

    public static boolean feladat19(List<Country> countries) {
        return countries.stream()
                .allMatch(country -> country.timezones().size() > 0);
    }

    public static Country feladat20(List<Country> countries) {
        return countries.stream()
                .filter(country -> country.name().startsWith("H"))
                .findFirst().get();
    }

    public static long feladat21(List<Country> countries) {
        return countries.stream()
                .flatMap(country -> country.timezones().stream()).distinct().count();
    }
}
