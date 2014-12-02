import java.util.*;

/**
 * Created by mac on 29.10.14.
 */
public class Equipment implements Comparable<Equipment> {

    public String kind;
    public String type;
    public String model;

    public Equipment(String kind, String model, String type) {
        this.kind = kind;
        this.type = type;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Оружие {" + kind + ',' + model + ',' + type + '}';
    }

    @Override
    public int compareTo(Equipment o) {
        return toString().compareTo(o.toString());
    }

    public static ArrayList<Equipment> guns = new ArrayList<Equipment>();

    public static void addGuns() {
        guns.add(new Equipment("Массового поражения", "Ядерное", "Атомная"));
        guns.add(new Equipment("Обычное", "Огнестрельное", "Автормат"));
        guns.add(new Equipment("Массового поражения", "Химическое", "Мартонит"));
        guns.add(new Equipment("Обычное", "Ракетное", "Фау-1"));
        guns.add(new Equipment("Обычное", "Травматическое", "ПБ-4 ОСА"));
        guns.add(new Equipment("Массового поражения", "Химическое", "Хлорацетофенон"));
        guns.add(new Equipment("Обычное", "Огнестрельное", "ПП Шпагина-41"));

    }

    public  static Comparator<Equipment> sorting() {

        Comparator<Equipment> gunComparator = new Comparator<Equipment>() {
            @Override
            public int compare(Equipment o1, Equipment o2) {
                return String.valueOf(o1).compareTo(String.valueOf(o2));
            }
        };
        return gunComparator;
    }

    public static void max() {

        System.out.println("max: " + Collections.max(guns, sorting()));
        System.out.println();
    }

    public static void sortCall() {
        Object[] gunArray = guns.toArray();
        Arrays.sort(gunArray);
        System.out.println(Arrays.asList(gunArray));
        System.out.println();
    }

    public static void remove() {
        guns.remove(2);
        guns.remove(3);
    }

    public static ArrayList<Equipment> newGuns = new ArrayList<Equipment>();

    public static void newGuns() {
        newGuns.add(new Equipment("Обычное", "Ракетное", "Фау-1"));
        newGuns.add(new Equipment("Массового поражения", "Ядерное", "Водородная"));
        newGuns.add(new Equipment("Обычное", "Травматическое", "ИЖ-79-9Т Макарыч"));
        guns.addAll(newGuns);
        System.out.println();
    }

    /**
     * Вывод коллекции
     */
    public static void Output() {
        Iterator<Equipment> gunIterator = guns.iterator();
        while (gunIterator.hasNext()) {
            System.out.println(gunIterator.next());
        }

        /*
        for (Equipment eq: guns)
        {
            System.out.println(eq);

        }*/
        System.out.println();
    }

    public static void removeAll() {
        for (Equipment eq: guns)
        {
            guns.remove(eq);
        }
    }

    public static void main(String[] args) {

        System.out.println("вывод содержимого и добавление данных");
        addGuns();
        Output();

        System.out.println("вывод максимума");
        max();

        System.out.println("вывод отсортированных данных");
        sortCall();

        System.out.println("удаление элемента");
        remove();
        Output();

        System.out.println("соединение коллекций");
        newGuns();
        Output();

        System.out.println("коллекция полностью удалена");
        removeAll();
        Output();
    }
}