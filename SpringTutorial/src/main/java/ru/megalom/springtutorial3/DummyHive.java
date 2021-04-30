package ru.megalom.springtutorial3;

public class DummyHive {
    Dummy dummy;

    DummyHive(Dummy dummy){
        this.dummy=dummy;
    }
    @Override
    public String toString(){
        return "Dummy hive has: "+dummy;
    }

    public void printDummy(){
        System.out.println(dummy.getName());
    }
}
