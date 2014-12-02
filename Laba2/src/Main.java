
import java.util.*;

public class Main{

    private static ArrayList<Equipment> guns = new ArrayList<Equipment>();

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
    }

    /**
     *  Добавление всех элементов в коллекцию
     */
    private static void addGuns(){
        guns.add(new Equipment("Массового поражения", "Ядерное", "Атомная"));
        guns.add(new Equipment("Обычное", "Огнестрельное", "Автормат"));
        guns.add(new Equipment("Массового поражения", "Химическое", "Мартонит"));
        guns.add(new Equipment("Обычное", "Ракетное", "Фау-1"));
        guns.add(new Equipment("Обычное", "Травматическое", "ПБ-4 ОСА"));
        guns.add(new Equipment("Массового поражения", "Химическое", "Хлорацетофенон"));
        guns.add(new Equipment("Обычное", "Огнестрельное", "ПП Шпагина-41"));
    }

    /**
     * Сортировка для макс элем
     * @return gunComparator отсортированный масс
     */

    private static Comparator<Equipment> sorting(){

        Comparator<Equipment> gunComparator = new Comparator<Equipment>() {
            @Override
            public int compare(Equipment o1, Equipment o2) {
                return String.valueOf(o1).compareTo(String.valueOf(o2));
            }
        };
        return gunComparator;
    }

    /**
     * Нахождение макс элемента
     */
    private static void max(){

        System.out.println("max: " + Collections.max(guns, sorting()));
        System.out.println();
    }

    /**
     * Вывод отсортированных данных
     */
    private static void sortCall(){
        Object[] gunArray = guns.toArray();
        Arrays.sort(gunArray);
        System.out.println(Arrays.asList(gunArray));
        System.out.println();
    }

    /**
     * Удаление
     */
    private static void remove(){
        guns.remove(2);
        guns.remove(3);
    }

    /**
     * Добавление новых
     */
    private static void newGuns(){
        ArrayList<Equipment> newGuns = new ArrayList<Equipment>();
        newGuns.add(new Equipment("Обычное", "Ракетное", "Фау-1"));
        newGuns.add(new Equipment("Массового поражения", "Ядерное", "Водородная"));
        newGuns.add(new Equipment("Обычное", "Травматическое", "ИЖ-79-9Т Макарыч"));
        guns.addAll(newGuns);
        System.out.println();
    }

    /**
     * Вывод коллекции
     */
    private static void Output() {
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
}