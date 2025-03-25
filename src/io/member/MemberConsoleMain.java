package io.member;

import io.member.impl.FileMemberRepository;
import io.member.impl.MemoryMemberRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MemberConsoleMain {

    //private static final MemberRepository repository = new MemoryMemberRepository();
    private static final MemberRepository repository = new FileMemberRepository();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("1. 회원 등록 | 2. 회원 목록 조회 | 3. 종료");
            System.out.print("선택: ");

            int choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 1 :
                    registerMember(br);
                    break;
                case 2 :
                    displayMembers();
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default :
                    System.out.println("잘못된 선택 입니다. 다시 선택하세요.");
            }
        }
    }

    private static void registerMember(BufferedReader br) throws IOException {
        System.out.print("ID 입력: ");
        String id = br.readLine();

        System.out.print("Name 입력: ");
        String name = br.readLine();

        System.out.print("Age 입력: ");
        int age = Integer.parseInt(br.readLine());

        Member newMember = new Member(id, name, age);
        repository.add(newMember);
        System.out.println("회원이 성공적으로 등록 되었습니다: " + newMember);
    }

    private static void displayMembers() {
        List<Member> members = repository.findAll();
        System.out.println("회원 목록 : ");
        for (Member member : members) {
            System.out.printf("[ID: %s, Name: %s, Age: %d]\n", member.getId(), member.getName(), member.getAge());
        }
    }
}
