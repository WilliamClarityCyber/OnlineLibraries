package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Movie[] movies = {
                new Movie(1, "Black Widow", "Scarlett Johansson"),
                new Movie(2, "Shang-chi and the Legend of the Ten Rings", "Spider-Man: No Way"),
                new Movie(3, "Spider-Man: No Way Home", "Tom Holland"),
                new Movie(4, "Doctor Strange in the Multiverse of Madness", "Benedict Cumberbatch"),
                new Movie(5, "Thor: Love and Thunder", "Chris Hemsworth")
        };

        ArrayList <Movie> available = new ArrayList <Movie> ();
        ArrayList <Movie> rented = new ArrayList <Movie> ();

        Movie randomMovie = movies[(int)(Math.random() * 4)];
        for (Movie m: movies) {
            if (!m.getTitle().equals(randomMovie.getTitle())) {
                available.add(m);
            }
        }
        rented.add(randomMovie);

        boolean quit = false;
        while (!quit) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Welcome! Please select from the following: \n [1]Rent \n [2]View rented items \n " +
                    "[3]Quit");
            int menuOption = scan.nextInt();

            switch (menuOption) {
                case 1:
                    boolean stillRenting = true;
                    while (stillRenting) {
                        for (Movie m: available) {
                            System.out.println(m.toString() + "\n_________");
                        }
                        boolean validChoice = false;
                        Movie movieChoice = null;
                        int index = 0;
                        do {
                            System.out.println("Enter the ID of the item you would like to rent?");
                            int choice = scan.nextInt();
                            scan.nextLine();


                            for (int i = 0; i < available.size(); i++) {
                                if (available.get(i).getUniqueIdNumber() == choice) {
                                    movieChoice = available.get(i);
                                    index = i;
                                    validChoice = true;
                                }
                            }
                        }
                        while(!validChoice);
                        validChoice = false;

                        do {
                            System.out.print("Please confirm that you are renting the following (y/n): \n" + movieChoice.toString() + "\n");
                            String confirmation = scan.nextLine();
                            if (confirmation.equals("y")) {
                                rented.add(movieChoice);
                                available.remove(index);
                                System.out.println("\n\n Rented Successfully! \n\n");
                                validChoice = true;
                            } else if (confirmation.equals("n")) {
                                validChoice = true;
                            }
                        }
                        while(!validChoice);
                        validChoice = false;
                        do {
                            System.out.println("Are you still renting (y/n)?");
                            String choice = scan.nextLine();
                            if (choice.equals("y")) {
                                stillRenting = true;
                                validChoice = true;
                            } else if(choice.equals("n")) {
                                stillRenting = false;
                                validChoice = true;
                            }
                        }
                        while(!validChoice);
                        }

                    break;
                case 2:
                    System.out.println("Rented: \n\n");
                    for (Movie m: rented) {
                        System.out.println(m.toString() + "\n\n");
                    }
                    break;
                case 3:
                    quit = true;
            }
        }
    }

}