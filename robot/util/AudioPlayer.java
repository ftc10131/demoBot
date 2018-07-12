package ftc10131.demoBot.robot.util;

import android.content.Context;
import android.media.MediaPlayer;

import com.qualcomm.ftcrobotcontroller.R;

import java.io.IOException;

public class AudioPlayer {
  //The player handling the audio
  private static MediaPlayer mp = null;
  private static String mediaFile;

  //Start the wubs
  public static boolean init(Context context, String mediaFileName) {
// Fun things ;)
 //   MediaPlayer mp = new MediaPlayer();
    final String mediaPath = "/storage/emulated/0/Music";
    mediaFile = mediaFileName;

    try
    {
      mp = new MediaPlayer();
      mp.setDataSource(mediaPath + "/" + mediaFile);
      mp.prepare();
    }
    catch(Exception e)
    {
      return false;
    }
    return true;

  }

  public static boolean start(Context context) {
    if (mp == null) {


      try
      {
        init(context, mediaFile);
        /*
        mp = new MediaPlayer();
        final String mediaPath = "/storage/emulated/0/Music";
        mp.setDataSource(mediaPath + "/" + mediaFile);
        mp.prepare();*/
      }
      catch(Exception e)
      {
        return false;
      }
    }
    if (mp!=null) {
      mp.seekTo(0);
      mp.start();
      return true;
    }
    return false;
  }

  //Stop the wubs
  public static void stop() {
    if (mp != null) {
      mp.stop();
      mp=null;
     /* try { mp.prepare(); }
      catch (IOException e) {}*/
    }
  }
}
