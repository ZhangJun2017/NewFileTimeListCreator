import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This is an app for creating list of NewFileTime.
 * LastModify cannot satisfy my need,so I started this project.
 *
 * @author ZhangJun
 */

public class Main {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Date base = new Date();
        HashMap<Integer, File> fileMap = new HashMap();
        ArrayList nums = new ArrayList();
        String path = "";
        String outputPath = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Path Here(It should be like \"C:\\Windows\\System32\":");
        path = scanner.nextLine();
        System.out.print("Enter Output txt Here(It should be like \"C:/output.txt\"):");
        outputPath = scanner.nextLine();
        File[] list = new File(path).listFiles(new myFileFilter());
        int i = 0;
        for (File file : list) {
            i++;
            fileMap.put(Tools.getId(file.getName()), file);
            nums.add(Tools.getId(file.getName()));

        }
        nums.sort(null);
        System.out.println("即将进行如下更改");
        System.out.println();
        for (i = 0; i < nums.size(); i++) {
            File now = fileMap.get(nums.get(i));
            System.out.println(now.getName() + " - " + new Date(now.lastModified()).toLocaleString() + " -> " + new Date(base.getTime() + (60000 * (i + 1))).toLocaleString());
        }
        System.out.println();
        System.out.print("请确认：");
        if (!scanner.nextLine().equals("yes")) {
            System.out.println("操作已取消");
            System.exit(-1);
        }
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(outputPath)), true));
        for (i = 0; i < nums.size(); i++) {
            //Just copy the code of LastModify and edit the part of operation.
            File now = fileMap.get(nums.get(i));
            System.out.println(now.getAbsolutePath() + "\t" + now.getName() + "\t" + new Date(base.getTime() + (60000 * (i + 1))).toLocaleString() + "\t" + new Date(base.getTime() + (60000 * (i + 1))).toLocaleString() + "\t" + new Date(base.getTime() + (60000 * (i + 1))).toLocaleString());
            //now.setLastModified(base.getTime() + (60000 * (i + 1)));
        }
    }
}
