package Adapter;

import java.util.ArrayList;

public class ArrayAdapter<MyClass> implements Target{
    
    private MyClass[] myArray;
    
    public ArrayAdapter (MyClass[] myArray){
        this.myArray = myArray;
    }

    @Override
    public ArrayList<MyClass> convertedArrayList() {
        ArrayList<MyClass> myArrayList = new ArrayList<MyClass> ();
        int lentgh = myArray.length;
        for (int i = 0; i < lentgh; i++)
            myArrayList.add(myArray[i]);
        return myArrayList;
    }
    
}
