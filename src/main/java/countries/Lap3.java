package countries;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Lap3 extends CountryRepository {
    public static void main(String[] args) {
        var countrier = new Lap3();
        List<Country> countries = countrier.getAll();
        //System.out.println(Feladat1(countries));
        //System.out.println(Feladat3(countries));
        //System.out.println(Feladat5(countries));
        //System.out.println(Feladat6(countries));
        //System.out.println(Feladat7(countries));
        //Feladat8(countries);
        //System.out.println(Feladat9(countries));
        //System.out.println(Feladat10(countries));
        //System.out.println(Feladat11(countries));
        //Feladat12(countries);
        System.out.println(Feladat13(countries));
        Feladat14(countries).entrySet().stream().forEach(x-> System.out.println(x.getKey() + " " + x.getValue().get().name()));
    }

    public static Map<Region,Optional<Country>> Feladat14(List<Country> countries) {
        return countries
                .stream()
                .collect(Collectors.groupingBy(country->country.region(), Collectors.maxBy(Comparator.comparingLong(Country::population))));
    }


    public static Map<Region,Double> Feladat13(List<Country> countries) {
        return countries
                .stream()
                .collect(Collectors.groupingBy(country -> country.region(), Collectors.averagingLong(Country::population)));
    }

    public static void Feladat12(List<Country> countries) {
        Feladat11(countries).forEach((Region,in)-> System.out.println(Region+" "+in));

    }
    public static Map<Region,List<Country>> Feladat10(List<Country> countries){
        return countries
                .stream()
                .collect(Collectors.groupingBy(Country::region));
    }
    public static Map<Region,Long> Feladat11(List<Country> countries){
        return countries
                .stream()
                .collect(Collectors.groupingBy(Country::region, Collectors.counting()));
    }
    public static Map<Boolean,Long> Feladat9(List<Country> countries) {
        return countries.stream()
                .collect(Collectors.partitioningBy(country-> country.region() == Region.EUROPE, Collectors.counting()));

    }
    public static void Feladat8(List<Country> countries) {
        countries.stream()
                .filter(x->(x.population() <= Feladat7(countries).get("HU").population()))
                .sorted(Comparator.comparingLong(Country::population))
                .forEach(x-> System.out.println(x.name() + " " + x.population()));
    }

    public static Map<String,Country> Feladat7(List<Country> countries) {
        return countries.stream()
                .collect(Collectors.toMap(Country::code,country -> country));

    }

    public static Map<String,String> Feladat6(List<Country> countries) {
        return countries.stream()
                .collect(Collectors.toMap(Country::name,Country::code));
    }

    public static String Feladat5(List<Country> countries) {
        return
                countries.stream()
                        .map(Country::name)
                        .sorted()
                        .collect(Collectors.joining(", "));
    }

    public static BigDecimal Feladat4(Collection<Country> countries) {
        return countries.stream()
                .map(Country::area)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static DoubleSummaryStatistics Feladat3(List<Country> countries) {
        return countries.stream()
                .filter(x->x.area()!= null)
                .map(Country::area)
                .collect(Collectors.summarizingDouble(BigDecimal::doubleValue));
    }

    public static Country Feladat1(List<Country> countries) {
        return countries
                .stream()
                .filter(x->x.area() !=  null)
                .sorted(Comparator.comparing(Country::area).reversed())
                .findFirst()
                .get();
    }

    @Override
    public List<Country> getAll() {
        return super.getAll();
    }
}
