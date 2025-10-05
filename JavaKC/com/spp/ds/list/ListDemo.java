package com.spp.ds.list;

public class ListDemo {
    public static void main(String[] args) {
        System.out.println(".....This is output..................\n");
        Node list =NewReadyMadeList.getNewList();
        ListFunctions lfcs = new ListFunctions();
        lfcs.printTheList(list);

        Node newList= lfcs.interstAtBegining(list, 100);
        lfcs.printTheList(newList);

    }
}
