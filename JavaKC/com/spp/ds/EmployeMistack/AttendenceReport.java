package com.spp.ds.EmployeMistack;

import java.util.LinkedList;
import java.util.List;

public class AttendenceReport {

    private  List<String> EntryFailure;

    public List<String> getExitFailure() {
        return exitFailure;
    }

    public void setExitFailure(List<String> exitFailure) {
        this.exitFailure = exitFailure;
    }

    private List<String> exitFailure;
    public List<String> getEntryFailure() {
        return EntryFailure;
    }

    public void setEntryFailure(List<String> entryFailure) {
        EntryFailure = entryFailure;
    }


    @Override
    public String toString() {
        return "AttendenceReport{" +
                "EntryFailure=" + EntryFailure +
                ", exitFailure=" + exitFailure +
                '}';
    }
}
