package me.nereo.multi_image_selector.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 文件操作类
 * Created by Nereo on 2015/4/8.
 */
public class FileUtils {

    /**
     * 获取拍照照片存放根路径
     *
     * @return
     */
    public static String getPictureRootPath() {
        String path = getSdcardRoot() +
                ".daren"+ File.separator + "image";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return path;
    }

    public static String getSdcardRoot() {
        return Environment.getExternalStorageDirectory() + File.separator;
    }


    public static String getPicturePath(String fileName, String stuf) {
        return getPictureRootPath() + File.separator + fileName + "." + stuf;
    }

    public static File createTmpFile(Context context){

        String state = Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            // 已挂载
//            File pic = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA).format(new Date());
            String fileName = "multi_image_"+timeStamp+"";
            File tmpFile = new File(getPicturePath(fileName,"jpg"));
            return tmpFile;
        }else{
            File cacheDir = context.getCacheDir();
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA).format(new Date());
            String fileName = "multi_image_"+timeStamp+"";
            File tmpFile = new File(cacheDir, fileName+".jpg");
            return tmpFile;
        }

    }

}
