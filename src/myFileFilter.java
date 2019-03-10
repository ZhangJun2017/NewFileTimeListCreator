import java.io.File;
import java.io.FileFilter;

public class myFileFilter implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        String filename = pathname.getName();
        if (Character.isDigit(filename.charAt(0))) {
            if (Character.isDigit(filename.charAt(1))) {
                if (Character.isDigit(filename.charAt(2))) {
                    if (Character.isDigit(filename.charAt(3))) {
                        if (filename.charAt(4) == '.') {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}