package com.spp.ds.EmployeMistack;

import java.util.LinkedList;
import java.util.List;

public class AttendenceMistack {

    public AttendenceReport getAttendenceReport(String[][] records){
        AttendenceReport reports= null;
        if(records.length<=0){
            System.out.println("No record found to processs");
            return reports;
        }else{
            reports = new AttendenceReport();
            List<String> entryFailure= new LinkedList<String>();
            List<String> exitFailure= new LinkedList<String>();
            for(int i=0; i<records.length; i++) {
                String empName = records[i][0];
                String entryType = records[i][1];
               if (!entryType.equals("DONE")) {
                    if (entryType.equals("exit")) {
                        entryFailure.add(empName);
                    } else {
                        for (int j = i + 1; j < records.length; j++) {
                            String empName2 = records[j][0];
                            String entryType2 = records[j][1];
                            if (empName2.equals(empName)){
                                if(entryType2.equals("enter")) {
                                    exitFailure.add(empName);
                                }else{
                                    records[j][1]="DONE";
                                }
                            }

                        }
                    }
                }
            }
            reports.setEntryFailure(entryFailure);
            reports.setExitFailure(exitFailure);
        }


        return reports;
    }

}
