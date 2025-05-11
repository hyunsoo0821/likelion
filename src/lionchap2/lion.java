package lionchap2;

import java.util.*;

public class lion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> todos = new TreeMap<>();
        int nextId = 1;

        while (true) {
            System.out.print("명령) ");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "exit":
                    System.out.println("앱 종료 명령이 입력되었습니다.");
                    System.out.println("프로그램이 곧 종료합니다.");
                    return;

                case "add":
                    System.out.print("할일 : ");
                    String task = scanner.nextLine().trim();

                    // 사용자가 숫자를 입력했는지 확인
                    try {
                        int userId = Integer.parseInt(task);
                        if (!todos.containsKey(userId)) {
                            nextId = userId; // 사용자가 입력한 숫자를 ID로 설정
                        } else {
                            System.out.println(userId + "번 할일은 이미 존재합니다. 자동으로 새로운 번호를 설정합니다.");
                            nextId = Collections.max(todos.keySet()) + 1;
                        }
                    } catch (NumberFormatException e) {
                        // 숫자가 아니면 기존 방식대로 새로운 ID 설정
                        if (!todos.isEmpty()) {
                            nextId = Collections.max(todos.keySet()) + 1;
                        }
                    }

                    todos.put(nextId, task);
                    System.out.println(nextId + "번 할일이 생성되었습니다.");
                    nextId++; // 다음 번호 증가
                    break;

                case "list":
                    System.out.println("번호 / 내용");
                    for (Map.Entry<Integer, String> entry : todos.entrySet()) {
                        System.out.println(entry.getKey() + " / " + entry.getValue());
                    }
                    break;

                case "del":
                    System.out.print("삭제할 할일의 번호 : ");
                    String delInput = scanner.nextLine().trim();
                    try {
                        int delId = Integer.parseInt(delInput);
                        if (todos.containsKey(delId)) {
                            todos.remove(delId);
                            System.out.println(delId + "번 할일이 삭제되었습니다.");
                        } else {
                            System.out.println(delId + "번 할일은 존재하지 않습니다.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("잘못된 번호입니다.");
                    }
                    break;

                case "modify":
                    System.out.print("수정할 할일의 번호 : ");
                    String modInput = scanner.nextLine().trim();
                    try {
                        int modId = Integer.parseInt(modInput);
                        if (todos.containsKey(modId)) {
                            System.out.println("기존 할일 : " + todos.get(modId));
                            System.out.print("새 할일 : ");
                            String newTask = scanner.nextLine().trim();
                            todos.put(modId, newTask);
                            System.out.println(modId + "번 할일이 수정되었습니다.");
                        } else {
                            System.out.println(modId + "번 할일은 존재하지 않습니다.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("잘못된 번호입니다.");
                    }
                    break;

                default:
                    System.out.println("알 수 없는 명령입니다.");
            }
        }
    }
}



