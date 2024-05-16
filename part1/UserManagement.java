package part1;

import java.util.Scanner;

    class User {
        String username;
        String email;
        int age;

        User(String username, String email, int age) {
            this.username = username;
            this.email = email;
            this.age = age;
        }
    }

    class Node {
        User data;
        Node next;

        Node(User data) {
            this.data = data;
            this.next = null;
        }
    }

    class UserList {
        Node head;

        UserList() {
            this.head = null;
        }

        void addUser(User user) {
            Node newNode = new Node(user);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        void displayUsers() {
            Node current = head;
            while (current != null) {
                System.out.println("Username: " + current.data.username);
                System.out.println("Email: " + current.data.email);
                System.out.println("Age: " + current.data.age);
                System.out.println();
                current = current.next;
            }
        }

        User searchUser(String username) {
            Node current = head;
            while (current != null) {
                if (current.data.username.equals(username)) {
                    return current.data;
                }
                current = current.next;
            }
            return null;
        }

        void updateUser(String username, String newEmail, int newAge) {
            Node current = head;
            while (current != null) {
                if (current.data.username.equals(username)) {
                    current.data.email = newEmail;
                    current.data.age = newAge;
                    break;
                }
                current = current.next;
            }
        }
    }

    public class UserManagement {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            UserList userList = new UserList();

            while (true) {
                System.out.println("Menu:");
                System.out.println("1. Add new user");
                System.out.println("2. Search for a user");
                System.out.println("3. Update user data");
                System.out.println("4. Display all users");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        userList.addUser(new User(username, email, age));
                        break;
                    case 2:
                        System.out.print("Enter username to search: ");
                        String searchUsername = scanner.nextLine();
                        User searchedUser = userList.searchUser(searchUsername);
                        if (searchedUser != null) {
                            System.out.println("part1.User found:");
                            System.out.println("Username: " + searchedUser.username);
                            System.out.println("Email: " + searchedUser.email);
                            System.out.println("Age: " + searchedUser.age);
                        } else {
                            System.out.println("part1.User not found.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter username to update: ");
                        String updateUsername = scanner.nextLine();
                        System.out.print("Enter new email: ");
                        String newEmail = scanner.nextLine();
                        System.out.print("Enter new age: ");
                        int newAge = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        userList.updateUser(updateUsername, newEmail, newAge);
                        System.out.println("part1.User data updated successfully.");
                        break;
                    case 4:
                        userList.displayUsers();
                        break;
                    case 5:
                        System.out.println("Exiting program.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        }
    }