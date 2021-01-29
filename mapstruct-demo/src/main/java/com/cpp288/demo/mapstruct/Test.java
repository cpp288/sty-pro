package com.cpp288.demo.mapstruct;

import java.util.Date;

/**
 * test
 *
 * @author chenjian
 * @date 2021/1/29 下午2:50
 */
public class Test {

    public static void main(String[] args) {
        PersonDO person = new PersonDO();
        person.setName("Hollis");
        person.setAge(26);
        person.setBirthday(new Date());
        person.setId(1);

        PersonDTO personDTO = PersonConverter.INSTANCE.doToDto(person);

        System.out.println(person);
        System.out.println(personDTO);
    }
}
