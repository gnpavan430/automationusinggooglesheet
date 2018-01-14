package setup;

import java.io.IOException;

public class NewCommand {
    public static void main(String args[]) throws IOException, InterruptedException {
        String command = "cmd /c start cmd.exe";
       Process process= Runtime.getRuntime().exec("C:\\Users\\X085271\\Desktop\\app.bat");
       Thread.sleep(4000);

        Runtime.getRuntime().exec("taskkill /F /IM sdsiosloginfo.exe");

    }
}
