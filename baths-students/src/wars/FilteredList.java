/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author nagli
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.function.Predicate;

class FilteredList<T> implements Serializable 
{
    private ArrayList<T> sourceList;

    public FilteredList() 
    {
        this.sourceList = new ArrayList<>();
    }
    
    public FilteredList(ArrayList<T> s) 
    {
        this.sourceList = s;
    }

    public void add(T item) 
    {
        sourceList.add(item);
    }

    public void remove(T item) 
    {
        sourceList.remove(item);
    }

    public ArrayList<T> getAll() 
    {
        return new ArrayList<>(sourceList);
    }

    public ArrayList<T> getFiltered(Predicate<T> condition)
    {
        return sourceList.stream()
                         .filter(condition)
                         .collect(Collectors.toCollection(ArrayList::new));
    }
}

