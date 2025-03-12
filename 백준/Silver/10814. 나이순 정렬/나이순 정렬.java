import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static class Person implements Comparable<Person> {
        int age;
        String name;
        int order;

        Person(int age, String name, int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }
        @Override
        public int compareTo(Person o) {
            if(this.age == o.age) {
                return Integer.compare(this.order, o.order);
            }
            return Integer.compare(this.age, o.age);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] people = new Person[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            people[i] = new Person(age, name, 1);
        }
        Arrays.sort(people);
        for(Person p : people) {
            System.out.println(p.age + " " + p.name);
        }


    }

}