/**
 * Цель работы: Разработать Generics класс. Продеманстрировать работу класса. 3 JUit теста. Документация в JavaDoc.
 * @author Царенко Алексей
 * Порядок работы:
 * 1. Создать класс реализующий динамический массив GenericList. Реализовать удаление, добавление, вместимость, занятость.
 * 2. Основной класс, для вывода.
 * 3. Тесты.
 */
public class Main {

    public static void main(String[] args) {

        GenericList<? super String> genericList = new GenericList<String>(10);

        System.out.println("Вместимость " + genericList.size());
        genericList.add("привеееееееееет");

        genericList.add("lol");
        genericList.add("джигурда");
        genericList.add("джигурда2");

        System.out.println("Занято " + genericList.occupied());
        for(int i = 0; i < genericList.occupied();i++){
            System.out.println(genericList.get(i));
        }
        genericList.removeByIndex(2);

        System.out.println("Занято " + genericList.occupied());
        for(int i = 0; i < genericList.occupied();i++){
            System.out.println(genericList.get(i));
        }

        genericList.removeAll();

        try{
            System.out.println(genericList.get(2));
        }catch (Exception e){
            System.out.println("Нет такого элемента");
        }
        System.out.println("Занято " + genericList.occupied());

    }

}
/**
 * Вывод: Мы реализовали динамический список в классе GenericList с основными методами.
 * Реализовано добавление коллекции, вывод коллекции, удаление из коллекции. Сделал 3 теста.
 * я научился работать с Generic классом, заключающаяся в таком описании данных и алгоритмов, которое можно
 * применять к различным типам данных, не меняя само это описание. Вспомнил как работать с jUnit и как писать JavaDoc к коду.
 */
