/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.mail.MessagingException;
import javax.servlet.http.Part;

/**
 *
 * @author Marco
 */
public class FileUpload {

    public static String caricaFile(Part filePart, String fileName) throws IOException, MessagingException {
        OutputStream out = null;
        InputStream filecontent = null;

        try {
            String path = FileUpload.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String path2 = path.substring(1, path.indexOf("dist"));
            String path3 = path2 + "Ippocrate-war/web/img/" + fileName;
            out = new FileOutputStream(new File(path3));
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        } catch (FileNotFoundException fne) {
            System.out.println("You did not specify a file to upload");
            System.out.println("<br/> ERRORE: " + fne.getMessage());
            return "";
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
        }
        return "img/" + fileName;
    }
}
