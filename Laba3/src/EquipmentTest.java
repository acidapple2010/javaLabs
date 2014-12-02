import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/* Задание: Сделать 12 юнит тестов к своей лабораторной работе 2.
*
* @After обозначает методы, которые будут вызваны после выполнения теста, методы должны быть public void.
* @Before обозначает методы, которые будут вызваны до исполнения теста, методы должны быть public void.
* @Test обозначает тестовые методы. Как и ранее, эти методы должны быть public void.
* Здесь размещаются сами проверки. Кроме того, у данной аннотации есть два параметра,
* expected — задает ожидаемое исключение и timeout — задает время, по истечению которого тест считается провалившимся.
*/
public class EquipmentTest {

    public static ArrayList<Equipment> guns1 = new ArrayList<Equipment>();

    public static void addGuns1() {
        guns1.add(new Equipment("Массового поражения", "Ядерное", "Атомная"));
        guns1.add(new Equipment("Обычное", "Огнестрельное", "Автормат"));
        guns1.add(new Equipment("Массового поражения", "Химическое", "Мартонит"));
        guns1.add(new Equipment("Обычное", "Ракетное", "Фау-1"));
        guns1.add(new Equipment("Обычное", "Травматическое", "ПБ-4 ОСА"));
        guns1.add(new Equipment("Массового поражения", "Химическое", "Хлорацетофенон"));
        guns1.add(new Equipment("Обычное", "Огнестрельное", "ПП Шпагина-41"));
        guns1.add(new Equipment("Обычное", "Травматическое", "ПБ-4 ОСА"));
        guns1.add(new Equipment("Массового поражения", "Химическое", "Хлорацетофенон"));
        guns1.add(new Equipment("Обычное", "Огнестрельное", "ПП Шпагина-41"));
    }

    @After
    public void tearDown() throws Exception { }

    @BeforeClass
    public static void setUp() throws Exception {
        Equipment.addGuns();
    }

    @Test //(expected = Exception.class)
    public void test0_0() {
        try {
            Equipment.guns.get(50).toString();
            fail();
        }
        catch(Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    @Test(expected = Exception.class)
    public void test0_1() throws Exception {
        addGuns1();
        guns1.get(11).toString();
    }

    @Ignore
    @Test
    public void test0_2() throws Exception {
        assertTrue(true);
        System.out.println();
        //fail("Ignore");
    }

    @Test
    public void test0_3() throws Exception {
        assertFalse("assert not null passed", false);
    }

    @Test
    public void test0_4() throws Exception {
        assertEquals(Equipment.guns.size() , 7);
    }

    @Test
    public void test0_5() throws Exception {
        Equipment.newGuns();
        assertSame(guns1.size(), Equipment.guns.size());
        System.out.println(guns1.size());
    }

    @Test(timeout = 15)
    public void test0_6() throws InterruptedException {
        Thread.sleep(10);
    }

    @Test
    public void test0_7() throws Exception {
        assertNotNull("assert not null passed", Equipment.newGuns);
        System.out.println(Equipment.newGuns.size());
    }

    @Test
    public void test0_8() throws Exception {
        assertNotNull("assert not null passed", Equipment.guns);
    }

    @Test
    public void test0_9() throws Exception {
        Equipment.remove();
        assertNotSame(Equipment.guns.size(), 10);
        System.out.println(Equipment.guns.size());
    }

    @Test
    public void test1_0() throws Exception {
        assertNotSame(guns1.size(), Equipment.guns.size());
    }

    @Test
    public void test1_1() throws Exception {
        assertNotNull(Equipment.guns);
    }

}

/** Заключение
* В данной лабораторной работе я научился тестировать
* с использованием библиотеки JUNIT4 для модульного
* программного обеспечения
* Научился отлавливать исключения и
* Изучил ФУНКЦИОНАЛЬНОСТЬ, такую как
junit.framework.Assert
assertEquals
assertFalse
assertNotNull
assertNull
assertNotSame
assertSame
assertTrue
junit.framework.TestCase extends junit.framework.Assert
run
setUp
tearDown
assertEquals() использует метод equals(), если он определен.
Таким образом, можно использовать свой принцип сравнения объектов.
Если он не определен - работает как assertSame().
assertSame() просто сравнивает объекты при помощи оператора ==,
то есть проверяет, являются ли параметры ссылками на один и тот же объект.
Отсюда следует, что для параметров типа Object разницы нет.
*
*
*
*/


