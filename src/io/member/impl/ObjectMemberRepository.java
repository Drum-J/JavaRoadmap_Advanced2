package io.member.impl;

import io.member.Member;
import io.member.MemberRepository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "temp/members-obj.dat";

    @Override
    public void add(Member member) {
        List<Member> members = findAll(); // 2. 그래서 여기서 findAll()로 members를 찾아오는 것
        members.add(member);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(members); // 1. List를 넣었다!!

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Object findObject = ois.readObject();

            return (List<Member>) findObject;
        } catch (FileNotFoundException e) {
            return new ArrayList<>(); // 맨 처음 add()를 할 때 여기가 반환되기 때문에 List.of()를 사용하면 안된다!
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
