package com.spp.ds.EmployeMistack;

public class EmpAttendenceDemo {

    public static void main(String[] args) {
        System.out.println("This is Working...");
        AttendenceData  dataObj = new AttendenceData();

        String[][] records= dataObj.attendenceData();

        for(int i =0; i<records.length; i++){
            System.out.println(records[i][0] + "    --->   "+records[i][1]);
        }

        AttendenceMistack processor = new AttendenceMistack();
        AttendenceReport report = processor.getAttendenceReport(records);
        System.out.println("...........................");
        System.out.println(report);

    }
}
