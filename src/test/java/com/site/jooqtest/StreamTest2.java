package com.site.jooqtest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import org.junit.Test;

public class StreamTest2 {

  @Test
  public void test1() {
    Person p1 = new Person("1", "name1", "age1");
    Person p2 = new Person("2", "name2", "age2");
    Person p3 = new Person("3", "name3", "age3");
    Person p4 = new Person("1", "name1", "age1");
    Person p5 = new Person("21", "name2", "age22");
    Person p6 = new Person("31", "name3", "age3");
    List<Person> list1 = Arrays.asList(p1, p2, p3);
    List<Person> list2 = Arrays.asList(p4, p5, p6);

    Function<Person,List<Object>> toKey=p -> Arrays.asList(p.getName(), p.getAge());

    list1.stream().map(toKey)
        .flatMap(key -> list2.stream().map(toKey).filter(key::equals))
        .forEach(key -> System.out.println("{name="+key.get(0)+", age="+key.get(1)+"}"));
  }

}

class Person {

  String id;
  String name;
  String age;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public Person(String id, String name, String age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }
}
