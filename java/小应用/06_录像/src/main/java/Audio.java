import javax.sound.sampled.*;
import java.io.File;

public class Audio {
    public static void main(String[] args) throws Exception{
        File file=new File("R:/hello.wav");
        AudioInputStream in=AudioSystem.getAudioInputStream(file);
        AudioFormat format=in.getFormat();
        DataLine.Info info=new DataLine.Info(SourceDataLine.class,format);
        SourceDataLine auline=(SourceDataLine) AudioSystem.getLine(info);
        auline.open(format);
        auline.start();
        byte[] buffer=new byte[512];
        int len;
        while((len=in.read(buffer))>0)
            auline.write(buffer,0,len);
    }
}
