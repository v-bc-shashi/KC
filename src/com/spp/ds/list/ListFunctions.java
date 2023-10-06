package com.spp.ds.list;

public class ListFunctions {

    public void printTheList(Node list){
        System.out.println("-----------------------------------------------");
         if(list==null){
             return;
         }else{
             while(list!=null){
                 System.out.print(list.data +" -> ");
                 list=list.next;
             }
         }
        System.out.println("\n-----------------------------------------------");
    }

    public Node interstAtBegining(Node list, int data){
        Node newNode = new Node(data);
        newNode.next= list;
        return newNode;
    }
}
