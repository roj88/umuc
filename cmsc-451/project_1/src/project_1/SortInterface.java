/*
 * filename: SortInterface.java
 * author: roland carter
 * date: 2019-07-07
 * purpose: interface
*/

package project_1;

public interface SortInterface {
    void recursiveSort(int[] list, int n) throws UnsortedException;
    void iterativeSort(int[] list) throws UnsortedException;
    int getCount();
    long getTime();
}
