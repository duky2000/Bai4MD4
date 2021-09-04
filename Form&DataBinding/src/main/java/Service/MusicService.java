package Service;

import Model.Category;
import Model.Music;

import java.util.ArrayList;

public class MusicService {
    public ArrayList<Music> list = new ArrayList<>();
    public MusicService(){
        list.add(new Music("a","quang trung",new Category("nhac tre"),"file"));
    }
    public void add(Music music){
        list.add(music);
    }
    public void edit(Music music,int index){
        list.set(index,music);
    }
    public void delete(int index){
        list.remove(index);
    }
}
