package PlayList;
import java.util.*;

public class Main {
		
	private static ArrayList<Album> albums = new ArrayList<>();

	public static void main(String[] args) {
		
		Album album = new Album("Album1", "1D");
		album.addSong("Perfect", 4.5);
		album.addSong("What makes you beautiful", 3.5);
		album.addSong("Drag me down", 5.5);
		album.addSong("18", 4.5);
		
		albums.add(album);
		
		album = new Album("Album2", "Eminem");
		album.addSong("Rap god", 4.5);
		album.addSong("Not afraid", 3.5);
		album.addSong("Loose yourself", 5.5);
		
		albums.add(album);
		
		LinkedList<Song> playList_1 = new LinkedList<>();
		albums.get(0).addToPlaylist("Perfect", playList_1);
		albums.get(1).addToPlaylist("Rap god", playList_1);
		albums.get(3).addToPlaylist("What makes you beautiful", playList_1);
		albums.get(4).addToPlaylist("Loose yourself", playList_1);
		
		play(playList_1);
	}
	
	private static void play(LinkedList<Song> playList) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listIterator = playList.listIterator();
		
		if(playList.size() == 0) {
			System.out.println("This playlist has no song");
		} else {
			System.out.println("Now playing" + listIterator.next().toString());
			printMenu();
		}
		
		while (!quit) {
			int action = sc.nextInt();
			sc.nextLine();
			
			switch (action) {
			case 0:
				System.out.println("Playlist complete");
				quit = true;
				break;
				
			case 1: 
				if(!forward) {
					if(listIterator.hasNext()) {
						listIterator.next();
					}
					forward = true;
				}
				
				if(listIterator.hasNext()) {
					System.out.println("Now playing " + listIterator.next().toString());
				} else {
					System.out.println("Reached the end of the list");
					forward = false;
				}
				
			}
		}
	}
	
	private static void printMenu() {
		System.out.println("Available options\n"+
				"0. Exit \n" + 
				"1. To play next song\n" +
				"2. To play previous song\n" + 
				"3. To replace the current song\n" + 
				"4. List of all songs\n" +
				"5. Print all available options\n" +
				"6. Delete current song");
	}
	
	private static void printList(LinkedList<Song> playList) {
		Iterator<Song> iterator = playList.iterator();
		System.out.println("----------------------------");
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("----------------------------");
	}
}

