package countries;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Country> countries = new CountryRepository().getAll();
        feladat1(countries);
        feladat2(countries);
        System.out.println(feladat4(countries));
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
        return countries.stream().mapToLong(x->x.population())
                .max()
                .getAsLong();
    }
}
