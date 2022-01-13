package com.vehicledetails.rcdetails.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class RecentDBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "recentRcDB";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "recentRc";
    private static final String ID_COL = "id";
    private static final String REGNO_COL = "regNo";
    private static final String REGAUTH_COL = "regAuth";
    private static final String REGDATE_COL = "regDate";
    private static final String CHASISNO_COL = "chasis";
    private static final String ENGINENO_COL = "engine";
    private static final String FUEL_COL = "fuel";
    private static final String MODEL_COL = "model";
    private static final String MANUFACT_COL = "manufac";
    private static final String OWNER_COL= "owner";
    private static final String FINACER_COL = "finacer";
    private static final String FITNESS_COL = "fitness";
    private static final String INSURANCE_EXP_COL= "insuranceExp";
    private static final String VEHICLE_CLASS_COL = "vehicleClass";
    private static final String VEHICLE_PERMIT_COL = "vehiclePermit";
    private static final String VEHICLE_PERMIT_DATE_COL = "vehiclePermitdate";


    public RecentDBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + REGNO_COL + " TEXT,"
                + REGAUTH_COL + " TEXT,"
                + REGDATE_COL + " TEXT,"
                + CHASISNO_COL + " TEXT,"
                + ENGINENO_COL + " TEXT,"
                + FUEL_COL + " TEXT,"
                + MODEL_COL + " TEXT,"
                + MANUFACT_COL + " TEXT,"
                + OWNER_COL + " TEXT,"
                + FINACER_COL + " TEXT,"
                + FITNESS_COL + " TEXT,"
                + INSURANCE_EXP_COL + " TEXT,"
                + VEHICLE_CLASS_COL + " TEXT,"
                + VEHICLE_PERMIT_COL + " TEXT,"
                + VEHICLE_PERMIT_DATE_COL + " TEXT)";

        db.execSQL(query);

    }
    public void addNewRC(String regNo, String regAuth,String regDate, String chasis, String engine,
                             String fuel, String model, String manufact, String owner,
                             String finacer,String fitness,String insuranceExp,String vehicleClass,
                         String vehiclePermit, String vehiclePermitDate) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(REGNO_COL, regNo);
        values.put(REGAUTH_COL, regAuth);
        values.put(REGDATE_COL, regDate);
        values.put(CHASISNO_COL, chasis);
        values.put(ENGINENO_COL, engine);
        values.put(FUEL_COL, fuel);
        values.put(MODEL_COL, model);
        values.put(MANUFACT_COL, manufact);
        values.put(OWNER_COL, owner);
        values.put(FINACER_COL, finacer);
        values.put(FITNESS_COL, fitness);
        values.put(INSURANCE_EXP_COL, insuranceExp);
        values.put(VEHICLE_CLASS_COL, vehicleClass);
        values.put(VEHICLE_PERMIT_COL, vehiclePermit);
        values.put(VEHICLE_PERMIT_DATE_COL, vehiclePermitDate);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<DbModal> getRC() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorRC = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<DbModal> rcList = new ArrayList<>();
        if (cursorRC.moveToFirst()) {
            do {

                rcList.add(new DbModal(
                        cursorRC.getString(1),
                        cursorRC.getString(2),
                        cursorRC.getString(3),
                        cursorRC.getString(4),
                        cursorRC.getString(5),
                        cursorRC.getString(6),
                        cursorRC.getString(7),
                        cursorRC.getString(8),
                        cursorRC.getString(9),
                        cursorRC.getString(10),
                        cursorRC.getString(11),
                        cursorRC.getString(12),
                        cursorRC.getString(13),
                        cursorRC.getString(14),
                        cursorRC.getString(15)));


            } while (cursorRC.moveToNext());
        }
        cursorRC.close();
        return rcList;
    }
    public void deleteRC(String regNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "regNo=?", new String[]{regNo});
        db.close();
    }
        @Override
        public void onUpgrade (SQLiteDatabase db,int i, int i1){
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }

}
