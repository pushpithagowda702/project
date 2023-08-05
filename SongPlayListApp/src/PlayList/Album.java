package PlayList;
import java.util.*;


public class Album {
	private String albumName;
	private String artist;
	private ArrayList<Song> songs; 
	public Album(String albumName, String artist) {
		this.albumName = albumName;
		this.artist = artist;
		this.songs = new ArrayList<Song>();
	}
	
	public Album() {
		
	}
	
	public boolean addSong(String title, double duration) {
		if (findSong(title) == null) {
			songs.add(new Song(title, duration));
			System.out.println("Song added to the list");
			return true;
		}
		
		System.out.println("Song already exists in the playlist");
		return false;
	}
	
	public Song findSong(String title) {
		for(Song checkedSong : songs) {
			if(checkedSong.getTitle() == title) {
				return checkedSong;
			}
		}
		return null;
	}
	
	public boolean addToPlaylist(int trackNumber, LinkedList<Song> playList) {
		int index = trackNumber - 1;
		if(index > 0 && index <= this.songs.size()) {
			playList.add(this.songs.get(index));
			return true;
		}
		System.out.println("Song doesn't exist");
		return false;
	}
	
	public boolean addToPlaylist(String title, LinkedList<Song> playList) {
		for(Song checkedSong : this.songs) {
			if(checkedSong.getTitle().equals(title)) {
				playList.add(checkedSong);
				return true;
			}
		}
			System.out.println("Song doesn't exists");
			return false;
	}
}
