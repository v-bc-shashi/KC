package com.spp.ds.list;

public class NewReadyMadeList {

    public static Node getNewList(){

        Node start=null;
        Node pointer =null;

        for(int i=1; i<=20; i++){
            Node newNode= new Node(i);
            if(start==null){
                start= newNode ;
                pointer=start;
            }else{
                pointer.next=newNode;
                pointer= pointer.next;
            }
        }
        return start;
    }
}
