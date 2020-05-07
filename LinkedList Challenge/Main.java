package com.company;

import sun.awt.image.ImageWatched;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Create a program that implements a playlist for songs
        // Create a Song class having Title and Duration for a song.
        // The program will have an Album class containing a list of songs.
        // The albums will be stored in an ArrayList
        // Songs from different albums can be added to the playlist and will appear in the list in the order
        // they are added.
        // Once the songs have been added to the playlist, create a menu of options to:-
        // Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
        // List the songs in the playlist
        // A song must exist in an album before it can be added to the playlist (so you can only play songs that
        // you own).
        // Hint:  To replay a song, consider what happened when we went back and forth from a city before we
        // started tracking the direction we were going.
        // As an optional extra, provide an option to remove the current song from the playlist
        // (hint: listiterator.remove()

        ArrayList<Album> albums = new ArrayList<>();

        Album album = new Album("Lover", "Taylor Swift");
        album.addSong("I Forgot That You Existed", 2.51);
        album.addSong("Cruel Summer", 2.58);
        album.addSong("The Man", 3.10);
        album.addSong("The Archer", 3.31);
        album.addSong("Miss Americana & the Heartbreak Prince", 3.54);
        album.addSong("London Boy", 3.10);
        album.addSong("You Need to Calm Down", 2.51);
        album.addSong("Me!", 3.13);
        albums.add(album);

        album = new Album("Changes", "Justin Bieber");
        album.addSong("All Around Me", 2.16);
        album.addSong("Habitual", 2.48);
        album.addSong("Intentions", 3.32);
        album.addSong("Yummy", 3.28);
        album.addSong("Forever", 3.39);
        album.addSong("Get Me", 3.05);
        album.addSong("Confirmation", 2.50);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("The Man", playList);
        albums.get(0).addToPlayList("Miss Americana & the Heartbreak Prince", playList);
        albums.get(0).addToPlayList(7, playList);
        albums.get(0).addToPlayList(8, playList);
        albums.get(0).addToPlayList("Lover", playList); // does not exist

        albums.get(1).addToPlayList("Yummy", playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(12, playList); // does not exist

        play(playList);

    }

    private static void play(LinkedList<Song> playList) {
        Scanner scan = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.isEmpty())
            System.out.println("No songs in playlist");
        else {
            System.out.println("Now playing ==> " + listIterator.next().toString());
        }
        printMenu();
        while(!quit) {
            int action = scan.nextInt();
            scan.nextLine();
            switch(action) {
                case 0: // Quit
                    System.out.println("Playlist is complete");
                    quit = true;
                    break;
                case 1: //next song
                    if(!forward) {
                        if(listIterator.hasNext())
                            listIterator.next();
                        forward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Song changed to:\n " + listIterator.next().toString());
                    }
                    else {
                        System.out.println("End of playlist reached");
                        forward = false;
                    }
                    break;
                case 2: //previous song
                    if(forward) {
                        if(listIterator.hasPrevious())
                            listIterator.previous();
                        forward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Song changed to:\n " + listIterator.previous().toString());
                    }
                    else {
                        System.out.println("Start of playlist reached");
                        forward = true;
                    }
                    break;
                case 3: // replay current song
                    if(forward) { // if I was moving forward
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                            System.out.println("Replaying the song:\n " + listIterator.next().toString());
                        }
                        else
                            System.out.println("Start of playlist reached");
                    }
                    else { // if I was going backwards
                        if(listIterator.hasNext()) {
                            listIterator.next();
                            System.out.println("Replaying the song:\n " + listIterator.previous().toString());
                        }
                        else
                            System.out.println("End of playlist reached");
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() > 0) {
                        listIterator.remove();
                        if(listIterator.hasNext())
                            System.out.println("Song changed to:\n " + listIterator.next().toString());
                        else if(listIterator.hasPrevious())
                            System.out.println("Song changed to:\n " + listIterator.previous().toString());
                    }
                    break;
            }
        }

    }

    private static void printList(LinkedList<Song> playList) {
        int i = 1;
        for(Song song : playList) {
            System.out.println((i++) + ". ==> " + song.toString());
        }
    }

    private static void printMenu() {
        System.out.println("MENU");
        System.out.println("Press\n" +
                "0. Quit\n" +
                "1. Play next song\n" +
                "2. Play previous song\n" +
                "3. Replay the current song\n" +
                "4. See the playlist\n" +
                "5. See the menu" +
                "6. Remove current song from the playlist");
    }

}
