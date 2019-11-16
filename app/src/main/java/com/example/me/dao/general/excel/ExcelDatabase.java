package com.example.me.dao.general.excel;


public class ExcelDatabase {
    private String strPath;

    public ExcelDatabase() {
    }

    public ExcelDatabase(String strPath) {
        this.strPath = strPath;
    }

//    public HashMap<String, String> getListDataTutor(Context context) throws IOException {
//        HashMap<String, String> hashMap = new HashMap<>();
////        InputStream myInput;
//        // initialize asset manager
////        AssetManager assetManager = context.getAssets();
//        //  open excel file name as myexcelsheet.xls
////        myInput = assetManager.open("datatable.xlsx");
////        // Create a POI File System object
//////        POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
////        // Create a workbook using the File System
////        XSSFWorkbook myWorkBook = new XSSFWorkbook(myInput);
////        // Get the first sheet from workbook
////        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
//        return hashMap;
//    }

}

