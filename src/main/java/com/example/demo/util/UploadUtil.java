package com.example.demo.util;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.google.gson.Gson;
import java.io.FileInputStream;

public class UploadUtil {
    private static final String ACCESS_KEY="ZPeyXAYzF-S_98CMqEpJxkVZQG4VFK5_3svLyn9E";
    private static final String SECRET_KEY="bz9CO0Ujvm8i5ufaAxesI01OFCu0WnRqa8ZEg4LW";
    //    private static final String DOMAIN="http://qb876xjwm.bkt.clouddn.com";
    private static final String DOMAIN="http://file.jwargrave.com";
    private static final String BUCKET_NAME="jwargrave";
    public static String uploadFile(FileInputStream file, String key) {
        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        try {
            Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
            String upToken = auth.uploadToken(BUCKET_NAME);
            try {
                Response response = uploadManager.put(file, key, upToken, null, null);
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                return DOMAIN + "/" + putRet.key;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ignored) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
