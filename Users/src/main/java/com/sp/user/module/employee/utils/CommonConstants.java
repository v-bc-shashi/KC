package com.sp.user.module.employee.utils;

import java.time.format.DateTimeFormatter;
import java.util.Map;

public class CommonConstants {
    public static final String COLUMN_CREATION_USER_ID="CREATION_USER_ID";
    public static final String COLUMN_UPDATE_USER_ID="UPDATE_USER_ID";
    public static final String COLUMN_CREATION_DATE="CREATION_DATE";
    public static final String COLUMN_LAST_UPDATE_DATE="LAST_UPDATE_DATE";
    public static final String COLUMN_ACTIVE_FLAG="ACTIVE";
    public static final Map<String, String> SUCCESS_RESPONSE = Map.of("status", "success");
    public static final String TABLE_COUNTRIES = "COUNTRIES";
    public static final String COLUMN_COUNTRY_ID = "COUNTRY_ID";
    public static final String TABLE_CITIES = "CITIES";
    public static final String COLUMN_ATTACHMENT = "ATTACHMENT";
    public static final String COLUMN_DOCUMENT_TYPE_ID = "DOCUMENT_TYPE_ID";
    public static final String COLUMN_DOCUMENT_TYPE_ID_REF = "DOCUMENT_TYPE_ID_REF";
    public static final String COLUMN_DOCUMENT_EXPIRY_DATE = "DOCUMENT_EXPIRY_DATE";
    public static final String COLUMN_DOCUMENT_ISSUE_DATE = "DOCUMENT_ISSUE_DATE";
    public static final String COLUMN_TRANSACTION_ID = "TRANSACTION_ID";
    public static final String RESERVATION = "RESERVATION";
    public static final String DEFAULT_DATE_PATTERN = "dd-MM-yyyy";
    public static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN);
    public static final String MASS_SAVE_OR_UPDATE_RETURN_STR = "Mass Save or Update Completed Successfully";
    public static final String INTEGRATION_VIOLATION_MSG_STR= "Kindly provide the correct data then proceed for Save ";
    public static final String RECORD_ALREADY_UPDATED = "Record already entered, Kindly contact admin to update";
    public static final String RECORD_CREATED_SUCCESSFULLY = "Record saved successfully";
    public static final String RECORD_NOT_FOUND_TO_UPDATE = "Record not found to update, Kindly create the record";
    public static final String MISSING_REQUIRED_FIELDS = "Missing Required Fields";


}
