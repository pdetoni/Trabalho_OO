package Classes.DAO;

import java.util.ArrayList;
import java.util.List;

public class GenericDAO<T> {

    private List<T> items = new ArrayList<>();

    public void insert(T item){
        items.add(item);
    }

    public boolean update(T oldItem, T newItem){
        int index = items.indexOf(oldItem);
        if(index != -1){
            items.set(index, newItem);
            return true;
        }
        return false;
    }

    public boolean delete(T item){
        return items.remove(item);
    }

    public List<T> selectAll(){
        return items;
    }
}