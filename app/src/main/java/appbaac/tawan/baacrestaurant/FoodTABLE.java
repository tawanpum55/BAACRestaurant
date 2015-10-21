package appbaac.tawan.baacrestaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by BAAC on 19/10/2015.
 */
public class FoodTABLE {   //class ดูแล table ชื่อ food

    //Explicit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String FOOD_TABLE = "foodTABLE";
    public static final String COLUMN_ID_FOOD = "_id";
    public static final String COLUMN_FOOD = "Food";
    public static final String COLUMN_SOURCE = "Source";
    public static final String COLUMN_PRICE = "Price";



    public FoodTABLE(Context context) {
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    }   //Constructor

    //211058
    public  String[] readAllData(int intType) {

        String[] strResult = null;

            Cursor objCursor = readSqLiteDatabase.query(FOOD_TABLE,
                    new String[]{COLUMN_ID_FOOD, COLUMN_FOOD, COLUMN_SOURCE, COLUMN_PRICE},
                    null, null, null, null, null);

        Log.d("baac", "getCount == " + Integer.toString(objCursor.getCount()));



            if (objCursor != null) {

                objCursor.moveToFirst();
                strResult = new String[objCursor.getCount()];

                for (int i = 0; i < objCursor.getCount(); i++) {
                    switch (intType) {
                        case 0:
                            strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_FOOD));
                            break;
                        case 1:
                            strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_SOURCE));
                            break;
                        case 2:
                            strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_PRICE));
                            break;
                        default:
//                            strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_FOOD));
                            break;
                    }   //switch

                    objCursor.moveToNext();

                }   //for

            }  //if

        objCursor.close();
        return strResult;

    }   //Read all

    public long addNewFood(String strFood, String strSource, String strPrice) {

        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_FOOD, strFood);
        objContentValues.put(COLUMN_SOURCE, strSource);
        objContentValues.put(COLUMN_PRICE, strPrice);

        return writeSqLiteDatabase.insert(FOOD_TABLE, null, objContentValues);

    }

}   // Main Class
