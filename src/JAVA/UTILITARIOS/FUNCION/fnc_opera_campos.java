package JAVA.UTILITARIOS.FUNCION;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import org.apache.commons.codec.binary.Base64;

public class fnc_opera_campos {

    public boolean cant_caracter(String dato, int op, int caracteres) {
        /* TIPO OPERACION
        0 = menor igual
        1 = mayor igual
        2 = menor
        3 = mayor
        4 = igual
        5 = mayor que menor que
         */
        boolean resp = false;
        switch (op) {
            case 0:
                if (dato.length() <= caracteres) {
                    resp = true;
                }
                break;
            case 1:
                if (dato.length() >= caracteres) {
                    resp = true;
                }
                break;
            case 4:
                if (dato.length() == caracteres) {
                    resp = true;
                }
                break;
        }

        return resp;
    }
    
    public boolean campo_blanco(JTextField txt_campo) {
        boolean resp = false;
        String dato = txt_campo.getText().trim();
        if (!dato.equalsIgnoreCase("")) {
            resp = true;
        }
        return resp;
    }
    
    public String completa_digitos(String dato, String valor, int cant) {
        String resp = dato;
        for (int i = dato.length(); i < cant; i++) {
            resp = valor + resp;
        }
        return resp;
    }
    
    public String recupera_fecha_formato(String dato) {
        String fecha = (dato.substring(8, 10)) + "/" + (dato.substring(5, 7)) + "/" + (dato.substring(0, 4));
        return fecha;
    }
    
    public String get_mac(byte[] mac) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
        }
        return sb.toString();
    }
    
    public void ancho_columna(JTable tabla, int posicion,int valor) {
        TableColumn columna = tabla.getColumnModel().getColumn(posicion );
        columna.setMaxWidth(valor);
        columna.setMinWidth(valor);
        columna.setPreferredWidth(valor);
        tabla.doLayout();
    }
    
    public String encriptar(String dato) {
        String secretKey = "CaDmXD";
        String base64EncryptedString = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = dato.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
        }
        return base64EncryptedString;
    }

    public String desencriptar(String dato) {
        String secretKey = "CaDmXD";
        String base64EncryptedString = "";

        try {
            byte[] message = Base64.decodeBase64(dato.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");

            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] plainText = decipher.doFinal(message);

            base64EncryptedString = new String(plainText, "UTF-8");

        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
        }
        return base64EncryptedString;
    }
}
