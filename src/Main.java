import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static final int QUEUE_SIZE = 5;
    public static Random random = new Random();

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Ольга", "Толстикова", 7));
        persons.add(new Person("Оксана", "Никитенко", 4));
        persons.add(new Person("Мария", "Пластинина", 17));
        persons.add(new Person("Антон", "Семенов", 13));
        persons.add(new Person("Роман", "Папко", 11));
        persons.add(new Person("Валентин", "Матренин", 14));
        persons.add(new Person("Степан", "Демчук", 13));
        persons.add(new Person("Виорика", "Гончарова", 1));
        persons.add(new Person("Анастасия", "Калинина", 5));
        persons.add(new Person("Александр", "Скляров", 4));

        Queue<Person> queue = new LinkedList<>(generateClients(persons));
        System.out.println(queue);

        while (!queue.isEmpty()) {
            Person whoGoToAttraction = queue.poll();
            whoGoToAttraction.setTickets(whoGoToAttraction.getTickets() - 1);
            System.out.println(whoGoToAttraction + " прокатился на аттракционе! " +
                    "Билетов осталось: " + whoGoToAttraction.getTickets() + ".");
            if (whoGoToAttraction.getTickets() != 0) {
                queue.offer(whoGoToAttraction);
            }
        }
    }

    public static List<Person> generateClients(List<Person> personList) {
        int randomInt, k;
        int[] numbers = new int[QUEUE_SIZE];
        List<Person> fivePersons = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            randomInt = random.nextInt(personList.size()) + 1;
            numbers[i] = randomInt;
            for (int x = 0; x < i; x++) {
                if (numbers[x] == randomInt) {
                    i--;
                    break;
                }
            }
        }
        for (int y = 0; y < numbers.length; y++) {
            fivePersons.add(personList.get(numbers[y] - 1));
        }
        return fivePersons;
    }
}