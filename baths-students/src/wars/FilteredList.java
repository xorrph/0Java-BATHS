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
import java.util.stream.Collectors;
import java.util.function.Predicate;

class FilteredList<T> implements Serializable 
{
    private ArrayList<T> sourceList;

    
    /**Constructor for the fleet, initialises an ArrayList base called sourceList
     */ 
    public FilteredList() 
    {
        this.sourceList = new ArrayList<>();
    }
    
    /**Constructor for the fleet, initialises an ArrayList base called sourceList
     *@param s ArrayList of any type to be passed in and set as sourceList
     */ 
    public FilteredList(ArrayList<T> s) 
    {
        this.sourceList = s;
    }
    
    /**Add an item of any type to the source list
     *@param item of type any to be added to the source list
     */ 
    public void add(T item) 
    {
        sourceList.add(item);
    }
    
    /**Remove an item of any type from the source list
     *@param item of type any to be removed from the source list
     */ 
    public void remove(T item) 
    {
        sourceList.remove(item);
    }
    
    /**return an ArrayList of all the current items within sourceList
     *@return an ArrayList of all the current items within sourceList
     */ 
    public ArrayList<T> getAll() 
    {
        return new ArrayList<>(sourceList);
    }

    /**return an ArrayList of all the current items within sourceList with the matching condition
     *@param condition for the filter to sort from
     *@return an ArrayList of all the current items within sourceList with the matching condition
     */
    public ArrayList<T> getFiltered(Predicate<T> condition)
    {
        return sourceList.stream()
                         .filter(condition)
                         .collect(Collectors.toCollection(ArrayList::new));
    }
}

