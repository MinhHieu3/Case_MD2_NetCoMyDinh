package services;

public interface IManager <T>{
    void add(T add);
    void edit(int n , T edit);
    void delete(int n);
    T search(int n);
    void showAll();
}
