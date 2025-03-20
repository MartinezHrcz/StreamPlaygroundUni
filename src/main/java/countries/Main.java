package countries;
import java.util.Comparator;
import java.util.List;
import java.util.LongSummaryStatistics;

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
        System.out.println(feladat16(countries));
    }
    public static void feladat1(List<Country> countries) {
        countries.stream()
                .map(country -> country.name())
                .forEach(System.out::println);
    }
    public static void feladat2(List<Country> countries){
        countries.stream()
                .map(country -> country.capital())
                .sorted(Comparator.nullsFirst(Comparator.naturalOrder()))
                .forEach(System.out::println);
    }
    public static long feladat4(List<Country> countries){
        return countries.stream()
                .mapToLong(Country::population)
                .max()
                .getAsLong();
    }

    public static double feladat5(List<Country> countries){
        return  countries.stream()
                .mapToLong(Country::population)
                .average()
                .getAsDouble();
    }

    public static LongSummaryStatistics feladat6(List<Country> countries){
        return countries.stream()
                .mapToLong(Country::population)
                .summaryStatistics();
    }

    public static void feladat7(List<Country> countries){
        countries.stream().filter(country -> country.region() == Region.EUROPE)
                .map(Country::name)
                .forEach(System.out::println);
    }

    public static long feladat8(List<Country> countries){
        return countries.stream().filter(country -> country.region() == Region.EUROPE)
                .count();
    }

    public static long feladat9(List<Country> countries){
        return countries.stream().filter(country -> country.independent()).count();
    }

    public static void feladat10(List<Country> countries){
        countries.stream().filter(country -> country.population()<100).map(Country::name).forEach(System.out::println);
    }

    public static long feladat12(List<Country> countries){
        return countries.stream()
                .filter(country -> country.region() == Region.EUROPE)
                .mapToLong(Country::population).sum();
    }

    public static String feladat16(List<Country> countries){
        return countries.stream()
                .filter(country -> country.region() == Region.EUROPE)
                .max(Comparator.comparingLong(Country::population))
                .get().name();
    }
}
