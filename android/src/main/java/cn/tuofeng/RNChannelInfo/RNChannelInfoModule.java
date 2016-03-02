package cn.tuofeng.RNChannelInfo;

import android.content.pm.ApplicationInfo;
import android.content.Context;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.util.zip.ZipFile;
import java.util.zip.ZipEntry;
import java.util.Enumeration;

import javax.annotation.Nullable;

public class RNChannelInfoModule extends ReactContextBaseJavaModule {

  ReactApplicationContext reactContext;

  public RNChannelInfoModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNChannelInfo";
  }

  public static String getChannel(Context context) {
    ApplicationInfo appinfo = context.getApplicationInfo();
    String sourceDir = appinfo.sourceDir;
    String ret = "";
    ZipFile zipfile = null;
    try {
        zipfile = new ZipFile(sourceDir);
        Enumeration<?> entries = zipfile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = ((ZipEntry) entries.nextElement());
            String entryName = entry.getName();
            if (entryName.startsWith("META-INF/mtchannel")) {
                ret = entryName;
                break;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (zipfile != null) {
            try {
                zipfile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    String[] split = ret.split("_");
    if (split != null && split.length >= 2) {
        return ret.substring(split[0].length() + 1);

    } else {
        return "";
    }
  }

  @Override
  public @Nullable Map<String, Object> getConstants() {
    HashMap<String, Object> constants = new HashMap<String, Object>();
    constants.put("Channel", RNChannelInfoModule.getChannel(this.reactContext));
    return constants;
  }
}
